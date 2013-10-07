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
		<a href="/">返回首页</a>
		<h2 style="text-align: center;">登录</h2>
		<form action="/login" method="post" class="form-horizontal">
			<c:if test="${not empty message}">
       		<div class="alert alert-error">${message}</div>
       		</c:if>
            <div class="control-group">
			    <label class="control-label" for="username">用户名</label>
			    <div class="controls">
			    	<input type="text" name="username" id="username"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <label class="control-label" for="password">密码</label>
			    <div class="controls">
			    	<input type="password" name="password" id="password"/>
			    </div>
		  	</div>
		  	<div class="control-group">
			    <div class="controls">
			    	<input type="submit" value="登录" class="btn"/><a href="/password">修改密码</a>
			    </div>
		  	</div>
	  	</form>
  	</div>
</body>
</html> 