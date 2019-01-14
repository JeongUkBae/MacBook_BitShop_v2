<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹웨어</title>
<link rel="stylesheet"
	href="${context}/resources/css/style.css" />
</head>
<body>
<div style="width: 100%">
<section>
<article>
	<h1 id="title">회원 전용 시스템</h1>
	<table id="login-outer-tab">
		<tr>
			<td colspan="5">
				<form id="login-form" action="member.do">
					<table id="login-inner-tab">
						<tr>
							<td><input id="uid" name="uid"
								type="text" placeholder="ID" tabindex="1" />
							</td>
							<td rowspan="2">
								<button id="login-btn">LOGIN</button>
							</td>
						</tr>
						<tr>
							<td><input id="upw" name="upw"
									type="password" placeholder="PASSWORD"
									tabindex="2" /> 
								<input type="hidden" name="cmd" value="login" /> 
								<input type="hidden" name="dir" value="home" /> 
							</td>
						</tr>
					</table>
				</form> 
				<a id="admin-link" href="#"> 관리자 </a> 
						<a id="join-link" onclick="join()" href="#"> 회원가입 </a>
			</td>
		</tr>
	</table>
</article>
</section>

</div>
<script>
/*location.assign('member.do?dest=join-form'); */
/* 	window.onload = function(){
		location.assign('member.do?dest=join-form');
	} */
/*	document.getElementById('join-link')
	.addEventListener('click', function() { //어나니머스 함수 (이름지움.)
		alert('회원가입 클릭');
		location.assign('member.do?dest=join-form');
	}); */
	// move 이면 클릭이벤트가 리스닝되고,
	// move() 가 있으면 즉시 실행됨.
	// 'click', function(){} 하면 콜백함수가 호출된다. 

</script>
</body>
</html>