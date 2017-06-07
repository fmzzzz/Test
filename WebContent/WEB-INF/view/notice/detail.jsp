<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告详情 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>公告详情</h3>
		<form action="<c:url value="/notice/add" />" method="post">
			<table class="form-table">
				<tr>
					<td class="label">发布时间</td>
					<td class="detail">
						2017-06-06 09:00
					</td>
					<td class="label">截止时间</td>
					<td class="detail">
						2017-06-15 18:00
					</td>
				</tr>
				<tr>
					<td class="label">主题</td>
					<td class="detail">
						欢迎沙僧加入取经团队
					</td>
					<td class="label">通知范围</td>
					<td class="detail">
						全部
					</td>
				</tr>
				<tr>
					<td class="label">内容</td>
					<td colspan="3" class="detail">
						沙僧，又叫沙和尚、沙悟净，出自四大名著之《西游记》。在书中也称黄婆，土母、刀圭，五行属土，俗称沙和尚、沙僧。原为天宫玉皇大帝的卷帘大将，因为失手不小心打破了琉璃盏，触犯天条，被贬出天界，在人间流沙河兴风作浪，危害一方，专吃过路人。后经观音点化，赐法号悟净，一心归佛，同八戒、悟空一同保大唐高僧玄奘法师（又称唐三藏或唐僧，俗名陈祎）西天拜佛求取真经。
					</td>
				</tr>
			</table>
			<div class="buttons">
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>