from conf.memcachedconf import MEMCACHED_HOST_ARR, TIMEOUT

__author__ = 'tsengdavid'
import memcache


def get_mc():
    mc = memcache.Client(MEMCACHED_HOST_ARR, debug=0)
    return mc


def getval(key):
    return get_mc().get(key)


def setval(key, val, timeout=TIMEOUT):
    get_mc().set(str(key), val, timeout)