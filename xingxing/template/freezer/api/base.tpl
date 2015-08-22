{% load staticfiles %}
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>{% block title %}{% endblock %}</title>
    <link rel="stylesheet" type="text/css" href="{% static 'frozen/css/global.css' %}"/>
    {% block style %}

    {% endblock %}
</head>
<body>
<div class="header">
    {% block header %}

    {% endblock %}
</div>
{% block content %}

{% endblock %}

{% block footer %}

{% endblock %}
<script>
    function isEbanswers() {
        return true;
    }
</script>
<script src="{% static 'js/jsapi.js' %}"></script>
{% block script %}

{% endblock %}
</body>
</html>