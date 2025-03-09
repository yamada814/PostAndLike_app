<%-- /WEB-INF/regist-in.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Sample</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/regist-in.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
		<h1>アカウント登録</h1>
		<div>
		    <form action="Register.action" method="post">
		        <label>USER-ID：<input type="text" name="userId" pattern="[A-Za-z]{4,}" required autofocus></label>
		    	<p class="pattern">（英字4文字以上）</p>
		        <label>PASSWORD：<input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}$" required></label><br>
		        <p class="pattern">（大文字英字,小文字英字,数字を含む8文字以上）</p>
		        ROLE:
		        <label><input type="radio" name="role" value="GENERAL" checked required>一般ユーザー</label>
		        <label><input type="radio" name="role" value="ADMIN" required>管理者<br></label>
		        <button type="submit">登録</button>
		    </form>
		    <a href="Login.action">BACK</a>
		</div>
	</main>

</body>
</html>