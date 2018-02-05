d = {'title':'Python Web Site','url':'http://www.python.org','spam':0}
print(str(d)+'\n')
print(d.items())
#it = d.iteritems()
keys = d.keys()

print('-------------------------------------------------------------')
for k in d:
       print(k)
print('\n\n\nvalues--->'+repr(d.values())+'\n\n\n')


for k in keysList:
       key,value = d.popitem()
	   print(key+':',value)
print(str(d))


input('Press <enter>')
