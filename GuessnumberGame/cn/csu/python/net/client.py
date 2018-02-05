import  socket
s = socket.socket()
host = socket.gethostname()
port = 1234
s.connect((host,port))
s.send(b'send  message')
print(s.recv(1024))


