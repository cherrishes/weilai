__author__ = 'rdy'
from celery import Celery
from time import sleep

backend = 'redis://192.168.0.62:6379/0'
broker = 'redis://192.168.0.62:6379/1'
app = Celery('celery_demo',backend = backend, broker = broker)

@app.task
def add(x, y):
    sleep(10)
    return x + y