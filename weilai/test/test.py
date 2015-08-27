__author__ = 'rdy'
import time
from test.celery_demo import add
t1 =time.time()
result =add.delay(1, 2)
print(result.get())
print(time.time() - t1)
