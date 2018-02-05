def square(x):
     "Calculates the square of number x"
     return x*x
help(square)

def sum(x,y):
    return x+y

x=10
y=20
print(sum(x,y))

def  dct(d,key,value):
      d[key]=value

d = {"name":"Gumby","age":42}
dct(d,"name","Guido")
print(d)




