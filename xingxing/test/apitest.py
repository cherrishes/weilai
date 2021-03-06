import requests

__author__ = 'sunshine'


def third_login_test():
    # data = {'openid': }
    data = {
        'openid': '1234',
        'access_token': 'asasfcwefw',
        'account_type': 1,
        'head_url': '/static/img/',
        'nickname': 'xiaoxiao'
    }
    url = 'http://127.0.0.1:8000/freezer/api/third_login'
    resp = requests.post(url=url, data=data)
    print(resp.text)


# third_login_test()


def submit_mac_test():
    data = {
        'openid': '1234',
        'account_type': 1,
        'mac': '123456|123456|123'
    }
    url = 'http://127.0.0.1:8000/freezer/api/submit_mac'
    resp = requests.post(url=url, data=data)
    print(resp.text)


# submit_mac_test()


def get_mac_list_test():
    data = {
        'openid': '1234',
        'account_type': 1,
    }
    url = 'http://127.0.0.1:8000/freezer/api/get_mac_list'
    resp = requests.get(url=url, params=data)
    print(resp.text)


# get_mac_list_test()


def update_token_test():
    data = {
        'token': 'api_token_32bb58dc-148c-11e5-946c-005056c00008'
    }
    url = 'http://127.0.0.1:8000/freezer/api/update_token'
    resp = requests.get(url=url, params=data)
    print(resp.text)


def test_third_login():
    url = "http://0.0.0.0:8000/freezer/api/third_login"
    data = {
        "openid": "sdfdsfs",
        "access_token": "ssssssssssssssssssssss",
        "account_type": 1,
        "head_url": "http://img.head.jpg",
        "nickname": "张三"
    }
    r = requests.post(url=url, data=data)
    print(r.text)


if __name__ == "__main__":
    test_third_login()
    # update_token_test()