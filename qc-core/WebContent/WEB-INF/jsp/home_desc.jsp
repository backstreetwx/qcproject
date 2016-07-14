<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新手引导</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport">
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
<meta content="no-cache" http-equiv="pragma">
<meta content="0" http-equiv="expires">
<meta content="telephone=no, address=no" name="format-detection">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent">
<style>
* {
	margin: 0px;
	padding: 0px;
	border: 0px;
	outline: none;
	outline: 0;
	list-style-type: none;
	list-style: none;
}

html {
	width: 100%;
	font-family: "华文细黑";
	-webkit-tap-highlight-color: transparent;
	-webkit-touch-callout: none;
}

a img, img {
	border: 0px;
}

a {
	text-decoration: none;
}

#wrap {
	display: block;
	min-width: 320px;
	margin: 0 auto;
	max-width: 640px;
	width: 100%;
	overflow: hidden;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	text-align: center;
	padding: 15px;
}

#wrap img {
	width: 80%;
	border: 1px solid #DAD7D1;
}

#wrap p {
	text-align: left;
	margin: 15px 0px 15px 0px;
	font-size: 20px;
	color: #222222;
}

#wrap span {
	font-size: 22px;
	color: #e75735;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="wrap">
		<h1>分享文章赚钱</h1>
		<p>
			<span>丨</span>第一步，浏览任务列表或者热门任务
		</p>
		<img src="${path }/img/s1.png" />
		<p>
			<span>丨</span>第二步，浏览你感兴趣的文章，点进<span>“进行中”</span>任务查看任务预览，点击立即分享
		</p>
		<img src="${path }/img/s2.png" />
		<p>
			<span>丨</span>第三步，点击立即分享
		</p>
		<img src="${path }/img/s3.png" />
		<p>
			<span>丨</span>第四步,选择微信好友或者分享到朋友圈
		</p>
		<img src="${path }/img/s4.png" />
		<p>
			<span>丨</span>第五步，分享完后（特别是分享给好友后）一定要点击<span>“返回趣传”</span>，在趣传中看到，<span>”分享成功，等待收钱咯”</span>，就开始计算收入了，每个好友点击，都会给您丰厚的奖励哦
		</p>
		<img src="${path }/img/s5.png" /> <img src="${path }/img/s6.png" />
	</div>
</body>
</html>
