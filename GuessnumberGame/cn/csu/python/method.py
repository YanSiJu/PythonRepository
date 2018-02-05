class MyClass:
    @staticmethod
    def smeth():
        print("Static method.")
    @classmethod
    def cmeth(cls):
        print("class  method.",cls)
    def method(self):
        print("method")


MyClass.smeth()
MyClass.cmeth()

m = MyClass()
m.method()
m.cmeth()
m.smeth()






