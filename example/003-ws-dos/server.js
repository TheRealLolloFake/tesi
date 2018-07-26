//https://github.com/theturtle32/WebSocket-Node#note-for-windows-users
var WebSocketServer = require('websocket').server;
var http = require('http');
var count=0;

var server = http.createServer(function(request, response) {
    console.log((new Date()) + ' Received request for ' + request.url);
    response.writeHead(404);
    response.end();
});
server.listen(8080,process.argv[2],function() {
    console.log((new Date()) + ' Server is listening on port 8080');
});

wsServer = new WebSocketServer({
    httpServer: server,
    autoAcceptConnections: false
});

wsServer.on('request', function(request) {
    
    var connection = request.accept();
    ++count;
    console.log("Encreased:"+count);
    connection.on('message', function(message) {
        if (message.type === 'utf8') {
            connection.sendUTF(message.utf8Data);
        }else if (message.type === 'binary') {
            connection.sendBytes(message.binaryData);
        }
    });

    connection.on('close', function(reasonCode, description) {
        --count;
        console.log("Decreased:"+count);
    });
});