<%-- /WEB-INF/board-error.jsp --%>
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
	    <h1>board update error</h1>
	    <p>The contents characters have to be in 50 characters.</p>
	    <p><a href="BoardHome.action">HOME</a></p>
	</main>
</body>
</html>