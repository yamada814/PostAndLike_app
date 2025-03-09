<%-- session-error.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Samples</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/common-error.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/common/header.jsp"/>
	<main>
	    <h1>Session is expired or invalid</h1>
	    <p><strong>Login Again?</strong><br>
	    <a href="LoginAgain.action">Login</a></p>
	</main>
</body>
</html>