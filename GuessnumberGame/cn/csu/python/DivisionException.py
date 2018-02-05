class Calculator:
    def calc(self):
      while True:
        try:
            x=int(input("Please input the first number:"))
            y=int(input("Please input the second number:"))
            print(x,"/",y,"=",x/y)
        except ValueError as e:
            print("Please input an integer.")
        except Exception as e:
            print("Exception:",e)
            print("please try again.")
        else:
            print("It went as planned.")
            break
        finally:
            print("finally.")

cal=Calculator()
cal.calc()









