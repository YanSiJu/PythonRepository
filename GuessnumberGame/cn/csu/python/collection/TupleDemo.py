from collections import namedtuple

Animal = namedtuple('Animal', 'name age type')

perry = Animal(name="perry", age=31, type="cat")
print(perry)

amy = Animal(name="Amy", age=36, type="dog")
print(amy)

## 输出: Animal(name='perry', age=31, type='cat')

print(perry.name)
print(perry[1])
print(perry._asdict())
#perry.age=42  #属性不可变
