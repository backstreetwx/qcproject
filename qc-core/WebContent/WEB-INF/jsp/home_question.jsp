<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport"/>
<title>赚钱教程</title>

<script type="text/javascript" src="${path }/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$("#firstpane .menu_body:eq(0)").show();
				$("#firstpane h3.menu_head").click(
						function() {
							$(this).addClass("current").next("div.menu_body")
									.slideToggle(300).siblings("div.menu_body")
									.slideUp("slow");
							$(this).siblings().removeClass("current");
						});

				$("#secondpane .menu_body:eq(0)").show();
				$("#secondpane h3.menu_head").mouseover(
						function() {
							$(this).addClass("current").next("div.menu_body")
									.slideDown(500).siblings("div.menu_body")
									.slideUp("slow");
							$(this).siblings().removeClass("current");
						});

			});
</script>

<style type="text/css">
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

.biaoti {
	width: 100%;
	height: 50px;
	background-color: #f1f1f1;
	text-align: center;
	line-height: 50px;
}

.menu_list {
	width: 95%;
	margin: 0 auto;
	padding-top: 10px;
}

.menu_head {
	height: 50px;
	line-height: 50px;
	padding-left: 38px;
	font-size: 14px;
	color: #525252;
	cursor: pointer;
	border: 1px solid #e1e1e1;
	position: relative;
	margin: 0px;
	font-weight: bold;
	background: #f1f1f1 url(${path }/img/pro_left.png) center right no-repeat;
}

.menu_list .current {
	background: #f1f1f1 url(${path }/img/pro_down.png) center right no-repeat;
}

.menu_body {
	line-height: 38px;
	border-left: 1px solid #e1e1e1;
	backguound: #fff;
	border-right: 1px solid #e1e1e1;
}

.menu_body a {
	display: block;
	line-height: 26px;
	padding: 15px;
	color: #777777;
	background: #fff;
	text-decoration: none;
	border-bottom: 1px solid #e1e1e1;
}

.menu_body a p {
	margin-top: 15px;
}

.menu_body a:hover {
	text-decoration: none;
}
</style>

</head>
<body>
	<div class="biaoti">赚钱教程</div>
	<div id="firstpane" class="menu_list">
		<h3 class="menu_head"
			onclick="window.location.href= '${path }/public/home/desc';return false">赚钱教程（1分钟学会）</h3>
		<div style="display: block" class="menu_body"></div>

		<h3 class="menu_head">趣传是怎样帮你赚钱的</h3>
		<div style="display: none" class="menu_body">
			<a href="#">
				<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;或许您不知道：您的微信朋友圈是可以换得收益的，只是无人帮您开发，所以您无法从中获得收益。</P>

				<P>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;趣传的出现，恰好解决了这个问题！趣传的网页里植入了广告，通过展示网页可以获得广告收益。您只需要将我们的网文分享到您的朋友圈里，就可以和我们分成广告收益了。</P>

				<P>也就是说：我们想付费在您的朋友圈里展示网文，让您的朋友圈获到收益，您同意吗？</P>

				<P style="color: #E75735;">
					这一切只须两步：<br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、注册成为我们的会员；<br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、在首页点“任务大厅”，把获取的文章分享到朋友圈或者微信好友即可。
				</P>

				<P>然后，你就等着收益蹭蹭往上涨，躺着也赚钱的哦。</P>

			</a>
		</div>

		<h3 class="menu_head">结算方式（价格）</h3>
		<div style="display: none" class="menu_body">
			<a href="#">
				<p>
					<span style="color: #E75735;">1、</span>奖金以按文章的阅读量来计算的，每一次有效阅读都将获得0.06元-1元不等，有效阅读是指浏览者正常的访问并有详细地查看趣传的文章页，闪退、重复阅读或者阅读次数过多（有作弊嫌疑）不算有效阅读。
				</p>
				<p>
					<span style="color: #E75735;">2、新用户首次分享成功 系统会奖励6元作为奖励</span>
				</p>

				<p>
					<span style="color: #E75735;">3、</span>当账户余额大于100元,可以申请提现,1个工作日支付到你的支付宝账号！
				</p>
				<P>很多转客说：我只有100个好友，反正赚不到多少钱，我就不参与了。
					其实不是这样的！推广在于日积月累，在于您是否用心。即使只有100个好友，每天业绩超过500元也不是没有可能。每天收益比你存几十万到余额宝获得的收益多得多~</p>
			</a>
		</div>

		<h3 class="menu_head">怎样通过趣传月赚1万</h3>
		<div style="display: none" class="menu_body">
			<a href="#">
				<p>
					<span style="color: #E75735;">1、</span>用心选择分享的内容。每个人都有不同的圈子，每个人的圈子都有不同的爱好内容，所以您一定要认真从趣传上查到适合您的圈子的内容去分享。只有您分享的内容是您的朋友喜欢的，他们才有可能转发。转发？对，转是个特值得高兴的事，因为倍增的速度太快了，从100到1万，也许就是几分钟的事，所以，您分享一个链接前，一定要想一下这个链接能不能让朋友们转发!
				</p>

				<p>
					<span style="color: #E75735;">2、</span>通过摇一摇和附近的人每天多加些好友，并且保持每天分享5-12篇文章，这样收益一天比一天增多。
				</p>

				<p>
					<span style="color: #E75735;">3、</span>转发文章越多获取的收益也就越多，在分享到朋友圈的时候配上诱惑性比较强的文字，吸引好友点击阅读，比如：“笑翻天”，“超级经典的鸡汤”，“美女福利”……开动你的大脑！。
				</p>

				<p>按照这样的方法尝试一下吧，您将会发现：刚开始您每天的业绩只有您好友的三分之一，一周后业绩增长到和好友数目一样多，再过一周即可达到好友数量的两倍，再过一段时间，您会突然发现您的业绩已经成了好友数量的N倍。原因是什么呢？就是因为您坚持每天在做，总有一些链接被人一次又一次的转载，而不管转载多少次，我们的系统都会计入您自己的业绩。这是个几何倍增的效果，每天做到500元绝对不是梦，这需要您用心去做！</p>

			</a>
		</div>

	</div>
</body>
</html>
