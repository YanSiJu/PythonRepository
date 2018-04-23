import tensorflow as tf

a = tf.constant([[1,2]])
b = tf.constant([[3],[5]])

result=tf.matmul(a,b)
print("result",result)

with tf.Session() as sess:
    print(sess.run(result))

