#!/usr/bin/python
import sys
import config
import psycopg2
import subprocess
from time import sleep


def run_command(command):
    print(command)

    res = subprocess.Popen(command,
                           stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE,
                           shell=True)
    #return iter(p.stdout.readline, b'')
    output,error = res.communicate()
    if output:
        print "ret> ",res.returncode
        print "OK> output ",output
        return True
    if error:
        print "ret> ",res.returncode
        print "Error> error ",error.strip()
        return False


def set_hive_permissions(username, group_code):
    cmd = run_command("./setPermissions.sh " + group_code + "_role " + username)
    if not cmd:
        print "[ERROR] cannot set permissions"
    else:
        print "[INFO] permissions set"


def update_users(conn, cur, id, group_code):
    print "get all users "
    cur.execute("select hive_username, hive_password, is_user_in_hive, id  from live.hmis_user where project_group_id = '"+id+"'")
    users = cur.fetchall()
    for user in users:
        list_pair = list(user)
        username = str(list_pair[0])
        password = str(list_pair[1])
        user_in_hive = bool(list_pair[2])
        id = str(list_pair[3])
        print username
        print password
        print user_in_hive
        if not user_in_hive:
            print "Create user " + username
            cmd = run_command("./createUser.sh " + username + " " + password + " "
                              + config.kerberos_principal_username + " " + config.kerberos_principal_password)
            if not cmd:
                print "[ERROR] Cannot create user"
                continue
            cur.execute("update live.hmis_user set is_user_in_hive=True where hive_username = '" + username +"' and id='" + id + "'")
            conn.commit()
        else:
            print "[INFO] User already exists. add user read permissions to database"
        set_hive_permissions(username, group_code)


def create_db(conn):
    cur = conn.cursor()
    cur.execute("select project_group_code, is_project_group_in_hive, id from live.hmis_project_group")
    project_list = cur.fetchall()
    for pair in project_list:
        print "Process new pair ########################################################"
        list_pair = list(pair)
        print list_pair
        group_code = list_pair[0]
        hive = bool(list_pair[1])
        id = list_pair[2]
        print group_code
        print hive
        if hive is False:
            cmd = run_command("./projGrp.sh " + str(config.hive_agent_number) + " " + str(group_code))
            if not cmd:
                continue
            cur.execute("update live.hmis_project_group set is_project_group_in_hive=True where project_group_code = '"+group_code+"' AND id = '" + id + "'")
            conn.commit()
        update_users(conn, cur, id, group_code)

    conn.commit()
    conn.close()

if __name__ == '__main__':
    while True:
        print("#####################################################################################")
        print("################# Start new cycle #################")
        print("#####################################################################################\n")
        myConnection = psycopg2.connect(host=config.hostname, user=config.username, password=config.password, dbname=config.database)
        create_db(myConnection)
        myConnection.close()
        print("#####################################################################################")
        print("done")
        print("Sleep for " + str(config.period) + " minutes")
        print("#####################################################################################\n")
        cmd = run_command("./syncWithHue.sh")
        sys.stdout.flush()
        sleep(config.period * 60)
