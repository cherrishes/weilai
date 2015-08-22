# _*_ coding:utf-8 _*_
__author__ = 'lujin'
from app.freezer.api.proto import PackUser_pb2, PackAuth_pb2, PackCustomService_pb2, PackRequestCmd_pb2, PackResponseCmd_pb2
#压缩
userBody = PackUser_pb2.UserBody()
userBody.userAccount = b'110'
userBody.userPass = b'abc'
userBody.userNickName = b'hahah'
userBody.userSex = 23
userBody.userHeadUrl = b'static'
print(userBody)
print('-------------------------------')
out = userBody.SerializeToString()
print(out)
print('-------------------------------')
#解压
body = PackUser_pb2.UserBody()
body.ParseFromString(out)
print(body)

print('+++++++++++++++++++++++++++++++++++++')
authoBody = PackAuth_pb2.AuthBody()
authoBody.token = b'123'
authoBody.isSucceed = True
authoBody.pbKey = b'acksjk'
authoBody.pbBody = b'ajbcjksubvkjsbnkj'

# requestCmdBody = PackRequestCmd_pb2.RequestCmdBody()
# requestCmdBody.REGIST = 0x01
# requestCmdBody.LOGIN = 0x02
# requestCmdBody.CUSTOMER_SERVICE = 0x03
authoBody.requestCmd = PackRequestCmd_pb2.RequestCmdBody.Value('REGIST')

# authoBody.responseCmd = responseCmdBody

print(authoBody)
print('-------------------')
autho_out = authoBody.SerializeToString()

print(autho_out)
print('---------------------')
autho_body = PackAuth_pb2.AuthBody()
autho_body.ParseFromString(autho_out)
print(autho_body)





