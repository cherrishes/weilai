项目规范
=======

前端
----

#. 标签id的命名采用匈牙利命名法，比如 <input type="button" id="btnSave" value="保存"/>
#. 样式的class以用途和效果来命名，比如：ui-box-content、ui-form-item-focus，具体可以参考支付宝通用样式库： http://aliceui.org/docs/widget.html


python
-------

#. 遵循PEP8即可
#. 虚拟环境名称:washerenv

django
------

#. 视图名称与模板文件名称一致，url也尽量与视图名一致
#. 所有的静态资源都放在/static/目录下，所有的模板文件都放在/template/目录下


其它
----

#. 不要在代码里将数据库的连接信息、缓存连接信息等写死，要保存在配置文件中
#. 所有的配置文件保存在 /conf/目录下，包括session、cookie、cache
#. 修改文件前一定要先更新svn，提交之前先更新
#. 不要重复造轮子，有现成的框架就用现成的