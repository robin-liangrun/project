<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页 客户信息查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/crm.js"></script>
</head>

<body>
  	<h2 style="text-align: center;">
  		客户信息查询
  	</h2>
  	<div style="width: 100%; text-align: right;">
		<c:if test="${empty username }">
	  	<a href="/login">管理员登录</a>
	  	</c:if>
	  	<c:if test="${not empty username }">
	  	<a href="/customer/batch">后台管理</a>
	  	<a href="/logout">退出登录</a>
	  	</c:if>
	  	</div>
  	<hr/>
  	<form action="/search" method="post">
  		<table class="table table-striped table-bordered" style="border: 1px solid #dddddd">
  		<c:if test="${not empty username }">
  		<tr>
  		<th>客户分类：</th><td><select name="type">
  			<option value="">请选择</option>
  			<c:forEach items="${TypeList }" var="type">
  			<option value="${type}">${type}</option>
  			</c:forEach>
  		</select></td>
  		<th>
  		业务组别：</th><td><select name="salegroup">
  			<option value="">请选择</option>
  			<c:forEach items="${SalegroupList }" var="salegroup">
  			<option value="${salegroup}">${salegroup}</option>
  			</c:forEach>
  		</select></td>
  		</tr>
  		<tr>
  		<th>
  		所在省：</th><td><input type="text" name="province"></td>
  		<th>
  		所在市：</th><td><input type="text" name="city"></td>
  		</tr>
  		<tr>
  		<th>业务姓名：</th><td><input type="text" name="sale"></td>
  		<th>
  		合同类别：</th><td><select name="agreementtype">
  			<option value="">请选择</option>
  			<c:forEach items="${AgreementtypeList }" var="agreementtype">
  			<option value="${agreementtype}">${agreementtype}</option>
  			</c:forEach>
  		</select></td>
  		</tr>
  		<th>城市等级：</th><td><select name="level">
  			<option value="">请选择</option>
  			<c:forEach items="${LevelList }" var="level">
  			<option value="${level}">${level}</option>
  			</c:forEach>
  		</select></td>
  		<th>
  		签约产品：</th><td><select name="signproduct">
  			<option value="">请选择</option>
  			<c:forEach items="${SignproductList }" var="signproduct">
  			<option value="${signproduct}">${signproduct}</option>
  			</c:forEach>
  		</select></td>
  		</tr>
  		</c:if>
  		<tr>
  		<th>
  		公司名称：</th><td colspan="3"><input type="text" name="fullname" class="input-medium search-query" style="height: 30px; width: 500px"/></td>
  		</tr>
  		<tr>
  		<th>
  		是否保护：</th><td colspan="3"><select name="protection">
  			<option value="">请选择</option>
  			<option value="是">是</option>
  			<option value="否">否</option>
  		</select></td>
  		</tr>
  		<tr><td colspan="4"><input type="submit" value="查询" class="btn"/></td>
  		</tr>
  		</table>
  	</form>
  	查询结果-总条数（${count }）,详细信息如下：
  	<table class="table table-striped table-bordered" style="border: 1px solid #dddddd;">
  		<thead>
  		<tr>
  			<c:if test="${not empty username }">
  			<th><nobr>客户信息</br>提报日期</nobr></th>
  			<th><nobr>客户编码</nobr></th>
  			</c:if>
  			<th><nobr>客户分类</nobr></th>
  			<c:if test="${not empty username }">
  			<th><nobr>业务组别</nobr></th>
  			</c:if>
  			<th><nobr>业务姓名</nobr></th>
  			<th><nobr>所在省</nobr></th>
  			<th><nobr>所在市</nobr></th>
  			<c:if test="${not empty username }">
  			<th><nobr>城市等级</nobr></th>
  			<th><nobr>客户/简称</nobr></th>
  			<th><nobr>业务联系人</nobr></th>
  			<th><nobr>联系电话</nobr></th>
  			<th><nobr>固定电话</nobr></th>
  			<th><nobr>QQ</nobr></th>
  			<th><nobr>E-Mail</nobr></th>
  			</c:if>
  			<th><nobr>公司全称</nobr></th>
  			<c:if test="${not empty username }">
  			<th><nobr>公司地址</nobr></th>
  			<th><nobr>公司网站</nobr></th>
  			<th><nobr>业务范围及主营业务内容</nobr></th>
  			<th><nobr>法定负责人</nobr></th>
  			<th><nobr>签约日期</nobr></th>
  			<th><nobr>签约产品</nobr></th>
  			<th><nobr>合同类别</nobr></th>
  			<th><nobr>备案证照</nobr></th>
  			<th><nobr>备案资料</nobr></th>
  			<th><nobr>变更次数</nobr></th>
  			<th><nobr>变更内容</nobr></th>
  			<th><nobr>备注</nobr></th>
  			</c:if>
  			<th><nobr>是否保护</nobr></th>
  		</tr>
  		</thead>
  		<tbody>
  		<c:forEach items="${customerList }" var="customer">
  		<tr>
  			<c:if test="${not empty username }">
  			<td>${customer.createdate }</td>
  			<td>${customer.code }</td>
  			</c:if>
  			<td>${customer.type }</td>
  			<c:if test="${not empty username }">
  			<td>${customer.salegroup }</td>
  			</c:if>
  			<td>${customer.sale }</td>
  			<td>${customer.province }</td>
  			<td>${customer.city }</td>
  			<c:if test="${not empty username }">
  			<td>${customer.level }</td>
  			<td>${customer.simplename }</td>
  			<td>${customer.contact }</td>
  			<td>${customer.phone }</td>
  			<td>${customer.mobile }</td>
  			<td>${customer.qq }</td>
  			<td>${customer.email }</td>
  			</c:if>
  			<td>${customer.fullname }</td>
  			<c:if test="${not empty username }">
  			<td>${customer.address }</td>
  			<td>${customer.site }</td>
  			<td>${customer.business }</td>
  			<td>${customer.legalperson }</td>
  			<td>${customer.signtime }</td>
  			<td>${customer.signproduct }</td>
  			<td>${customer.agreementtype }</td>
  			<td>${customer.recordidnumber }</td>
  			<td>${customer.recordmemo }</td>
  			<td>${customer.updatecount }</td>
  			<td>${customer.updatecontent }</td>
  			<td>${customer.memo }</td>
  			</c:if>
  			<td>${customer.protection }</td>
  		</tr>
  		</c:forEach>
  		</tbody>
  	</table>
</body>
</html> 