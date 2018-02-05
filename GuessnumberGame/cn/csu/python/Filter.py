class Filter:
    def __init__(self):
        print("Filter's init")

class SpamFilter(Filter):
    def  __init__(self):
        super(SpamFilter, self).__init__()
        print("SpamFilter's init")

print("SpamFilter's  bases:",SpamFilter.__bases__)
print("Filter's  bases:",Filter.__bases__)
spam = SpamFilter()
