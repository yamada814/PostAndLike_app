<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
<style>
	body{
	    display: flex;
	}
	aside{
	    background-color: #1a7979;
	    color: white;
	    width: 30%;
	    height: 100vh;
	    min-width: 300px;
	    position:sticky;
	    left:0;
	    top:0;
	}
	#title{
	    text-align: center;
	}
	#title h1{
	    font-size: 24px;
	}
	#title h2{
		color:rgb(237, 223, 77);
		font-size: 30px;
	    letter-spacing: 0.1em;
	    border-bottom: 1px solid white;
	}
	#postform{
	    text-align: center;
	}
	textarea{
	    font-size: 20px;    
	    border-radius: 10px;
	    border: 2px solid #aaaaaa;
	    width: 80%;
	    padding: 5px;
	    resize: none;
	    box-sizing: border-box;
	}
	#postbtn{
	    font: size 24px;
	    font-weight: bold;
	    letter-spacing: 0.5em;
	    box-sizing: border-box;
	    width: 80%;
	    height: 30px;
	    background-color: white;
	    color: #1a7979;
	    border: 2px solid #aaaaaa;
	    border-radius: 10px;
	    margin-top:10px;
	}
	#postbtn:hover{
	    background-color: rgb(237, 223, 77);
	    color: #1a7979;
	}
	select{
	    border: 2px solid #aaaaaa;
	    border-radius: 5px;
	    height: 30px;
	}
	#menu div{
	    margin: 0;
	}
	#menu div a{
	    display: block;
	    margin: 0;
	    color: white;
	    padding: 10px 20px;
	}  
	#menu i{
	    margin-right:20px;
	}
	#menu div a:hover{
	    color: #1a7979;
	    background-color: white;
	}
</style>
<aside>
	<div id="title">
		<h1>TITLE</h1>
		<h2>${customer.loginId}</h2>
	</div>
   	<form action="BoardPost.action" method="post" id="postform">
       	<label>Contents<br><textarea name="contents" maxlength="50" placeholder="50字以内"></textarea></label><br>
       	<button type="submit" id="postbtn">POST</button><br><br>
    </form>
	<div id="menu">
	    <div><a href="BoardHome.action"><i class="bi bi-house-door-fill"></i>ホーム</a></div>
	    <div><a href="AccountPage.action?account=${customer.loginId}"><i class="bi bi-person-circle"></i>マイページ</a></div>
	    <div><a href="MyLikesList.action"><i class="bi bi-bookmark-heart-fill"></i>いいね一覧</a></div>
	    <div><a href="Setting.action"><i class="bi bi-gear-fill"></i>設定</a></div>
	    <c:if test="${customer.role == 'ADMIN'}">
	       <div><a href="RegisterForm.action"><i class="bi bi-person-fill-add"></i>アカウント登録<small>（管理者のみ）</small></a></div>
	       <div><a href="AccountList.action"><i class="bi bi-list-ul"></i>ユーザ一覧<small>（管理者のみ）</small></a></div>
	    </c:if>			
	        <div> <a href="Logout.action"><i class="bi bi-box-arrow-right"></i>ログアウト</a></div>
	    </div>
	</aside>