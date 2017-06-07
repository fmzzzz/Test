<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知公告 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>通知公告</h3>
		<div class="actions">
			<form action="<c:url value="/notice/list" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name="seachKey" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="seachField">
					<option value="subject">主题</option>
					<option value="text">内容</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				<a class="btn btn-primary" href="<c:url value="/notice/add" />">发布公告</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>公告人</th>
                <th>公告主题</th>
                <th>通知范围</th>
                <th>公告内容</th>
                <th>公告时间</th>
                <th>截止时间</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>1</td>
                <td>唐僧</td>
                <td>欢迎沙僧加入取经团队</td>
                <td>全部</td>
                <td>
                	<a title="查看详情" href="<c:url value="/notice/detail" />" >
                		沙僧，原为天宫玉皇大帝的卷帘大将...后经观音点化，赐法号悟净，一心归佛...
                	</a>
                </td>
                <td>2017-06-07 18:00</td>
                <td>2017-06-15</td>
                <td>
                	<a class="fa fa-pencil" title="编辑" href="<c:url value="/notice/update" />"></a>&nbsp;&nbsp;
                	<i class="fa fa-remove" title="删除"></i>
                </td>
            </tr>
            <tr>
                <td>1</td>
                <td>唐僧</td>
                <td>欢迎猪八戒加入取经团队</td>
                <td>全部</td>
                <td>
                	<a title="查看详情" href="<c:url value="/notice/detail" />" >
               			猪八戒，原为天宫玉皇大帝的天蓬元帅...后经观音点化，赐法号悟能，一心归佛...</td>
               		</a>
                <td>2017-06-07 18:00</td>
                <td>2017-06-15</td>
                <td>
                	<a class="fa fa-pencil" title="编辑" href="<c:url value="/notice/update" />"></a>&nbsp;&nbsp;
                	<i class="fa fa-remove" title="删除"></i>
                </td>
            </tr>
        </table>
        <div class="pager-info">
        	<div>共有 2 条记录，第 1/1 页 </div>
        	<div>
        		<ul class="pagination">
        			<li class="paginate_button previous disabled">
        				<a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0">上一页</a>
        			</li>
        			<li class="paginate_button active">
        				<a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0">1</a>
        			</li>
        			<li class="paginate_button ">
        				<a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0">2</a>
        			</li>
        			<li class="paginate_button ">
        				<a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0">3</a>
        			</li>
        			<li class="paginate_button ">
        				<a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0">4</a>
        			</li>
        			<li class="paginate_button ">
        				<a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0">5</a>
        			</li>
        			<li class="paginate_button ">
        				<a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0">6</a>
        			</li>
        			<li class="paginate_button next">
        				<a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">下一页</a>
        			</li>
        		</ul>
        	</div>
        </div>
	</div>
</body>
</html>