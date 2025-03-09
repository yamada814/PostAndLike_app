<%-- /WEB-INF/accountList-out.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,bean.Board"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/accountList-out.css">
</head>
<body>
	<jsp:include page="/WEB-INF/common/sidemenu.jsp"/>
	<main>
	    <h1>ユーザ一覧</h1> 
	    <div>
		    <table>
		        <tr>
		            <th>
		                Login ID
		            </th>
		            <th>
		                Role
		            </th>
		        </tr>
		        <c:forEach var="customer" items="${customerList }">
		        <tr>
		            <td>
		                <c:out value="${customer.loginId}"/>
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${customer.role == 'ADMIN'}">
		            		管理者
		            		</c:when>
		            		<c:otherwise>
		            		一般ユーザー
		            		</c:otherwise>
		            	</c:choose>
		            </td>
		        </tr>
		        </c:forEach>
		    </table>
	    <a href="Login.action">Back</a></p>
	    </div>   
	</main>
</body>
</html>