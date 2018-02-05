x = 1
y = 1
a = 5
b = 4
num1 = eval("x+y")
print (num1)  #2
def g():
    x = 2
    y = 2
    a = 3
    b = 10
    num3 = eval("x+y")
    print (num3)  #4
    num4 = eval("x+y",globals())  #2
    print(num4)
    num2 = eval("a+b",globals(),locals())
    print ("    num2--->",num2)  #

g()
