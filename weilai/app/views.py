from django.shortcuts import render
from django.core.paginator import Paginator
from django.core.urlresolvers import reverse
from django.http.response import HttpResponse, HttpResponseRedirect
from django.views.decorators.csrf import csrf_exempt
import pymongo
import requests
# Create your views here.
@csrf_exempt
def home(request):
    t = 'home.html'
    return render(request, t, locals())

@csrf_exempt
def task(request):
    t = 'task/index.html'
    return render(request, t, locals())

@csrf_exempt
def today(request):
    t = 'task/today.html'
    return render(request, t, locals())

@csrf_exempt
def list(request):
    t = 'task/detail-list.html'
    return render(request, t, locals())

@csrf_exempt
def organize(request):
    t = 'task/organization.html'
    return render(request, t, locals())

@csrf_exempt
def week_list(request):
    t = 'task/week-list.html'
    return render(request, t, locals())

def test(request):
    t = 'task/test.html'
    return render(request, t, locals())