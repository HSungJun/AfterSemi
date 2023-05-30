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
	
	div{box-sizing: border-box; word-break:break-all;}
	#chatBox{margin:auto; width:400px; height:400px; border:1px solid black;}
	#chatList{width:100%; height:90%; overflow:auto; border:1px solid black;}
	#sendChat{width:80%; height:10%; float:left; overflow:auto; border:1px solid black;}
	#send{width:20%; height:10%; float:right;}
	#myMsg{text-align:right;}
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
			})
			
			
			ws.onmessage = function(e){
				let data = JSON.parse(e.data);
				
				console.log("출력데이터 : "+ typeof data)
				
				if(!Array.isArray(data)){
					data = [data];
				}
					for(let i = 0; i<data.length; i++){
						const line = $("<div>");
						if(data[i].sender=="${loginId}"){
							line.attr("id","myMsg");
						}
						line.append(data[i].sender +" <br> "+ data[i].message);
						$("#chatList").append(line);
				}
				
				$("#chatList").scrollTop($("#chatList")[0].scrollHeight); 
				
				
				/* let chat = $("<div>");
				let sender = data.userId;
				let message = data.message;
				
				
				
				if(sender=="${loginId}"){
					chat.attr("id","myMsg");
				}
				chat.append(sender+"<br>"+message);
				$("#chatList").append(chat);
				*/
				
			}
		});
		
	</script>
	
	<div id="chatBox">
		<div id="chatList">
			
		</div>
		<div id="sendChat" contenteditable="true"></div>
		<button id="send">전송</button>
	</div>
	
</body>
</html>