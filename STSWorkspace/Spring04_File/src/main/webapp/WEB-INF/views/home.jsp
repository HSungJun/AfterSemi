<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Practice</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>

	<fieldset>
		<legend>File Practice</legend>
	<form action="/file/upload" method="post" enctype="multipart/form-data">
	<input type="text" placeholder="메세지 입력" name="message"><br>
	<input type="file" value="첨부파일" name="files" multiple><br>
	<button>제출</button>
	</form>
	</fieldset>
	
	
	<button id="getFiles">파일목록 불러오기</button>	
	<fieldset>
		<legend>File List</legend>
		<div id="files"></div>
		
	</fieldset>
	
	
	<script>
		$("#getFiles").on("click",function(){
			$.ajax({
				url:"/file/list"
			}).done(function(resp){

				for(let i =0; i<resp.length; i++){
					let anker = $("<a>");
					anker.attr("href","/file/download?sysName="+resp[i].sysName+"&oriName="+resp[i].oriName);
					anker.text(resp[i].oriName);
					
					let line=$("<div>");
					line.append(anker);
					
					$("#files").append(line);
				}
			})
		})	
	</script>
	
</body>
</html>