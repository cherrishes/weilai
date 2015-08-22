from util.mongodbutil import get_db

db=get_db()
dev_total = db.ebc_user_device.find({'user_id': "1_88FD14CA68A39AF7B357B995B8E81131", 'device_id': {'$ne': None}}).count()
print(dev_total)