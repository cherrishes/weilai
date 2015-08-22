from django.conf.urls import patterns, url, include


freezer_patterns = patterns(
    'app.freezer.views',
    url(r'^add_room/$', 'add_room', name='add_room'),
    url(r'^update_room/$', 'update_room', name='update_room'),
    url(r'^update_device_alias/$', 'update_device_alias', name='update_device_alias'),
    url(r'^delete_room/$', 'delete_room', name='delete_room'),
    url(r'^delete_dev/$', 'delete_dev', name='delete_dev'),
    url(r'^warn/$', 'warn', name='warn'),
    url(r'^download$', 'download', name='download'),
    url(r'^api/', include('app.freezer.api.urls')),
)