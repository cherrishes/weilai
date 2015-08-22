from django.core.urlresolvers import reverse

from util.mongodbutil import get_db


__author__ = 'rdy'
import json

from django.http import HttpResponse, HttpResponseRedirect
from django.views.decorators.csrf import csrf_exempt
from django.shortcuts import render

from app.freezer.api.room_dev_list.dev_list.handler import Handle
from util.decorators import token_required
from common.protocol import send, query


handle = Handle()


@csrf_exempt
@token_required
def device_detail(request, user_id):
    """
    设备详细页
    :param request:
    :return:
    """
    dev_id = request.GET.get('devid', None)
    if not dev_id:
        return HttpResponseRedirect(reverse("error"))
    try:
        db = get_db()
        device = db.ebc_device.find_one({"_id": dev_id})
        status = json.loads(query("query_status", dev_id))["value"]
        status_arr = status.split("|")
        alert = "状态未知"
        alert_val = 1
        if status == "-1|-1|-1|-1|-1|-1||-1":
            mode = "设备离线"

        elif status == "0|0|0|0|0|0||0":
            mode = "数据未上传"
        else:
            if status_arr[7] == "0":
                mode = "阴凉模式"
            elif status_arr[7] == "1":
                mode = "冷藏模式"
            if status_arr[5] == "1":
                alert = "继续报警"
                alert_val = 1
            elif status_arr[5] == "0":
                alert = "取消报警"
                alert_val = 0
            if status_arr[3] == "1":
                checked = "checked"
            else:
                checked = ""
            if status_arr[6] == "":
                alert = "工作正常"
                alert_val = 2
    except Exception as e:
        print(str(e))
    return render(request, "freezer/api/devlist.html", locals())


@csrf_exempt
def allrequire(request):
    r = request.POST.get("flag", None)
    if r == 'gw':
        temperature_list = handle.get_temperature_gui()
        temp_list = []
        for t in temperature_list:
            temp_list.append({'t': t})

        return HttpResponse(json.dumps(temp_list))
    elif r == 'hm':
        humidity_list = handle.get_humidity_gui()
        hum_list = []
        for h in humidity_list:
            hum_list.append({'h': h})
        return HttpResponse(json.dumps(hum_list))
    elif r == 'hw':
        temperature_list = handle.get_temperature_huan()
        temp_list = []
        for t in temperature_list:
            temp_list.append({'t': t})

        return HttpResponse(json.dumps(temp_list))

    else:
        return HttpResponse("error")


@csrf_exempt
@token_required
def all_data(request, user_id):
    dev_id = request.GET['devid']
    data = handle.get_device_data(dev_id, user_id)
    #print(data)
    return HttpResponse(json.dumps(data))


@csrf_exempt
def send_data(request):
    type = request.POST.get('type')
    devid = request.REQUEST.get("devid", None)
    t = "10"
    if type == 'buz':
        t = "3"
    elif type == 'light':
        t = "1"
    status = request.POST.get('status')
    a = 0
    if devid:
        a = send(devid, t, status)
    return HttpResponse(str(a))