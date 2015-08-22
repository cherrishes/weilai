项目部署
=========

基本配置
-------

* uwsgi端口号：8003
* 域名：qingke.device.53iq.com
* 虚拟环境名称：xingxingenv


uwsgi配置文件
------------

::

        [uwsgi]
        #v41
        chdir=/root/zhengdw/xingxing
        module=xingxing.wsgi
        env DJANGO_SETTINGS_MODULE=xingxing.settings
        master=True
        pidfile=/tmp/xingxing-master.pid
        socket=0.0.0.0:8003
        # 开启的进程数，推荐值=cpu核心数*2，因为有个叫超线程的东西
        processes=8
        vacuum=True
        max-requests=5000
        daemonize=/var/log/uwsgi-xingxing.log
        # 开启的线程数，在每个进程中再开启的线程，一般2个即可
        threads=2
        # 让uwsgi使用virtualenv运行
        virtualenv=/root/.virtualenvs/xingxingenv

nginx配置文件
-------------

::

        server {
        listen 80;
        server_name qingke.device.53iq.com;
        access_log /var/log/nginx/xingxing-access.log;
        error_log /var/log/nginx/xingxing-error.log;
        location / {
                uwsgi_pass 127.0.0.1:8003;
                include uwsgi_params;
              }
        location ~ ^/static/ {
         #此处配置要注意,后面的static不能写了，不能写成root /home/tsengdavid/workspace/smartsys/static;
                root /root/zhengdw/xingxing/;
                #设置缓存过期时间为1天
                expires 24h;
                access_log   off;
             }
        location ~ ^/tcp {
            proxy_pass http://127.0.0.1:9000;
            proxy_redirect off;
         }

        }




协议服务器配置
-------------

::

     端口号：1883
     域名：qingke.device.53iq.com

更新到服务器
----
::

        除了/conf/目录下的文件下的要慎重更新（里面的配置信息与服务器不一致），其它的都可以替换

