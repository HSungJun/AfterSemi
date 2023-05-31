<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stomp Practice</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<body> 

	<input type="text" id="message" placeholder="서버로 전송할 메세지 입력">
	<button id="send">전송</button>

	
	<script>
		const socket = new WebSocket("ws://192.168.0.38/chat");
		const stompClient = Stomp.over(socket);
		
		stompClient.connect ({},function(){
						/* header 정보 > stomp 연결에 적용할 설정 정보 > 
						두번쨰 파라미터- Stomp 연결에 성골했을떄 실행할 callback */
			
				//subscription 함수의 반환값은 구독정보 객체, 향후 구독취소등에 사용될 수 있으므로 변수로 보관		
				const subscription = stompClient.subscribe("/topic/test",function(message){
				console.log(message);
			});		
			// /topic/chat 채널을 구독, 해당채널로부터 message받아서 출력
			
		},function(error){
			console.log("연결실패");
			console.log(error);
			
		})
		
		document.getElementById("send").onclick = function(){
			let message = document.getElementById("message").value;
			const destination = "/app/message";
			const header = {};
			const body = JSON.stringify({name:"JJ",message:message}) //string 형태로 변환하여 저장
			stompClient.send(destination, header, body);
		}
		
		
	</script>
	
	
	
	
	
</body>
</html>