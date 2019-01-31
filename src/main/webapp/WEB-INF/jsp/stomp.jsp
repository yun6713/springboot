<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/sockjs-client/1.3.0/sockjs.js"></script>
</head>
<body>
	<div>
		<input type='button' id='connect' value='连接'/>
		<input type='button' id='disconnect' value='断开连接' disabled/>
	</div>
	<div>
		<input type='text' id='info'/>
		<input type='button' id='send' value='发送' disabled/>
		<p id='response'></p>
	</div>
	<input type='hidden' id='contextPath' value=${contextPath}/>
	<script>
		var webpath = '/web';$('#contextPath').val();
		var stompClient;
		$(function(){
			$('#connect').click(function(){
				let socket = new SockJS(webpath+'/myEndpoint');
				stompClient = Stomp.over(socket);
				stompClient.connect({},function(frame){
					setConnected(true);
					console.log('connect:'+frame);
					stompClient.subscribe("/stomp/test02",function (response) {
	                    console.log(response);
	                    $('#response').html(JSON.stringify(response));
	                });
				})
			});
			$('#disconnect').click(function(){
				stompClient && stompClient.disconnect();
				setConnected(false);
			});
			$('#send').click(function(){
				stompClient.send('/stomp/test01',{},JSON.stringify({info: $("#info").val()}))
			});
		});
		function setConnected(bool){
			$('#connect').attr('disabled',bool);
			$('#disconnect').attr('disabled',!bool);
			$('#send').attr('disabled',!bool);
			
		}
	</script>
</body>
</html>