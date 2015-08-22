__author__ = 'tsengdavid'


def compress_start():
    """
    压缩脚本和样式表
    :return:
    """
    import os
    import os.path
    # 指明被遍历的文件夹
    rootdir = os.getcwd() + "/../../static"
    # 压缩器路径
    jarpath = os.getcwd() + "/yuicompressor-2.4.8.jar"
    # 三个参数：分别返回1.父目录 2.所有文件夹名字（不含路径） 3.所有文件名字
    for parent, dirnames, filenames in os.walk(rootdir):
        for dirname in dirnames:  # 输出文件夹信息
            fullpath = parent + "/" + dirname
            print(fullpath)
            # 压缩脚本(直接替换原文件)
            try:
                cmd = "java -jar " + jarpath + " -o '.js$:.js' " + fullpath + "/*.js"
                os.system(cmd)
            except Exception as e:
                print(str(e))
            # 压缩样式表(直接替换原文件)
            try:
                cmd = "java -jar " + jarpath + " -o '.css$:.css' " + fullpath + "/*.css"
                os.system(cmd)
            except Exception as e:
                print(str(e))
    print("Compress Finished!")


if __name__ == "__main__":
    compress_start()