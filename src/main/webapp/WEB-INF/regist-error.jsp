<%-- /WEB-INF/regist-error.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Sample</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/common-out.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
		<div>
		    <h1>すでに登録されています。</h1>
		    <p><a href="RegisterForm.action">登録画面へ</a></p>
		</div>
	</main>
</body>
</html>