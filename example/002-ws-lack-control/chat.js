	var chatbox=document.getElementById("chat");
	var i=0;
	
	function addMsg(msg){
		if(i==0){
			chatbox.innerHTML="<div>"+msg+"<div><br>";
			i++;
		}else{
			chatbox.innerHTML+="<div>"+msg+"<div><br>";
		}
	}
	
	var ws=new WebSocket("ws://localhost/");
	ws.onmessage = function (event) {
		addMsg(event.data);
	}
	function send(){
		var msg=document.getElementById("msg").value;
		addMsg(msg);
		ws.send(msg);
	}