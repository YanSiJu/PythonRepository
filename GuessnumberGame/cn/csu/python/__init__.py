d = {'title':'Python Web Site','url':'http://www.python.org','spam':0}
print(str(d)+'\n')
print(d.items())
#it = d.iteritems()
keys = d.keys()

print('--------------------------遍历字典-----------------------------------')
for k in d:
       print(k+":",d.get(k))
print('\n\n\nvalues--->'+repr(d.values())+'\n\n\n')

print(d)

input('Press <enter>')
