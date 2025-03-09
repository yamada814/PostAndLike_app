<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/like.js" defer></script>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/likeList-out.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
		<h1>いいね一覧</h1>
		<c:forEach var="board" items="${mylikeList}">
		    <article>
		        <div class="articleHead">
		            <div><a href="AccountPage.action?account=${board.loginId}">${board.loginId}</a></div>
		            <div class="date">${board.mydate}</div>
		        </div>
		        <div class="contents">${board.contents}</div>
		        <div class="articleFoot">
						
		        </div>
		    </article>
		</c:forEach>
	</main>
</body>
</html>