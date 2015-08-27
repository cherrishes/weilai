部署
====


域名
-----

* qkhf.device.53iq.com
* qkhf.device.56iq.com(备用)

端口号
------

50001

波特率
-------

9600


uwsgi配置文件
-------------

::

        [uwsgi]
        #v1.0
        chdir=/root/zhengdw/washer
        module=washer.wsgi
        env DJANGO_SETTINGS_MODULE=washer.settings
        master=True
        pidfile=/tmp/washer-master.pid
        socket=0.0.0.0:8004
        # 开启的进程数，推荐值=cpu核心数*2，因为有个叫超线程的东西
        processes=8
        vacuum=True
        max-requests=5000
        daemonize=/var/log/uwsgi-washer.log
        # 开启的线程数，在每个进程中再开启的线程，一般2个即可
        threads=2
        # 让uwsgi使用virtualenv运行
        virtualenv=/root/.virtualenvs/washerenv


nginx配置
---------

::

        server {
        listen 80;
        server_name qkhf.device.53iq.com qkhf.device.56iq.com;
        access_log /var/log/nginx/washer-access.log;
        error_log /var/log/nginx/washer-error.log;
        location / {
                uwsgi_pass 127.0.0.1:8004;
                include uwsgi_params;
              }
        location ~ ^/static/ {
         #此处配置要注意,后面的static不能写了，不能写成root root /root/zhengdw/washer/static;
                root /root/zhengdw/washer/;
                #设置缓存过期时间为1天
                expires 24h;
                access_log   off;
             }
        location ~ ^/tcp {
            proxy_pass http://127.0.0.1:9000;
            proxy_redirect off;
         }

        }
