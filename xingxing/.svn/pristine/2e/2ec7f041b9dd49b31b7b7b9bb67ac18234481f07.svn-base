from django.conf.urls import patterns, include, url

from app.freezer.urls import freezer_patterns
from app.freezer.views import home, test


urlpatterns = patterns('',
                       url(r'^$', home),
                       url(r'^test$', test),
                       url(r"^freezer/", include(freezer_patterns)),
                       )
