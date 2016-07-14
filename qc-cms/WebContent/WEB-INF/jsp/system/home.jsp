<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		  <a href="javascript:;" class="list-group-item active">任务列表</a>
		  <a href="${path }/admin/task/gotoSave" class="list-group-item">添加任务</a>
		</div>
	</div>
	<div class="col-sm-10">
		<div class="panel panel-default">
		  <div class="panel-heading">
		  
		  <button id="startTimer" class="btn btn-default" type="button">开启定时</button>
		  </div>
		  <div id="task_data" class="panel-body">
			   <table class="table table-hover table-bordered">
			   <thead>
			      <tr>
			         <th>图标</th>
			         <th>标题</th>
			         <th>子标题</th>
			         <th style="min-width: 50px;">单价</th>
			         <th style="min-width: 50px;">限量</th>
			         <th style="min-width: 80px;">分享次数</th>
			         <th style="min-width: 80px;">阅读次数</th>
			         <th style="min-width: 80px;">阅读积分</th>
			         <th style="min-width: 60px;">状态</th> 
			         <th style="min-width: 160px;">创建时间</th> 
			      </tr>
			   </thead>
			   <tbody>
			   	<c:forEach var="taskVo" items="${pageBean.recordList }" varStatus="status">
			      <tr>
			         <td><img alt="icon" src="${taskVo.icon }" style="width: 30px;height: auto;"></td>
			         <td>${taskVo.title }</td>
			         <td>${taskVo.subTitle }</td>
			         <td>${taskVo.point }</td>
			         <td>${taskVo.limitRead }</td>
			         <td>${taskVo.shareCount }</td>
			         <td>${taskVo.readCount }</td>
			         <td>${taskVo.readPoint }</td>
			         <td>
			         	<c:if test="${taskVo.status == 1}">
			         		审核中
			         	</c:if>
			         	<c:if test="${taskVo.status == 2}">
			         		进行中
			         	</c:if>
			         	<c:if test="${taskVo.status == 3}">
			         		已完成
			         	</c:if>
			         </td>
			         <td><fmt:formatDate value="${taskVo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			      </tr>
			     </c:forEach>
			   </tbody>
			</table>
			
			<ul class="pagination" style="margin: 0;">
		    <c:choose>
			    <c:when test="${pageBean.pageIndex == 1 }">
				    <li>
				      <a href="javascript:;" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				</c:when>
			    <c:otherwise>
			    	<li>
				      <a href="${path }/admin/system/gotoHome?${qo.queryString}&pageIndex=1" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:otherwise>
			</c:choose> 
			    
			<c:forEach begin="${pageBean.beginPageIndex }" end="${pageBean.endPageIndex }" var="index">
				<c:choose>
					<c:when test="${index == pageBean.pageIndex }">
						<li class="active"><a href="javascript:;" data-url="">${index }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${path }/admin/system/gotoHome?${qo.queryString}&pageIndex=${index}">${index }</a></li>
			    	</c:otherwise>
				</c:choose>
			</c:forEach>
			 
			<c:choose>
			<c:when test="${pageBean.pageIndex == pageBean.pageCount || pageBean.pageCount == 0}">
				 <li>
			      <a href="javascript:;" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			</c:when>
			<c:otherwise>
				<li>
			      <a href="${path }/admin/system/gotoHome?${qo.queryString}&pageIndex=${pageBean.pageCount }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:otherwise>
			</c:choose> 
			</ul> 
		  </div>
		</div>
	</div>
	
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${path }/plugs/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    	$(function(){
    		var isTimer = false;
    		var t;
    		$("#startTimer").click(function(){
    			if(isTimer) {
    				clearInterval(t);
    				$(this).text("开启定时");
    			} else { 
    				t = setInterval(function(){
    					$("#task_data").load("${path}/admin/system/gotoData?${qo.queryString}&pageIndex=${pageBean.pageCount }");
    				}, 10000);
    				$(this).text("关闭定时");
    			}
    			isTimer = !isTimer;
    		});
    	});
    </script>
</body>
</html>