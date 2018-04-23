import  tensorflow as tf

greeting = tf.constant("Hello,tensorflow")

with tf.Session() as sess:
    print(sess.run(greeting))

a = tf.constant([1.0,2.0])
b = tf.constant([3.0,4.0])

with tf.Session() as sess:
    print(sess.run(a+b))
