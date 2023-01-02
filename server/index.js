const express = require('express');
const app = express();
const http = require('http');
const server = http.createServer(app);
const { Server } = require("socket.io");
const io = new Server(server);

app.get('/', (req, res) => {
  res.write(`<h1>Socket IO start</h1>`);
  res.end();
});

io.on('connection', (socket) => {
  console.log('a user connected');
  socket.on('message',(ms) => {
    io.emit('message',ms)
  });

  socket.on('deleteroom',(ms) => {
    io.emit('deleteroom',ms)
  });

  socket.on('createroom',(ms) => {
    io.emit('createroom',ms)
  });
});

server.listen(3000, () => {
  console.log('listening on *:3000');
});
