from django.conf.urls import patterns, include, url
from django.contrib import admin
from app.urls import task_patterns
from app.views import home
urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'weilai.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),
    url(r'^wei_lai/', include(task_patterns)),
    url(r'^$', home),
)
