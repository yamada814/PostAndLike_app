<%-- /WEB-INF/regist-out.jsp --%>
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
		    <h1>登録完了しました。</h1>
		    <p><a href="RegisterForm.action">Back</a></p>
		    <p><a href="BoardHome.action">Home</a></p>
		</div>
	</main>
</body>
</html>