import socket

s = socket.socket()
host = socket.gethostname()
port=1234
s.bind((host,port))

print(socket.gethostname())

s.listen(5)
while True:
    c,addr = s.accept()
    print("get connection from ",addr,"\nc:",c)
    print(c.recv(1024))
    c.send(b'Thank you for connecting')
    c.close()

