<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Socket</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<style>
	
	div{border:1px solid black; box-sizing: border-box;}                   
	#chatBox{margin:auto; width:300px; height:400px;}
	#chatList{width:100%; height:90%; overflow-y:auto; max-height:100%;}
	#sendChat{width:80%; height:10%; float:left; overflow:auto;}
	#send{width:20%; height:10%; float:right; box-sizing: border-box;}
</style>

<body>
	<script>
		$(function(){
			const ws = new WebSocket("ws://192.168.0.38/chat");
			
			$("#sendChat").on("keyup",function(e){
				if(e.key=="Enter"){
					let message = $("#sendChat").text();
				ws.send(message);
				$("#sendChat").text("");
				$("#sendChat").focus();
				}
			});
			
			$("#send").on("click",function(){
				let message = $("#sendChat").text();
				ws.send(message);
				$("#sendChat").text("");
				$("#sendChat").focus();
			});
			
			ws.onmessage = function(e){
				console.log("!!!");
				let chat = $("<div>");
				chat.text(e.data)
				$("#chatList").append(chat);
         	   	$("#chatList").scrollTop($("#chatList")[0].scrollHeight);
			}
		});
		
	</script>
	<div id="chatBox">
		<div id="chatList"></div>
		<div id="sendChat" contenteditable="true"></div>
		<button id="send">전송</button>
	</div>
	
</body>
</html>