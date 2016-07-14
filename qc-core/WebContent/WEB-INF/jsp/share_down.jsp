<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
		<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
		<meta content="no-cache" http-equiv="pragma">
		<meta content="0" http-equiv="expires">
		<meta content="telephone=no, address=no" name="format-detection">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
		<link rel="stylesheet" href="${path }/css/style.css" />
		<link rel="stylesheet" href="${path }/css/animations.css" />
		<title>趣传</title>
		<style type="text/css">
		.masker {
	position:fixed;
	z-index: 1003;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
    background-color: rgba(0,0,0, 0.8);
}

.masker img {
    width: 100%;
    height: auto;
}

	.hide {
		display: none;
	}
		</style>
	</head>
	<body>
		<div id="wrap">
			<img class="img1 pt-page-moveFromTop" src="${path }/imgs/qcimg1.png" />
			<img class="img2 pt-page-moveFromLeft" src="${path }/imgs/qcimg2.png" />
			<img class="img3 pt-page-moveFromRight" src="${path }/imgs/qcimg3.png" />
			<img class="qian pt-page-moveCircle" src="${path }/imgs/qian.png" />
			<img class="hbg1" src="${path }/imgs/hbg1.png" />
			<img class="hbg2" src="${path }/imgs/hbg2.png" />
			<div class="nrbg">
				<input onclick="down()" class="botxz" type="button" value="立即下载" />
				<img class="moi pt-page-rotateCubeTopIn" src="${path }/imgs/moi.png" />
			</div>
		</div>
		
		
		<div class="masker hide">
            <img src="http://7xlc6h.com2.z0.glb.qiniucdn.com/android_guide.png">
    	</div>
    
	</body>
	<script type="text/javascript" src="${path }/js/jquery.js"></script>
	<script type="text/javascript">
	 	$(function(){
	 		var a = navigator.userAgent;
	     	var b = !!a.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
		    if (b) {
		        $(".masker img").attr("src", "http://7xlc6h.com2.z0.glb.qiniucdn.com/iphone_guide.png");
		    }
		     
		    if (isWeiXin()) {
		        $(".masker").removeClass("hide");
		    }
		     
	 	});
	     
		function down() {
			var a = navigator.userAgent;
	     	var b = !!a.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
	        if(b) { // IOS
	        	location.href = "https://appsto.re/cn/Spusab.i";
	        } else { // Android
	        	location.href = "http://121.196.225.181:9090/WeixinApk/apkPack?key=0&name=quchuan";
	        }
		}
		
	 	function isWeiXin() {
	        var a = window.navigator.userAgent.toLowerCase();
	        if (a.match(/MicroMessenger/i) == "micromessenger") {
	            return true;
	        } else {
	            return false;
	        }
	    };
	</script>
</html>
    