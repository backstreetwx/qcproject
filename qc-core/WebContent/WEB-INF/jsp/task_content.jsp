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
    <title>${readTaskContent.title }</title>
    <!--加载css文件-->
    <link type="text/css" rel="stylesheet" href="${path }/css/main.css?v=1">
    <style type="text/css">
    	.article_header div:AFTER {
    		content:'';
    		display: table;
    		clear: both;
    	}
    </style>
</head>
<body>
    <div class="article">
        <section class="article_header">
            <h2>${readTaskContent.title }</h2>
            <div>
                <span class="desc_left"><img src="${path }/imgs/sj.png"><fmt:formatDate value="${readTaskContent.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            	<span class="desc_right"><img src="${path }/imgs/yl.png"><span style="font-size: 11px">阅读量</span>：${readTaskContent.readCount }</span>
            </div>
        </section>
        <section class="article_body">
            <!--内容开始-->
            ${readTaskContent.content }
            <!--内容结束-->
        </section>
    </div>
</body>
<jsp:include page="task_script.jsp"></jsp:include>
</html>