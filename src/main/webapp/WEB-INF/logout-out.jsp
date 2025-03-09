<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Samples</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/common-error.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/header.jsp"/>
	<main>
	    <h1>ログアウトしました</h1>
	    <p><strong>Login again?</strong><br>
	    <a href="LoginAgain.action">LOGIN</a></p>
	</main>

</body>
</html>