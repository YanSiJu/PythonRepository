import sys
def guessNumber(key):
    number = int(input("please input number:"))
    while number != key:
      if(number<key):
        print("too small")
      elif(number > key):
        print("too big")
      number = input()
      number = int(number)

guessNumber(12)
sys.path.append("D:\Python\GuessnumberGame\cn\csu\python")





