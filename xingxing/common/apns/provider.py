
import time
from apns import APNs, Frame, Payload

print("start")
apns = APNs(use_sandbox=True, cert_file='cert.pem', key_file='key.pem')
print("apns")
# Send a notification
# 这个是ios设备的 device token
token_hex = 'f73ac698f7492cb4d2f0b7d53dc540e76155b18703b2b7c3f0a369413bc4f3ac'
payload = Payload(alert="Hello World!", sound="default", badge=1)
print("before gateway")
apns.gateway_server.send_notification(token_hex, payload)

print("发送了==============================")
# Send multiple notifications in a single transmission
frame = Frame()
identifier = 1
expiry = time.time()+3600
priority = 10
frame.add_item('b5bb9d8014a0f9b1d61e21e796d78dccdf1352f23cd32812f4850b87', payload, identifier, expiry, priority)
apns.gateway_server.send_notification_multiple(frame)