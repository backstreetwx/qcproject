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
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="javascript:;">趣传客户管理系统</a>
	    </div>
	     <div class="collapse navbar-collapse">
	    	 <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                ${sysUser.username }<b class="caret"></b>
		            </a>
		            <ul class="dropdown-menu">
		               <li><a href="${path }/admin/system/logout">注销</a></li>
		            </ul>
		         </li>
		      </ul>
	      </div>
	  </div>
	</nav>
	
	<div class="col-sm-2">
		<div class="list-group">
		  <a href="${path }/admin/system/gotoHome" class="list-group-item">任务列表</a>
		  <a href="javascript:;" class="list-group-item active">添加任务</a>
		</div>
	</div>
	<div class="col-sm-10">
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">添加任务</h3> 
		  </div>
		  <div class="panel-body">
			<form class="form-horizontal" action="${path }/admin/task/save" method="post">
				  <div class="form-group col-sm-6">
					    <label for="aria-title" class="col-sm-2 control-label">标题</label>
					    <div class="col-sm-10">
					      <input name="title" value="${task.title }" type="text" class="form-control" placeholder="请输入标题..." aria-describedby="aria-title">
					      <p id="aria-title" class="help-block" style="margin-bottom: 0;color: red;">${etitle }&nbsp;</p>
					    </div>
				  </div>
				  <div class="form-group col-sm-6">
					    <label for="aria-subTitle" class="col-sm-2 control-label">子标题</label>
					    <div class="col-sm-10">
					      <input name="subTitle" value="${task.subTitle }" type="text" class="form-control" placeholder="请输入子标题..." aria-describedby="aria-subTitle">
					      <p id="aria-subTitle" class="help-block" style="margin-bottom: 0;color: red;">${esubTitle }&nbsp;</p>
					    </div>
				  </div>
				  <div class="form-group col-sm-6">
					    <label for="aria-icon" class="col-sm-2 control-label">图标</label>
					    <div class="col-sm-10">
					      <input id="task_icon" name="icon" value="${task.icon }" type="text" class="form-control" placeholder="请选择图标..." aria-describedby="aria-icon">
					      <p id="aria-icon" class="help-block" style="margin-bottom: 0;color: red;">${eicon }&nbsp;</p>
					    </div>
				  </div>
				  
				  <input name="point"  type="hidden" value="6">
<!-- 				  <div class="form-group col-sm-6"> -->
<!-- 					    <label for="aria-point" class="col-sm-2 control-label">单价</label> -->
<!-- 					    <div class="col-sm-10"> -->
<%-- 					      <input name="point" value="${task.point }" type="text" class="form-control" placeholder="单价单位：分" aria-describedby="aria-point"> --%>
<%-- 					      <p id="aria-point" class="help-block" style="margin-bottom: 0;color: red;">${epoint }&nbsp;</p> --%>
<!-- 					    </div> -->
<!-- 				  </div> -->
 			<input name="limitRead"  type="hidden" value="3600">
<!-- 				  <div class="form-group col-sm-6"> -->
<!-- 					    <label for="aria-limitRead" class="col-sm-2 control-label">限量</label> -->
<!-- 					    <div class="col-sm-10"> -->
<%-- 					      <input name="limitRead" value="${task.limitRead }" type="text" class="form-control" placeholder="请输入限量..." aria-describedby="aria-limitRead"> --%>
<%-- 					      <p id="aria-limitRead" class="help-block" style="margin-bottom: 0;color: red;">${elimitRead }&nbsp;</p> --%>
<!-- 					    </div> -->
<!-- 				  </div> -->
				   <input name="ctype"  type="hidden" value="1">
<!-- 				  <div class="form-group col-sm-6"> -->
<!-- 					    <label for="aria-ctype" class="col-sm-2 control-label">类型</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					      	<select name="ctype" class="form-control" aria-describedby="aria-ctype"> -->
<%-- 					      	 <c:if test="${ctype == 1 or ctype == null}"> --%>
<!-- 					      	 	 <option value="1" selected="selected">普通地址</option> -->
<!--                 			  	 <option value="0">微信地址</option> -->
<%-- 					      	 </c:if> --%>
<%-- 							 <c:if test="${ctype == 0 }"> --%>
<!-- 					      	 	 <option value="1">普通地址</option> -->
<!--                 			  	 <option value="0" selected="selected">微信地址</option> -->
<%-- 					      	 </c:if> --%>
<!-- 							</select> -->
<%-- 							<p id="aria-limitRead" class="help-block" style="margin-bottom: 0;color: red;">${ectype }&nbsp;</p> --%>
<!-- 					    </div> -->
<!-- 				  </div> -->
				  
				  <div class="form-group col-sm-6">
					    <label for="aria-curl" class="col-sm-2 control-label">地址</label>
					    <div class="col-sm-10"> 
					      <input name="curl" value="${curl }" type="text" class="form-control" placeholder="请输入地址..." aria-describedby="aria-curl">
					      <p id="aria-curl" class="help-block" style="margin-bottom: 0;color: red;">${ecurl }&nbsp;</p>
					    </div>
				  </div>
				  
				  <div class="form-group col-sm-12">
					    <button type="submit" class="btn btn-default col-sm-offset-3">&nbsp;&nbsp;&nbsp;&nbsp;保存&nbsp;&nbsp;&nbsp;&nbsp;</button>
				  </div>
			</form>
		  </div>
		</div>
	</div>
	
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${path }/plugs/bootstrap/js/bootstrap.min.js"></script>
    <!-- Qiniu -->
    <script src="${path }/plugs/qiniu/plupload.full.min.js"></script> 
    <script src="${path }/plugs/qiniu/qiniu.js"></script> 
    
    <script src="${path }/js/format_date.js"></script> <!-- News Feeds -->
    
    <script type="text/javascript">
    	$(function(){
    		var uploader = Qiniu.uploader({
    		    runtimes: 'html5,flash,html4',    //上传模式,依次退化
    		    browse_button: 'task_icon',       //上传选择的点选按钮，**必需**
    		    uptoken_url: '${path}/admin/system/token',
    		    domain: '7xo77v.com2.z0.glb.qiniucdn.com',
    		    flash_swf_url: '${path}/plugs/qiniu/Moxie.swf',  //引入flash,相对路径
    		    dragdrop: false,                   //开启可拖曳上传
    		    auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
    		    init: {
    		        'FilesAdded': function(up, files) {
    		            plupload.each(files, function(file) {
    		                // 文件添加进队列后,处理相关的事情
    		            });
    		        },
    		        'BeforeUpload': function(up, file) {
    		               // 每个文件上传前,处理相关的事情
    		        },
    		        'UploadProgress': function(up, file) {
    		               // 每个文件上传时,处理相关的事情
    		        },
    		        'FileUploaded': function(up, file, info) {
    		        	 info = $.parseJSON(info);
    		        	 $("#task_icon").val("http://7xo77v.com2.z0.glb.qiniucdn.com/" + info.key);
    		        },
    		        'Error': function(up, err, errTip) {
    		               //上传出错时,处理相关的事情
    		               console.info(err);
    		        },
    		        'UploadComplete': function() {
    		               //队列文件处理完毕后,处理相关的事情
    		        },
    		        'Key': function(up, file) {
    		        	var suffix =/\.[^\.]+/.exec(file.name);
    		            var key = "qc_ms_" + new Date().pattern("yyyyMMddHHmmss") + suffix;
    		            return key
    		        }
    		    }
    		});
    	});
    </script>
</body>
</html>