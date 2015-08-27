__author__ = 'rdy'
# -*- coding: utf-8 -*-
import datetime
import time

from apscheduler.events import EVENT_JOB_EXECUTED, EVENT_JOB_ERROR
from pytz import utc
from apscheduler.schedulers.background import BackgroundScheduler
from apscheduler.jobstores.sqlalchemy import SQLAlchemyJobStore
from apscheduler.executors.pool import ThreadPoolExecutor, ProcessPoolExecutor




jobstores = {
    'default': SQLAlchemyJobStore(url='sqlite:///jobs.sqlite')
}
# 执行任务的模块。根据不同的IO模型有多种executor选择。
executors = {
    'default': ThreadPoolExecutor(20),
    'processpool': ProcessPoolExecutor(5)
}

job_defaults = {
    'coalesce': False,
    'max_instances': 3
}
scheduler = BackgroundScheduler(jobstores=jobstores, executors=executors, job_defaults=job_defaults, timezone=utc)


def my_listener(event):
    if event.exception:
        print('The job crashed :(')
    else:
        print('The job worked :)')


scheduler.add_listener(my_listener, EVENT_JOB_EXECUTED | EVENT_JOB_ERROR)


def mp_task():
    print("我在测试是否执行")



st=datetime.datetime.now()
# 每分钟执行一次
jobQuery = scheduler.add_job(mp_task, trigger='interval', seconds=20,
                             id='update_onlinestasus', replace_existing=True)

scheduler.start()

try:
    # 保持主线程不终止
    while True:
        time.sleep(2)
except (KeyboardInterrupt, SystemExit):
    scheduler.shutdown()