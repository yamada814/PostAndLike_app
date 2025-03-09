<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/setting.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
	    <h1>アカウント設定</h1>
	    <ul>
	        <li><a href="PasswordUpdate.action">パスワードの変更</a></li>
	        <li><a href="">ログインIDの変更</a></li>
	        <li><a href="">プロフィールの変更</a></li>
	    </ul>
	    <p><a href="Login.action">Back</a><p>
	</main>
</body>
</html>