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
        print "[set_hive_permissions] [ERROR] cannot set permissions"
    else:
        print "[set_hive_permissions] [INFO] permissions set"


def update_users(conn, cur, group_code_id, group_code):
    print "[update_users] Create users in hive for all users associated with " + group_code
    print "[update_users] get all users for " + group_code
    cur.execute("select hive_username, hive_password, is_user_in_hive, id  from "+ config.schema + ".hmis_user where project_group_id = '" + group_code_id + "'")
    users = cur.fetchall()
    for user in users:
        list_pair = list(user)
        print "[update_users] ########################"
        print "[update_users] process user: " + str(list_pair[0])
        print "[update_users] ########################"
        list_pair = list(user)
        username = str(list_pair[0])
        password = str(list_pair[1])
        user_in_hive = bool(list_pair[2])
        user_id = str(list_pair[3])
        print "[update_users] Hive username: " + username
        print "[update_users] Hive password: " + password
        print "[update_users] Is user in hive? " + str(user_in_hive)
        print "[update_users] User id: " + user_id
        if username == 'None' or username == '' or password == 'None' or password == '':
            print "[update_users] Skip user "
            print "[update_users] Hive Password or Hive Username cannot be empty or 'None'"
            continue
        if not user_in_hive:
            print "[update_users] Create user " + username
            cmd = run_command("./createUser.sh " + username + " " + password + " "
                              + config.kerberos_principal_username + " " + config.kerberos_principal_password)
            if not cmd:
                print "[update_users] [ERROR] Cannot create user"
                continue
            cur.execute("update " + config.schema + ".hmis_user set is_user_in_hive=True where hive_username = '" + username +"' and id='" + user_id + "'")
            conn.commit()
        else:
            print "[update_users] User already exists. add user read permissions to database"
        print "[update_users] Set hive permissions for " + username
        set_hive_permissions(username, group_code)


def create_db(conn):
    cur = conn.cursor()
    cur.execute("select project_group_code, is_project_group_in_hive, id from " + config.schema + ".hmis_project_group")
    project_list = cur.fetchall()
    for pair in project_list:
        list_pair = list(pair)
        print "\n[create_db] ########################################################"
        print "[create_db] Process new group code " + str(list_pair[0])
        print "[create_db] ########################################################\n"

        #print list_pair
        group_code = str(list_pair[0])
        hive = bool(list_pair[1])
        group_code_id = str(list_pair[2])
        print "[create_db] Group code: " + group_code
        print "[create_db] Is in hive: " + str(hive)
        print "[create_db] Id: " + group_code_id
        if hive is False:
            print "[create_db] create " + group_code + " in hive"
            cmd = run_command("./projGrp.sh " + group_code)
            if not cmd:
                continue
            cur.execute("update " + config.schema + ".hmis_project_group set is_project_group_in_hive=True where project_group_code = '"+group_code+"' AND id = '" + group_code_id + "'")
            conn.commit()
        update_users(conn, cur, group_code_id, group_code)

    conn.commit()
    conn.close()

if __name__ == '__main__':
    while True:
        print("[main] #####################################################################################")
        print("[main] ################# Start new cycle #################")
        print("[main] #####################################################################################\n")
        myConnection = psycopg2.connect(host=config.hostname, user=config.username, password=config.password, dbname=config.database)
        create_db(myConnection)
        myConnection.close()
        print("[main] #####################################################################################")
        print("[main] done")
        print("[main] Sleep for " + str(config.period) + " minutes")
        print("[main] #####################################################################################\n")
        cmd = run_command("./syncWithHue.sh")
        sys.stdout.flush()
        sleep(config.period * 60)
