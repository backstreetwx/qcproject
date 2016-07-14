<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="趣传">
    <meta name="author" content="jason">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="email=no" name="format-detection">
    <title></title>
    <!--加载css文件-->
    <link type="text/css" rel="stylesheet" href="${path }/css/main.css?v=1">
</head>
<body style="background: #e5e5e5">
    <div class="about_icon">
        <img src="${path }/imgs/pic5.jpg?v=1">
    </div>
    <div class="about_fun">
        <ul>
            <li>功能介绍<span class="arrow"></span><a href="${path }/public/system/intro"></a></li>
            <li>客服咨询请关注微信公众号：趣传（quchuan18）<span class="arrow"></span></li>
        	<li>商务合作1（电话/微信）:17002131689<span class="arrow"></span><a href="tel:17002131689"></a></li>
        	<li>商务合作2（QQ/微信):89255913<span class="arrow"></span></li>
        </ul>
    </div>
</body>
</html>