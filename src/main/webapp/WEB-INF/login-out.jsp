
<%-- /WEB-INF/login-out.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,bean.Board"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/login-out.js" defer></script>
<%-- <script src="./js/post.js" defer></script> --%>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/login-out.css">
</head>
<body>
<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
    <main>
		<div id="pageInfoContainer">
		    <div id="pageInfo">
		    	<c:choose>
		    		<c:when test="${not empty account}">
		        		<p class="accountName">${account}</p>
		       		</c:when>
		       		<c:otherwise>
		       			<p class="accountName">みんなの投稿</p>
				 		<form action="BoardSort.action">
				     		<select name="sort">
				         		<option value="new">新しい順</option>
				         		<option value="old">古い順</option>
				         		<option value="like">いいね順</option>
				     		</select>
				     		<button type="submit" id="sortbtn"><i class="bi bi-sort-down"></i></button>
				 		</form> 
		       		</c:otherwise>
		       	</c:choose>
				<p><i class="bi bi-heart"></i> total = <span id="sumLikes"></span></p>
		        <c:if test="${account == customer.loginId}">
		            <form action="BoardClear.action">
		                <button type="submit"><i class="bi bi-trash3"></i>&nbsp;ALL POSTS</button><br>
		            </form>
		        </c:if>
		    </div>
		</div>
<%-- 	   <article class="hiddenArticle">
	        <div class="articleHead">
	            <div><a href="AccountPage.action?account=${board.loginId}" id="hiddenLoginId"></a></div>
	            <div class="date" id="hiddenMydate">mydate</div>
	        </div>
	        <div class="contents" id="hiddenContents">contents</div>
	        <div class="articleFoot">
				        <div><i class="bi bi-heart"></i>：<a class="likes" href="MyLikesList.action" id="hiddenLikes">0</a></div>
			        	<div><a href="BoardClearItem.action?id=${board.id}"><i class="bi bi-trash3"></i></a></div>
	        </div>
	    </article> --%>
		<c:forEach var="board" items="${boardList}">
		    <article>
		        <div class="articleHead">
		            <div><a href="AccountPage.action?account=${board.loginId}">${board.loginId}</a></div>
		            <div class="date">${board.mydate}</div>
		        </div>
		        <div class="contents">${board.contents}</div>
		        <div class="articleFoot">
			        <div>
				        <button class="likeBtn" data-board-id="${board.id}" data-board-loginId="${board.loginId}"><i class="bi bi-heart likeAction"></i></button>
				        ：
				        <button class="likeCount" data-board-id="${board.id}">${board.likes}</button>
				        <div class="hidden whoLikesList">
					        <p>いいねした人</p>
					        <ul></ul>
				    	</div>
				    </div>
				    	
			    	<div>
	        			<c:if test="${board.loginId == customer.loginId}">
			        		<a href="BoardClearItem.action?id=${board.id}"><i class="bi bi-trash3"></i></a>
				        </c:if>
			        </div>
		        </div>
		    </article>
		</c:forEach>
    </main>
    <script>
	  <%-- いいね合計数を表示 --%>
	    document.addEventListener("DOMContentLoaded",()=>{	
	    	const likes = document.querySelectorAll(".likeCount");
	    	let sum = 0;
	    	likes.forEach(num => {
	    	    sum += parseInt(num.textContent);
	    	})
	    	const sumLikes = document.getElementById("sumLikes");
	    	if(sumLikes !== null){
	    		sumLikes.textContent = sum;	
	    	}	
	    })
    </script>
</body>
</html>