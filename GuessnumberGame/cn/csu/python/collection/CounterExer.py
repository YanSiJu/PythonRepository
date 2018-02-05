from  collections import  Counter
colours = (
    ('Yasoob', 'Yellow'),
    ('Ali', 'Blue'),
    ('Arham', 'Green'),
    ('Ali', 'Black'),
    ('Yasoob', 'Red'),
    ('Ahmed', 'Silver'),
)

favs=Counter(name for name,color in colours)
print(favs)


with open("D:\Python\GuessnumberGame\cn\csu\python\Test.txt") as f:
     lineCount = Counter(f)
print(type(lineCount))


