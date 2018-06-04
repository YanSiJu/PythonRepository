#master.py
distributed_queue = DistributedQueue()
bf = BloomFilter()

initial_pages = "www.renmingribao.com"

while(True):
    if request == 'GET':
        if distributed_queue.size()>0:
            send(distributed_queue.get())
        else:
            break
    elif request == 'POST':
        bf.put(request.url)

#作者：谢科
#链接：https://www.zhihu.com/question/20899988/answer/24923424
#来源：知乎
#著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。