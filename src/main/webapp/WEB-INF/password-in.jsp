<%-- /WEB-INF/password-in.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/password-in.css">
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
		<h1>パスワードの変更</h1>
		<div>
		    <p>新しいパスワードを入力してください。</p>
		    <form action="PasswordUpdate.action" method="post">
		    <p id="pattern">(大文字英字,小文字英字,数字を含む8文字以上)</p>
		        <label>PASSWORD：<input type="password" name="password" pattern="[A-Za-z0-9]{8,}" required autofocus></label><br>
		        <button type="submit">変更する</button>
		    </form>
		    <a href="Setting.action">Back</a>
		</div>
	</main>

</body>
</html>