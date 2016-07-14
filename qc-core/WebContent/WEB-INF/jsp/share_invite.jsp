<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body>
    <div class="invite_top">
        <img src="${path }/imgs/pic5.jpg">
        <div class="invite_info">
            <span>已邀请好友：${shareInvite.inviteCount }人</span>
            <span>累计收益：<fmt:formatNumber value="${shareInvite.invitePointF}" pattern=".00"/>元</span>
        </div>
    </div>
    <div class="invite_divide"></div>
    <div class="invite_bottom">
        <div class="invite_title">
            <p>邀请码：<span>${shareInvite.inviteId }</span><a href="spread://copy?${shareInvite.inviteId }">点击复制</a></p>
        </div>
        <div class="invite_content">
            <ul>
                <li>1、邀请好友时，请告诉好友您的邀请码</li>
                <li>2、被邀请的好友需要在手机注册页面或者用户中心点击头像进入的页面输入您的邀请码才会给予奖励</li>
                <li>3、每邀请成功一个好友，系统会一次性给予2元奖励，邀请无上限</li>
            </ul>
        </div>
    </div>
</body>
</html>