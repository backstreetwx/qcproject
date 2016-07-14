<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
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
    <style>
        body,p {
            margin: 0;
            padding: 0;
        }
        p {
            color: #656668;
            line-height: 26px;
            font-size:16px;
        }
        .wrap {
            padding: 10px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<img src="${path }/imgs/pic5.jpg" style="width: 100%;height: auto;vertical-align: top">
<div class="wrap">
    <p>1、用户您所有在软件内获得的收益都将计入到总收益中</p>
    <p>2、每个分栏对应您在该任务中获得的收益情况，系统奖励请查看收益明细</p>
    <p>3、今日收益代表您截止到当前时间本日内获得的收益数</p>
    <p>4、可用余额是用户您在软件中已经获取的真实收益（任务已结算），是用户您可以用来在商城使用的余额数，会随着您的兑换商城购买而减少</p>
    <p>5、可用余额是根据广告结算进行结算的，广告一般是晚上24：00结算，具体收益请以今日收益和总收益为准</p>
</div>
</body>
</html>