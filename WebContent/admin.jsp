<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页 - 智游客户关系管理系统</title>
</head>
<body>
	<h1>后台首页</h1>
	<p>
		当前用户：${sessionScope.username}
	</p>
	<p>
		<a href="<c:url value="/message.jsp" />">站内消息</a>
	</p>
	<p>
		<a href="<c:url value="/user/logout" />">退出</a>
	</p>
</body>
</html>