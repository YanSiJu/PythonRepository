#导入模块
import  numpy as np
import  tensorflow as tf


#定义变量
BATCH_SIZE = 10
SEED=23455
STEPS=3000

#使用Numpy生成数据集
rdm=np.random.RandomState(SEED)
X=rdm.rand(32,2)
Y=[[int(x0 + x1 < 1)] for (x0,x1) in X]    #bug


print("X:",X)
print("Y:",Y,"\n")

#定义神经网络的输入、输出、参数以及前向传播过程
x = tf.placeholder(tf.float32,shape=(None,2))
y_= tf.placeholder(tf.float32,shape=(None,1))



w1=tf.Variable(tf.random_normal([2,3],stddev=1,seed=1))
w2=tf.Variable(tf.random_normal([3,1],stddev=1,seed=1))

a = tf.matmul(x,w1)
y = tf.matmul(a,w2)


#定义损失函数以及反向传播方法
loss_msg = tf.reduce_mean(tf.square(y-y_))
train_step=tf.train.GradientDescentOptimizer(0.001).minimize(loss_msg)


#生成会话，训练STEPS轮
with tf.Session() as  sess:
    init_op = tf.global_variables_initializer()
    sess.run(init_op)
    #输出未经训练的参数
    print("w1:\n",sess.run(w1),"\n")
    print("w2:\n",sess.run(w2),"\n")

    for i in range(STEPS):
        start = (i*BATCH_SIZE) % 32
        end = start + BATCH_SIZE
        #feed_dict={x: X[start:end], y_: Y_[start:end]}
        sess.run(train_step,feed_dict={x: X[start:end], y_: Y[start:end]})
        #sess.run(train_step, feed_dict={x: X[start:end], y_: Y_[start:end]})
        if i%500 == 0:
            total_loss = sess.run(loss_msg, feed_dict={x:X, y_:Y})
            print("After %d steps,the loss on the all data is %g" % (i, total_loss))


    #输出训练后的参数
    print("w1:\n",sess.run(w1),"\n")
    print("w2:\n",sess.run(w2),"\n")

#使用生成的模型进行预测
