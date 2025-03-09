<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
{
  "loginIdList": [
    <c:forEach var="customer" items="${whoLikesList}" varStatus="status">
      "<c:out value="${customer.loginId}" />"
      <c:if test="${!status.last}">,</c:if>
    </c:forEach>
  ]
}