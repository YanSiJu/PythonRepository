a=[12,43,12,53,43,90]
b=[90,43,12,54,45,12,76]

data = list(zip(a,b))
data.sort(key=lambda  x:x[1])
print("data",data)

list1, list2 = map(lambda t: list(t),zip(*data))
print("list1",list1)
print("list2",list2)
