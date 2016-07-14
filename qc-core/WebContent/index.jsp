<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
	
	<h2>获取验证码</h2>
	<form action="${path }/public/system/code" method="post">
		手机号：<input type="text" name="account">
		<br>
		类型：<input type="text" name="type">
		<br>
		<input type="submit" value="提交">
	</form>
	
	<h2>登录</h2>
	<form action="${path }/public/system/lgn" method="post">
		手机号：<input type="text" name="account">
		<br>
		密码：<input type="text" name="password">
		<br>
		<input type="submit" value="提交">
	</form>
	
	<h2>修改信息</h2>
	<form action="${path }/public/user/updateInfo" method="post">
		头像：<input type="text" name="headimg">
		<br>
		昵称：<input type="text" name="nickname">
		<br>
		性别：<input type="text" name="sex">
		<br>
		邀请ID：<input type="text" name="inviteId">
		<br>
		<input type="submit" value="提交">
	</form>
	
</body>
</html>