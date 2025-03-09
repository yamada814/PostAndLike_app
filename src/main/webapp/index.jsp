<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ page session="false" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Sample</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
    	<form action="Login.action" method="post">
	    <p>TITLE</p>
	        <label>LOGIN ID：<input type="text" name="loginId" autofocus required></label><br>
	        <label>PASSWORD：<input type="password" name="password" required></label><br>
	        <button type="submit">LOGIN</button>
	    <table border="1">
	        <tr>
	            <th>id</th>
	            <th>login_id</th>
	            <th>password</th>
	        </tr>
	        <tr>
	            <td>1</td>
	            <td>ayukawa</td>
	            <td>SweetfishRevier1</td>
	        </tr>
	        <tr>
	            <td>2</td>
	            <td>samejima</td>
	            <td>SharkIsland2</td>
	        </tr>
	        <tr>
	            <td>3</td>
	            <td>wanibuchi</td>
	            <td>CrocodileChasm3</td>
	        </tr>
	        <tr>
	            <td>4</td>
	            <td>ebihara</td>
	            <td>ShrimpField4</td>
	        </tr>
	        <tr>
	            <td>5</td>
	            <td>kanie</td>
	            <td>CrubBay5</td>
	        </tr>
	        <tr>
	            <td>6</td>
	            <td>admin</td>
	            <td>AdminCarp6</td>
	        </tr>
	        </table>
        </form>
</body>
</html>