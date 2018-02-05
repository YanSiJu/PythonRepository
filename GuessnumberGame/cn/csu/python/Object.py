class Person:
    print("Person is defined.")
    __age=46
    def setName(self,name):
        self.name = name

    def getName(self):
        return self.name

    def getAge(self):
        return self.__age

    def __inaccessible(self):
        print("inaccessible")

p = Person()
amy = Person()
lucy = Person()
p.setName("Guido")
amy.setName("Luke.SkyWalker")
print(p.getName(),p.getAge())
print(amy.getName())

print("\n--------------------------------------")
print("class:",p.__class__)
print(issubclass(Person,object))
print("type:",type(p))
print("bases:",Person.__bases__)



print("\n\n\nobject---->",object)

