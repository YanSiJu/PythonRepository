x=-128
z=1024
y=127
dic = vars()
print(dic)
for k in dic:
    print(k+"="+repr(dic.get(k)))
