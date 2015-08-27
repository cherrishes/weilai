源码目录结构
===========

::

        ├── app
        │   ├── api
        │   │   ├── admin.py
        │   │   ├── __init__.py
        │   │   ├── models.py
        │   │   ├── tests.py
        │   │   ├── urls.py
        │   │   └── views.py
        │   └── manage
        │       ├── admin.py
        │       ├── __init__.py
        │       ├── models.py
        │       ├── tests.py
        │       ├── urls.py
        │       └── views.py
        ├── common --公用部分
        ├── conf --配置文件
        │   ├── dbconf.py
        │   ├── memcacheconf.py
        │   └── __pycache__
        │       ├── dbconf.cpython-34.pyc
        │       └── memcacheconf.cpython-34.pyc
        ├── doc --文档目录
        │   ├── requirements.txt
        │   └── washer
        ├── example --示例代码
        ├── log --日志
        │   ├── debug.log
        │   └── default.log
        ├── manage.py
        ├── model --django orm模型
        ├── static --静态资源
        │   ├── bootstrap
        │   ├── css
        │   ├── img
        │   └── js
        │       ├── angular.min.js
        │       ├── angular.min.js.map
        │       ├── jquery-1.11.0.min.js
        │       └── jquery-1.11.0.min.map
        ├── templates --模板
        │   ├── api
        │   └── manage
        │       ├── base.tpl
        │       ├── demo.html
        │       └── home.html
        ├── test --单元测试
        ├── util --封装的工具
        └── washer
            ├── __init__.py
            ├── __pycache__
            │   ├── __init__.cpython-34.pyc
            │   ├── settings.cpython-34.pyc
            │   ├── urls.cpython-34.pyc
            │   └── wsgi.cpython-34.pyc
            ├── settings.py
            ├── urls.py
            └── wsgi.py

