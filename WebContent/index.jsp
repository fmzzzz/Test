<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="login">
        <img src="image/logo.png" alt="智游">
        <p>智游客户关系管理系统</p>
        <form action="user/login" method="post">
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