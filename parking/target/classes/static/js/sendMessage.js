function subSend() {

    //window.setInterval(function send() {
       // var msg = document.getElementById("1").value;
    var ws;//通信管道
    var target="ws://localhost:8888/websocket";
    ws = new WebSocket(target);

    ws.send();
        //document.getElementById("1").value = "";
    //},1000);

}