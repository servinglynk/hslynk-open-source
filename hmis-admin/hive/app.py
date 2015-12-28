#!/usr/bin/python
import config
import psycopg2
import subprocess


def run_command(command):
    print(command)
    p = subprocess.Popen(command,
                         stdout=subprocess.PIPE,
                         stderr=subprocess.STDOUT,
                         shell=True)
    return iter(p.stdout.readline, b'')


def do_query1(conn):
    cur = conn.cursor()
    cur.execute("select project_group_code, is_project_group_in_hive, id from live.hmis_project_group")
    project_list = cur.fetchall()
    for pair in project_list:
        list_pair = list(pair)
        print list_pair
        group_code = list_pair[0]
        hive = bool(list_pair[1])
        id = list_pair[2]
        print group_code
        print hive
        if hive is False:
            cmd = run_command("./projGrp.sh " + str(group_code))
            for line in cmd:
                print line
            cur.execute("update live.hmis_project_group set is_project_group_in_hive = True where project_group_code = '"+group_code+"' AND id = '" + id + "'")
            cur.execute("select username from live.hmis_user where project_group_id = '"+id+"'")
            users = cur.fetchall()
            for user in users:
                print user
    conn.commit()
    conn.close()


def do_query2(conn):
    cur = conn.cursor()

    conn.commit()
    conn.close()


if __name__ == '__main__':
    myConnection = psycopg2.connect(host=config.hostname, user=config.username, password=config.password, dbname=config.database)
    