<%-- /WEB-INF/accountList-error.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,bean.Board"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="/css/common-out.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
		<div>
		    <h1>AccountList does not exist.</h1>
		    <a href="Login.action">Back</a></p>
		</div>
	</main>


</body>
</html>