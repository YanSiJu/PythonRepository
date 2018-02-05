import  queue
my_queue=queue.Queue()
print("size:",my_queue.qsize())
print("maxSize:",my_queue.maxsize)


my_queue.put("Hi")
my_queue.put("byebye")
my_queue.put("R")
my_queue.put("Go")
my_queue.put("Ruby")
my_queue.put_nowait("Perl")
#my_queue.put("Perl")
print(my_queue)

print("\n----------------------------------------------")
print(my_queue.get())
print(my_queue.get())
print(my_queue.get())
print(my_queue.get())
print(my_queue.get())
print(my_queue.get())
print("seven:",my_queue.get_nowait())

