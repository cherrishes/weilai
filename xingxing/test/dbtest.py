def save():
    import datetime

    from bson import ObjectId

    from util.mongodbutil import get_db

    db = get_db()
    device = db.ebc_device.find_one({"_id": "10279010865051"})
    print(device)
    obj = {
        "_id": "2_oYazTsp2lBjzD_dNoFX17eVGIIcIACCF23576547",
        "user_id": "1_oYazTsp2lBjzD_dNoFX17eVGIIcI",
        "mac": "ACCF23576547",
        "device": None,
        "room_id": ObjectId("5565a90a808df7fd642ec8dc"),
        "alias": "23432432",
        "create_date": datetime.datetime.utcnow()
    }
    r = db.ebc_user_device.insert(obj)
    print(r)


def read():
    from util.mongodbutil import get_db

    db = get_db()
    ud = db.ebc_user_device.find_one({"user_id": "1_oYazTsp2lBjzD_dNoFX17eVGIIcI"})["device"]
    r = db[ud.collection].find_one({"_id": ud.id})
    print(r)


def insert_data():
    from util.mongodbutil import get_db

    db = get_db()
    from bson import ObjectId

    import datetime

    obj = {
        "_id": "2_oYazTsp2lBjzD_dNoFX17eVGIIcIACCF233C84E7",
        "user_id": "2_oYazTsp2lBjzD_dNoFX17eVGIIcI",
        "mac": "ACCF233C84E7",
        "device_id": "10279010865051",
        "room_id": ObjectId("5565a90a808df7fd642ec8f6"),
        "alias": "110",
        "create_date": datetime.datetime.utcnow()
    }
    db.ebc_user_device.insert(obj)

insert_data()