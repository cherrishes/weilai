import pymysql
import datetime
import time
# 协议服务器mysql配置

OTA_MYSQL_HOST = "ota.53iq.com"
OTA_MYSQL_PORT = 3306
OTA_MYSQL_USER = "root"
OTA_MYSQL_PWD = "dwsoft"
OTA_MYSQL_DB = "openfire"

# 本地mysql配置
MYSQL_HOST = "smart.56iq.net"
MYSQL_PORT = 3306
MYSQL_USER = "root"
MYSQL_PWD = "vveye.EnterpriseDB"
MYSQL_DB = "ebdb_smartsys"
__author__ = 'rdy'

def get_otamysql_connection(host=OTA_MYSQL_HOST,
                         port=OTA_MYSQL_PORT,
                         user=OTA_MYSQL_USER,
                         passwd=OTA_MYSQL_PWD,
                         db=OTA_MYSQL_DB):
    connection = pymysql.connect(host=host,
                                 port=port,
                                 user=user,
                                 passwd=passwd,
                                 db=db, charset='UTF8', cursorclass=pymysql.cursors.DictCursor)
    return connection


def get_62mysql_connection(host=MYSQL_HOST,
                         port=MYSQL_PORT,
                         user=MYSQL_USER,
                         passwd=MYSQL_PWD,
                         db=MYSQL_DB):
    connection = pymysql.connect(host=host,
                                 port=port,
                                 user=user,
                                 passwd=passwd,
                                 db=db, charset='UTF8', cursorclass=pymysql.cursors.DictCursor)
    return connection

def data_tr():
    conn = get_otamysql_connection()
    conno= get_62mysql_connection()
    try:
        cursor = conn.cursor()
        cursoro= conno.cursor()
        sql = "SELECT username,name, creationDate FROM ofUser;"
        sql2 = "SELECT * FROM ebt_device"
        cursor.execute(sql)
        cursoro.execute(sql2)
        res = cursor.fetchall()
        res2 =  cursoro.fetchall()
        ota=[]
        smart=[]
        new =[]
        for i in res:
            ota.append(i['username'])
        for j in res2:
            smart.append(j['ebf_device_id'])
        for i in ota :
            if i not in smart:
                new.append(i)
        print(len(new))
        for i in res:
            if i['username'] in new:

                timeStamp = i['creationDate']
                tS = timeStamp[2:12]
                dateArray = datetime.datetime.utcfromtimestamp(int(tS))
                otherStyleTime = dateArray.strftime("%Y-%m-%d %H:%M:%S")
                sqlo = "INSERT INTO ebt_device(ebf_device_id,ebf_device_alias,ebf_device_type,protocol_id,dt_id,ebf_device_is_online,ebf_device_create_date) VALUES(%s,%s,%s,%s,%s,%s,%s)"

                cursoro.execute(sqlo,(i['username'],i['username'],1,1,1,0,otherStyleTime))

                conno.commit()
    except Exception as e:
        print(e)
    finally:
        print("ok")
        conn.close()
        conno.close()
        """



        dateArray = datetime.datetime.utcfromtimestamp(int(tS))
        print(dateArray)
        otherStyleTime = dateArray.strftime("%Y-%m-%d %H:%M:%S")
        print(otherStyleTime)
        """
        """
                    timeStamp = i['creationDate']
                    tS = timeStamp[2:12]
                    dateArray = datetime.datetime.utcfromtimestamp(int(tS))
                    otherStyleTime = dateArray.strftime("%Y-%m-%d %H:%M:%S")
                    sqlo = "INSERT INTO ebt_device(ebf_device_id,ebf_device_alias,ebf_device_type,protocol_id,dt_id,ebf_device_is_online,ebf_device_create_date) VALUES(%s,%s,%s,%s,%s,%s,%s)"

                    cursoro.execute(sqlo,(i['username'],i['username'],1,1,1,0,otherStyleTime))

                    conno.commit()
                    """

if __name__ =='__main__':
    data_tr()