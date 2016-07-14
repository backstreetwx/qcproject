<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="趣传">
        <meta name="keywords" content="趣传">

        <title>趣传文章管理</title>
            
        <!-- CSS -->
        <link href="${path }/plugs/super/css/bootstrap.min.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/form.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/style.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/animate.css" rel="stylesheet">
        <link href="${path }/plugs/super/css/generics.css" rel="stylesheet"> 
    </head>
    <body id="skin-blur-violate">
        <section id="login">
            <header>
                <h1>趣传文章管理</h1>
            </header>
        
            <div class="clearfix"></div>
            
            <!-- Login -->
            <form class="box tile animated active" action="${path }/admin/system/login" method="POST">
                <h2 class="m-t-0 m-b-15">登录</h2>
                
                <p class="m-b-15" style="color: red;">${error }</p>
                <input name="username" type="text" class="login-control m-b-10" placeholder="请输入用户名">
                <input name="password" type="password" class="login-control m-b-10" placeholder="请输入密码">
                <button class="btn">登录</button>
            </form>
        </section>                      
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="${path }/plugs/super/js/jquery.min.js"></script> <!-- jQuery Library -->
        
        <!-- Bootstrap -->
        <script src="${path }/plugs/super/js/bootstrap.min.js"></script>
        
        <!--  Form Related -->
        <script src="${path }/plugs/super/js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        
        <!-- All JS functions -->
        <script src="${path }/plugs/super/js/functions.js"></script>
    </body>
</html>
