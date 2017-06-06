<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basePath = request.getContextPath();

	// 注意本页面有两种应用路径的解决方法：
	// 方法1：用JSTL的URL标签（需要下载JSTL的2个jar包，并在web.xml中配置，关于JSTL用一个学一个）。
	// 方法2：用request.getContextPath()获取并拼接到URL上。
	// 组织学生讨论：使用哪个方法比较好？
	
	// 注意：给学生讲的时候，一定要区分清楚下面几个方面（避免学生搞混）：
	// 1.HTML、CSS
	// 2.JSP
	// 3.JSTL
	// 4.Servlet
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<%= basePath + "/css/index.css" %>">
</head>
<body>
	<div class="login">
        <img src="<c:url value="/image/logo.png" />" alt="智游">
        <p>智游客户关系管理系统</p>
        <form action="<c:url value="/user/login" />" method="post">
            <div>
                <input type="text" id="username" name="username" value="" placeholder="请输入用户名">
            </div>
            <div>
                <input type="password" id="password" name="password" value="" placeholder="请输入密码">
            </div>
            <div>
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
</body>
</html>