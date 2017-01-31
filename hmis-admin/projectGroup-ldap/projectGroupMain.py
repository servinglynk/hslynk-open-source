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
    to_return = True
    if output:
        print "ret> ",res.returncode
        print "OK> output ",output
        if int(res.returncode) is 0:
            to_return = True
        else:
            to_return = False
    if error:
        print "ret> ",res.returncode
        print "Error> error ",error.strip()
    return to_return


def set_hive_permissions(username, group_code):
    command = run_command("./setPermissions.sh " + group_code + "_role " + username +
                      " " + config.hive_server +
                      " " + config.hive_principal_username +
                      " '" + config.hive_principal_password + "'")
    if not command:
        print "[set_hive_permissions] [ERROR] cannot set permissions"
    else:
        print "[set_hive_permissions] [INFO] permissions set"


def update_users(conn, cur, group_code_id, group_code):
    print "[update_users] Create users in hive for all users associated with " + group_code
    print "[update_users] get all users for " + group_code
    cur.execute("select hive_username, hive_password, is_user_in_hive, id  from "+ config.schema + "." +
                config.user_table + " where project_group_id = '" + group_code_id + "'")
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
            command = run_command("./createUser.sh " + username + " " + password + " " + config.ldap_server_host +
                              " " + config.ldap_server_port + " '" + config.ldap_admin_passwd + "'")
            print command
            if not command:
                print "[update_users] [ERROR] Cannot create user"
                continue
            cur.execute("update " + config.schema + "." + config.user_table +
                        " set is_user_in_hive=True where hive_username = '" +
                        username +"' and id='" + user_id + "'")
            conn.commit()
        else:
            print "[update_users] User already exists. add user read permissions to database"
        print "[update_users] Set hive permissions for " + username
        set_hive_permissions(username, group_code)


def create_db(conn):
    cur = conn.cursor()
    cur.execute("select " +
                "project_group_code, id, " +
                "tables_v2015_in_hbase, tables_v2014_in_hbase, " +
                "is_project_group_v2015_in_hive, is_project_group_v2014_in_hive " +
                "from "
                + config.schema + "." + config.project_group_table)
    project_list = cur.fetchall()
    for pair in project_list:
        list_pair = list(pair)
        print "\n[create_db] ########################################################"
        print "[create_db] Process new group code " + str(list_pair[0])
        print "[create_db] ########################################################\n"

        group_code = str(list_pair[0])
        group_code_id = str(list_pair[1])
        hbase_v2015 = bool(list_pair[2])
        hbase_v2014 = bool(list_pair[3])
        hive_v2015 = bool(list_pair[4])
        hive_v2014 = bool(list_pair[5])

        print "[create_db] Group code: " + group_code
        print "[create_db] Id: " + group_code_id
        print "[create_db] tables for v2015 in hbase? " + str(hbase_v2015)
        print "[create_db] tables for v2014 in hbase? " + str(hbase_v2014)
        print "[create_db] is project group for v2015 in hive? " + str(hive_v2015)
        print "[create_db] is project group for v2014 in hive? " + str(hive_v2014)
        do_update = False

        if hive_v2015 is False:
            if hbase_v2015 is True:
                print "[create_db] create database " + group_code + " in hive with all v2015 tables"
                command = run_command("./projGrp.sh " + group_code + " 2015" + " " + config.hive_server + " " +
                                  config.hive_principal_username + " '" + config.hive_principal_password + "'")
                print command
                if not command:
                    print "[ERROR][create_db] create db " + group_code + " for 2015 failed"
                    continue
                print "[create_db] create db " + group_code + " for 2015 is done"
                cur.execute("update " + config.schema + "." + config.project_group_table +
                            " set is_project_group_v2015_in_hive=True where project_group_code = '" +
                            group_code+"' AND id = '" + group_code_id + "'")
                do_update = True
        else:
            do_update = True
        if hive_v2014 is False:
            if hbase_v2014 is True:
                print "[create_db] create database " + group_code + " in hive with all v2014 tables"
                command = run_command("./projGrp.sh " + group_code + " 2014" + " " + config.hive_server + " " +
                                  config.hive_principal_username + " '" + config.hive_principal_password + "'")
                print command
                if not command:
                    print "[ERROR][create_db] create db " + group_code + " for 2014 failed"
                    continue
                print "[create_db] create db " + group_code + " for 2014 is done"
                cur.execute("update " + config.schema + "." + config.project_group_table +
                            " set is_project_group_v2014_in_hive=True where project_group_code = '" +
                            group_code+"' AND id = '" + group_code_id + "'")
                do_update = True
        else:
            do_update = True

        if do_update is True:
            print "Update users"
            update_users(conn, cur, group_code_id, group_code)
        else:
            print "skip user update"

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

        print("[main] #####################################################################################\n")
        #cmd = run_command("./syncWithHue.sh")
        sys.stdout.flush()

        print("[main] #####################################################################################")
        print("[main] done")
        print("[main] Sleep for " + str(config.period) + " minutes")

        sleep(config.period * 60)
