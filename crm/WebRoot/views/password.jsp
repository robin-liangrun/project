<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
	<div class="container">
		<h2 style="text-align: center;">修改密码</h2>
		<form action="/password?_method=PUT" method="post">
       		<c:if test="${not empty message}">
       		<div class="alert alert-error">${message}</div>
       		</c:if>
	  		<div class="control-group">
			    <label class="control-label" for="username">用户名</label>
			    <div class="controls">
			    	<input type="text" id="username" placeholdyoner="用户名" name="username"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <label class="control-label" for="oldPassword">当前密码</label>
			    <div class="controls">
			    	<input type="password" id="oldPassword" placeholder="当前密码" name="oldPassword"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <label class="control-label" for="oldPassword">新密码</label>
			    <div class="controls">
			    	<input type="password" id="password" placeholder="新密码" name="password"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <label class="control-label" for="rePassword">重复密码</label>
			    <div class="controls">
			    	<input type="password" id="rePassword" placeholder="重复密码" name="rePassword"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <div class="controls">
			    	<input type="submit" value="修改" class="btn"/>
			    </div>
		  	</div>
	  	</form>
  	</div>
</body>
</html> 
    