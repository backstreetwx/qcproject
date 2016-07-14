<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>趣传客户管理系统</title>

	<link rel="shortcut icon" href="${path }/favicon.ico" mce_href="${path }/favicon.ico" type="image/x-icon" >
	<!-- main -->
	<link href="${path }/css/main.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${path }/plugs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="background: #ECF0F1;">
    <div class="col-sm-4 col-sm-offset-4" style="margin-top: 150px;">
    	<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">趣传客户管理系统</h3>
		  </div>
		  <div class="panel-body">
		    <form action="${path }/admin/system/login" method="post">
    			<div class="form-group">
				  <div class="input-group"> 
				  	<span class="input-group-addon" id="basic-username"><i class="glyphicon glyphicon-user"></i></span>
				    <input name="username" type="text" class="form-control" placeholder="请输入用户名..." aria-describedby="basic-username">
				  </div>
				  <p class="help-block" style="color: red;">${eusername }</p>  
				</div>
				
				<div class="form-group">
					<div class="input-group">
					  <span class="input-group-addon" id="basic-password"><i class="glyphicon glyphicon-eye-open"></i></span>
					  <input name="password" type="password" class="form-control" placeholder="请输入密码..." aria-describedby="basic-password">
					 </div>
					 <p class="help-block" style="color: red;">${epassword }</p>
				</div>
				<button type="submit" class="btn btn-info">&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;</button>
    		</form>
		  </div>
		</div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${path }/plugs/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>