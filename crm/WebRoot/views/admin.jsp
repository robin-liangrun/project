<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>

<body>
	<div class="container">
		<div style="width: 100%; text-align: right;">
			<a href="${pageContext.request.contextPath}/">返回首页</a>
	  		<a href="${pageContext.request.contextPath}/logout">退出登录</a>
	  	</div>
		<h2 style="text-align: center;">后台管理</h2>
		<div class="tabbable tabs-left">
			<ul class="nav nav-tabs">
				<c:if test="${not empty username && (username == 'admin' || username == 'import') }">
				<li class="<c:if test="${empty item or item == 1 }">active</c:if>"><a href="#lA" data-toggle="tab">导入文件</a></li>
				</c:if>
				<c:if test="${not empty username && (username == 'admin') }">
				<li class="<c:if test="${item == 3 }">active</c:if>"><a href="#lC" data-toggle="tab">导出文件</a></li>
				</c:if>
				<li class="<c:if test="${item == 2 }">active</c:if>"><a href="#lB" data-toggle="tab">添加管理员</a></li>
			</ul>
			<div class="tab-content" style="border-top: 1px solid #DDD;border-right: 1px solid #DDD;border-bottom: 1px solid #DDD;margin-left: 0px; padding-right: 0px;">
				<c:if test="${not empty username && (username == 'admin' || username == 'import') }">
				<div class="tab-pane <c:if test="${empty item or item == 1 }">active</c:if>" id="lA">
					<c:if test="${not empty error}">
		       		<div class="alert alert-error">${error}</div>
		       		</c:if>
		       		<c:if test="${not empty success}">
		       		<div class="alert alert-success">${success}</div>
		       		</c:if>
                	<form action="${pageContext.request.contextPath}/customer/batch" method="post" enctype="multipart/form-data" class="form-horizontal">
                		<div class="control-group">
						    <label class="control-label" for="inputEmail">选择文件</label>
						    <div class="controls">
						    	<input type="file" name="dataFile"/>
						    </div>
					  	</div>
					  	<div class="control-group">
						    <div class="controls">
						    	<input type="submit" value="导入" class="btn"/>
						    </div>
					  	</div>
				  	</form>
                </div>
                </c:if>
                <c:if test="${not empty username && (username == 'admin') }">
                <div class="tab-pane <c:if test="${item == 2 }">active</c:if>" id="lB">
                	<form action="${pageContext.request.contextPath}/user" method="post">
                		<c:if test="${not empty message}">
                		<div class="alert alert-error">${message}</div>
                		</c:if>
				  		<div class="control-group">
						    <label class="control-label" for="username">用户名</label>
						    <div class="controls">
						    	<input type="text" id="username" placeholdyoner="密码" name="username"/>
						    </div>
					  	</div>
					  	<div class="control-group">
						    <label class="control-label" for="password">密码</label>
						    <div class="controls">
						    	<input type="password" id="password" placeholder="密码" name="password"/>
						    </div>
					  	</div>
					  	<div class="control-group">
						    <div class="controls">
						    	<input type="submit" value="添加" class="btn"/>
						    </div>
					  	</div>
				  	</form>
                </div>
                </c:if>
                <div class="tab-pane <c:if test="${item == 3 }">active</c:if>" id="lC">
                	<form action="${pageContext.request.contextPath}/customers" method="get">
                		<c:if test="${not empty message}">
                		<div class="alert alert-error">${message}</div>
                		</c:if>
					  	<div class="control-group">
						    <div class="controls">
						    	<input type="submit" value="导出" class="btn"/>
						    </div>
					  	</div>
				  	</form>
                </div>
		  	</div>
	  	</div>
  	</div>
</body>
</html> 
    