def withStars(*params):
         print(params)

def printDict(**params):
    for k in params:
       print(k+"=",params.get(k))


def  fun(x,y=256,z=1024,*params,**keys):
    print(x,y,z)
    print(params)
    print(keys)

def  func(x,y,z):
    print(x,y,z)

withStars("Amy","Alice","Guido","Linus")
withStars(1,3,2,98)
printDict(name="Guido",age=42,address="Netherlands")
fun(-128,90,1026,12,32,foo=-128,bar=1024)

prices=(12.43,43.53,43.12)
func(*prices)
