class MuffledCalculator:
    muffled = False
    def calc(self,expr):
        try:
            return eval(expr)
        except ZeroDivisionError:
            if self.muffled:
                print("Division by zero is illegal.")
            else:
                raise

calc = MuffledCalculator()
print(calc.calc("10/2"))

print("\n----------------------")

#calc.muffled = True
try:
    print(calc.calc("10/0"))
except ArithmeticError as e:
    print("ArithmeticError:Division by zero is illegal.")
    print(e)

print("Exception Exercise.")

