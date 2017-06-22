<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>用户列表</h3>
		<div class="actions">
			<form id="searchForm" action="<c:url value="/user/list" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name="keyword" value="${ keyword }" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="searchField">
					<option value="username" ${ field=="username"?"selected":"" }>用户名</option>
					<option value="mobile" ${ field=="mobile"?"selected":"" }>手机号</option>
					<option value="address" ${ field=="address"?"selected":"" }>地址</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="hidden" id="pageNo" name="pageNo" value="${ pageNo }">
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>部门</th>
                <th>角色</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>更新时间</th>
            </tr>
            <c:forEach var="user" items="${ list }">
            <tr>
                <td>${ user.userId }</td>
                <td>
                	<a title="查看详情" href="<c:url value="/user/detail?id=" />${user.userId}" >
	                	${ user.username }
	                </a>
	            </td>
                <td>${ user.departmentId }</td>
                <td>${ user.roleId }</td>
                <td>${ user.mobile }</td>
                <td>${ user.email }</td>
                <td>
                	<fmt:formatDate value="${user.updateTime}" type="both" pattern="MM-dd HH:mm"/>
                </td>
            </tr>
            </c:forEach>
        </table>
        <div class="pager-info">
        	<div>共有 ${ pager.total } 条记录，第 ${ pager.pageNo }/${ pager.pageCount } 页 </div>
        	<div>
        		<ul class="pagination">
        			<li class="paginate_button previous ${ pager.pageNo==1?'disabled':'' }"
        				<c:choose>
        					<c:when test="${ pager.pageNo > 1 }">
        					onclick="goPage(${pager.pageNo-1})"
        					</c:when>
        				</c:choose>
        			>
        				<a href="#">上一页</a>
        			</li>
        			<c:forEach var="p" begin="${ pager.start }" end="${ pager.end }">
        			<li class="paginate_button <c:out value="${ pager.pageNo==p?'active':'' }" />" 
        				onclick="goPage(${p})">
        				<a href="#">${ p }</a>
        			</li>	
        			</c:forEach>
        			<li class="paginate_button next ${ pager.pageNo==pager.pageCount?'disabled':'' }"
        				<c:choose>
        					<c:when test="${ pager.pageNo < pager.pageCount }">
        					onclick="goPage(${pager.pageNo+1})"
        					</c:when>
        				</c:choose>
        			>
        				<a href="#">下一页</a>
        			</li>
        		</ul>
        	</div>
        </div>
	</div>
	<script src="<c:url value="/lib/jquery/jquery.js" />"></script>
	<script>
    	function goPage(pageNo) {
    		$('#pageNo').val(pageNo);
    		$('#searchForm').submit();
    	}
    </script>
</body>
</html>