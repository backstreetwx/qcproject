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
<body style="background: #efefef">
    <div class="intro">
        <img src="${path }/imgs/intro_1.png">
        <p>这是一个进行分享任务展示模块，用户可以通过点击进入某个任务的详细介绍并进行接下</p>
        <img src="${path }/imgs/intro_2.png">
        <p>分享之后，每次点击能给用户带来的收益</p>
        <img src="${path }/imgs/intro_3.png">
        <p>这是用来展示用户收益情况的模块，用户可以查看相关的收益数据和统计表</p>
        <img src="${path }/imgs/intro_4.png">
        <p>用户注册之后获得的所有收益</p>
        <img src="${path }/imgs/intro_5.png">
        <p>收益中可以提现的金额数</p>
        <img src="${path }/imgs/intro_6.png">
        <p>用户当天接受的任务数量</p>
        <img src="${path }/imgs/intro_7.png">
        <p>今日所有任务产生的点击数量</p>
        <img src="${path }/imgs/intro_8.png">
        <p>用户当天的时段收益表</p>
        <img src="${path }/imgs/intro_9.png">
        <p>用户在注册之后接受的所有任务详情</p>
    </div>
</body>
</html>