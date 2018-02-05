'''
这个例子展示如何在源码中嵌入doctest用例。
'>>>' 开头的行就是doctest测试用例。
不带 '>>>' 的行就是测试用例的输出。
如果实际运行的结果与期望的结果不一致，就标记为测试失败。
'''
def square(x):
    """
    >>> square(9)
    81
    >>> square(12)
    144
    >>> square(13)
    169
    """
    return x*x

if __name__=='__main__':
    import  doctest,my_math
    doctest.testmod(my_math)

