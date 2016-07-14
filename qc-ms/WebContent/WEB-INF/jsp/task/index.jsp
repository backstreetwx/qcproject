<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div class="block-area" id="inline">

	 <a  href="javascript:goto_url('${path }/admin/task/index?${qo.queryString}&pageIndex=${pageBean.pageIndex }');" class="btn m-b-10">刷新</a>
	 
	 <a  href="javascript:goto_url('${path }/admin/task/gotoSave');" class="btn m-b-10">添加</a>
	 
	 <a  href="javascript:goto_url('${path }/admin/task/gotoSequence');" class="btn m-b-10">排序</a>
	
	 <hr class="whiter m-b-10">
	
    <form id="frm_task_search" role="form">
    	<div class="col-md-2">
            <select name="QType" class="select">
            	<c:choose>
            		<c:when test="${qo.QType == null}">
            			<option value="" selected="selected">请选择任务类型</option>
            		</c:when>
            		<c:otherwise>
            			<option value="">请选择任务类型</option>
            		</c:otherwise>
            	</c:choose>
            	<c:choose>
            		<c:when test="${qo.QType == 0}">
            			<option value="0" selected="selected">自定义</option>
            		</c:when>
            		<c:otherwise>
            			<option value="0">自定义</option>
            		</c:otherwise>
            	</c:choose>
            	<c:choose>
            		<c:when test="${qo.QType == 1}">
            			<option value="1" selected="selected">客户</option>
            		</c:when>
            		<c:otherwise>
            			<option value="1">客户</option>
            		</c:otherwise>
            	</c:choose>
            </select>
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control input-sm" style="width: 100%;" name="QTitle" value="${qo.QTitle }" placeholder="标题">
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control input-sm" style="width: 100%;" name="QSubTitle" value="${qo.QSubTitle }" placeholder="子标题">
        </div>
        <div class="col-md-2">
            <select name="QStatus" class="select">
            	<c:choose>
            		<c:when test="${qo.QStatus == null }">
            			<option value="" selected="selected">请选择任务状态</option>
            		</c:when>
            		<c:otherwise>
            			<option value="">请选择任务状态</option>
            		</c:otherwise>
            	</c:choose>
            	<c:choose>
            		<c:when test="${qo.QStatus == 1 }">
            			 <option value="1" selected="selected">编辑中</option>
            		</c:when>
            		<c:otherwise>
            			 <option value="1">编辑中</option>
            		</c:otherwise>
            	</c:choose>
            	<c:choose>
            		<c:when test="${qo.QStatus == 2 }">
            			 <option value="2" selected="selected">进行中</option>
            		</c:when>
            		<c:otherwise>
            			  <option value="2">进行中</option>
            		</c:otherwise>
            	</c:choose>
            	<c:choose>
            		<c:when test="${qo.QStatus == 3 }">
            			  <option value="3" selected="selected">已完成</option>
            		</c:when>
            		<c:otherwise>
            			  <option value="3">已完成</option>
            		</c:otherwise>
            	</c:choose>
            </select>
        </div>
        <a id="task_search_btn" class="btn btn-sm">搜索</a>
    </form>
</div>
<div class="block-area" id="tableHover">
    <div class="table-responsive overflow">
        <table class="table table-bordered table-hover tile">
            <thead>
                <tr>
                    <th>图标</th>
                    <th style="min-width: 100px;">类型</th>
                    <th>标题</th>
                    <th>子标题</th>
                    <th style="min-width: 70px;">阅读积分</th>
                    <th style="min-width: 70px;">阅读限制</th>
                    <th style="min-width: 70px;">分享次数</th>
                    <th style="min-width: 70px;">阅读次数</th>
                    <th style="min-width: 70px;">阅读积分</th>
                    <th style="min-width: 80px;">完成时间</th>
                    <th style="min-width: 60px;">状态</th>
                    <th style="min-width: 140px;">创建时间</th>
                    <th style="min-width: 120px;">操作</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="taskVo" items="${pageBean.recordList }" varStatus="status">
                <tr>
                    <td>
                    	<img src="${taskVo.icon }" style="width: 50px;height: auto;">
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${status.last  }">
                    			<div class="dropdown dropup">
                    		</c:when>
                    		<c:otherwise>
                    			<div class="dropdown">
                    		</c:otherwise>
                    	</c:choose>
	                    	 <a id="dropdown-toggle-type-${taskVo.id }" data-type="${taskVo.type }" href="javascript:;" class="dropdown-toggle underline" data-toggle="dropdown">
	                    	 	<c:choose>
				            		<c:when test="${taskVo.type == 0}">
				            			自定义
				            		</c:when>
				            		<c:otherwise>
				            			客户
				            		</c:otherwise>
				            	</c:choose>
	                    	 </a>
	                        <ul id="task_type" class="dropdown-menu pull-left">
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-type="0">自定义</a></li>
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-type="1">客户</a></li>
	                        </ul>
	                    </div>
                    </td>
                    <td><a id="task_title_${taskVo.id }" class="task_title" href="javascript:;" data-id="${taskVo.id }" style="text-decoration:underline;">${taskVo.title }</a> </td>
                    <td><a id="task_subTitle_${taskVo.id }" class="task_subTitle" href="javascript:;" data-id="${taskVo.id }" style="text-decoration:underline;">${taskVo.subTitle }</a> </td>
                    <td><a id="task_point_${taskVo.id }" class="task_point" href="javascript:;" data-id="${taskVo.id }" style="text-decoration:underline;">${taskVo.point }</a> </td>
                    <td><a id="task_limit_read_${taskVo.id }" class="task_limit_read" href="javascript:;" data-id="${taskVo.id }" style="text-decoration:underline;">${taskVo.limitRead }</a></td>
                    <td>${taskVo.shareCount }</td>
                    <td>${taskVo.readCount }</td>
                    <td>${taskVo.readPoint }</td>
                    <td><fmt:formatDate value="${taskVo.finishTime }" pattern="yyyy-MM-dd"/> </td>
                    <td id="task-status-td-${taskVo.id }">
                    	<c:if test="${taskVo.status == 0 or taskVo.status == 1 or taskVo.status == 2}">
                    		<c:choose>
	                    		<c:when test="${status.last  }">
	                    			<div class="dropdown dropup">
	                    		</c:when>
	                    		<c:otherwise>
	                    			<div class="dropdown">
	                    		</c:otherwise>
                    		</c:choose>
	                    	 <a id="dropdown-toggle-status-${taskVo.id }" data-status="${taskVo.status }" href="javascript:;" class="dropdown-toggle underline" data-toggle="dropdown">
	                    	 	<c:if test="${taskVo.status == 0 }">
	                    	 		下架
	                    	 	</c:if>
	                    	 	<c:if test="${taskVo.status == 1 }">
	                    	 		编辑中
	                    	 	</c:if>
	                    	 	<c:if test="${taskVo.status == 2 }">
	                    	 		进行中
	                    	 	</c:if>
	                    	 	<c:if test="${taskVo.status == 3 }">
	                    	 		已完成
	                    	 	</c:if>
	                    	 </a>
	                        <ul id="task_status" class="dropdown-menu pull-left">
	                        	<li><a href="javascript:;" data-id="${taskVo.id }" data-status="0">下架</a></li>
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-status="1">编辑中</a></li>
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-status="2">进行中</a></li>
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-status="3">已完成</a></li>
	                        </ul>
	                    	</div>
                    	</c:if>
                    	
                    	<c:if test="${taskVo.status == 3 }">
                    		<c:choose>
	                    		<c:when test="${status.last  }">
	                    			<div class="dropdown dropup">
	                    		</c:when>
	                    		<c:otherwise>
	                    			<div class="dropdown">
	                    		</c:otherwise>
                    		</c:choose>
	                    	 <a id="dropdown-toggle-status-${taskVo.id }" data-status="${taskVo.status }" href="javascript:;" class="dropdown-toggle underline" data-toggle="dropdown">
	                    	 	<c:if test="${taskVo.status == 0 }">
	                    	 		下架
	                    	 	</c:if>
	                    	 	<c:if test="${taskVo.status == 3 }">
	                    	 		已完成
	                    	 	</c:if>
	                    	 </a>
	                        <ul id="task_status" class="dropdown-menu pull-left">
	                        	<li><a href="javascript:;" data-id="${taskVo.id }" data-status="0">下架</a></li>
	                            <li><a href="javascript:;" data-id="${taskVo.id }" data-status="3">已完成</a></li>
	                        </ul>
	                    	</div>
                    	</c:if>
                    </td>
                    <td><fmt:formatDate value="${taskVo.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                    <td>
                    	<a class="task_copy" href="javascript:;" data-id="${taskVo.id }">复制</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="text-center">
	<ul class="pagination">
		<c:choose>
		    <c:when test="${pageBean.pageIndex == 1 }">
		    	<li><a href="javascript:;" data-url=""><i class="fa fa-angle-left"></i></a></li>
		    </c:when>
		    <c:otherwise>
		    	<li><a href="javascript:;" data-url="${path }/admin/task/index?${qo.queryString}&pageIndex=1"><i class="fa fa-angle-left"></i></a></li>
			</c:otherwise>
		</c:choose>
	    <c:forEach begin="${pageBean.beginPageIndex }" end="${pageBean.endPageIndex }" var="index">
				<c:choose>
			<c:when test="${index == pageBean.pageIndex }">
				<li class="active"><a href="javascript:;" data-url="">${index }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:;" data-url="${path }/admin/task/index?${qo.queryString}&pageIndex=${index}">${index }</a></li>
	    	</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
		<c:when test="${pageBean.pageIndex == pageBean.pageCount || pageBean.pageCount == 0}">
			<li><a href="javascript:;" data-url=""><i class="fa fa-angle-right"></i></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:;" data-url="${path }/admin/task/index?${qo.queryString}&pageIndex=${pageBean.pageCount }"><i class="fa fa-angle-right"></i></a></li>
	    </c:otherwise>
		</c:choose>
	</ul>	
</div>

<!-- Modal Default -->	
<div class="modal fade" id="modalDefault" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p>系统出现错误，请联系管理员</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm" data-dismiss="modal">我知道了</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal update -->	
<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
            	<form id="frm_task_edit" class="row form-columned form-validation" role="form">
            		<input id="task_type" type="hidden">
            		<input id="task_id" type="hidden">
                	<input id="task_para" type="text" class="form-control" placeholder="请输入阅读限制次数">
           		</form>
            </div>
            <div class="modal-footer" style="margin-top: 0;">
            	<button id="btn-modal-update" type="button" class="btn btn-sm">修改</button>
                <button type="button" class="btn btn-sm" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

	/* --------------------------------------------------------
	Components
	-----------------------------------------------------------*/
	(function(){
		
		if($('.select')[0]) {
		    $('.select').selectpicker();
		}
		  
		if($('.overflow')[0]) {
		    var overflowRegular, overflowInvisible = false;
		    overflowRegular = $('.overflow').niceScroll();
		}
		
		$("#task_search_btn").click(function(){
			var para = $("#frm_task_search").serialize();
			$("#content").load("${path}/admin/task/index?" + para);
		});
	
		$(".pagination a").click(function(){
			var url = $(this).attr("data-url");
			if(url == null || url == '') {
				return ;
			}
			goto_url(url);
		});
		
		$("#task_type li a").click(function(){
			var id = $(this).attr("data-id");
			var type = $(this).attr("data-type");
			var a = $("#dropdown-toggle-type-" + id);
			var ctype = a.attr("data-type");
			if(type != ctype) {
				$.get("${path}/admin/task/changeType",{"id":id, "type":type},function(result){
					if(result == 'ok') {
						a.text(type == 0 ? '自定义' : '客户');
						a.attr("data-type", type);
					} else {
						$('#modalDefault').modal('show');
					}
				});
			}
		}); 
		
		$("#task_status li a").click(function(){
			var id = $(this).attr("data-id");
			var status = $(this).attr("data-status");
			var a = $("#dropdown-toggle-status-" + id);
			var cstatus = a.attr("data-status");
			if(status != cstatus) {
				$.get("${path}/admin/task/changeStatus",{"id":id, "status":status}, function(result){
					if(result == 'ok') {
						if(status == 0) {
							a.text("下架");
						} else if(status == 1) {
							a.text("编辑中");
						} else if(status == 2) {
							a.text("进行中");
						} else if(status == 3){
							a.text("已完成");
						}
						
						a.attr("data-status", status);
					} else {
						$('#modalDefault').modal('show');
					}
				});
			}
		});
		
		$(".task_limit_read").click(function(){
			$("#task_type").val(2);
			$("#task_id").val($(this).attr("data-id"));
			$("#task_para").val($(this).text());
			$('#modalUpdate').modal('show');
		});
		
		$(".task_point").click(function(){
			$("#task_type").val(1);
			$("#task_id").val($(this).attr("data-id"));
			$("#task_para").val($(this).text());
			$('#modalUpdate').modal('show');
		});
		
		$(".task_subTitle").click(function(){
			$("#task_type").val(3);
			$("#task_id").val($(this).attr("data-id"));
			$("#task_para").val($(this).text());
			$('#modalUpdate').modal('show');
		});
		
		$(".task_title").click(function(){
			$("#task_type").val(4);
			$("#task_id").val($(this).attr("data-id"));
			$("#task_para").val($(this).text());
			$('#modalUpdate').modal('show');
		});
		
		$("#btn-modal-update").click(function(){
			var type = $("#task_type").val();
			var id = $("#task_id").val();
			var para = $("#task_para").val();
			
			if(type == 1) {
				if(para == null || para == 0 || para == undefined) {
					return ;
				}
				
				$.get("${path}/admin/task/changePoint", {"id":id, "point":para}, function(result){
					if(result == 'ok') {
						$("#task_point_" + id).text(para);
					}
					$('#modalUpdate').modal('hide');
				});
			} else if(type == 2) {
				if(para == null || para == 0 || para == undefined) {
					return ;
				}
				
				$.get("${path}/admin/task/changeLimitRead", {"id":id, "limitRead":para}, function(result){
					if(result == 'ok') {
						$("#task_limit_read_" + id).text(para);
					}
					$('#modalUpdate').modal('hide');
				});
			} else if(type == 3) {
				if(para == null || para == '' || para == undefined) {
					return ;
				}
				
				$.get("${path}/admin/task/changeSubTitle", {"id":id, "subTitle":para}, function(result){
					if(result == 'ok') {
						$("#task_subTitle_" + id).text(para);
					}
					$('#modalUpdate').modal('hide');
				});
			} else if(type == 4) {
				if(para == null || para == '' || para == undefined) {
					return ;
				}
				
				$.get("${path}/admin/task/changeTitle", {"id":id, "title":para}, function(result){
					if(result == 'ok') {
						$("#task_title_" + id).text(para);
					}
					$('#modalUpdate').modal('hide');
				});
			}
		});
		
		
		$(".task_copy").click(function(){
			var id = $(this).attr("data-id");
			$("#content").load("${path}/admin/task/gotoCopy?taskId=" + id);
		});
	})();

	/* --------------------------------------------------------
	Custom Scrollbar
	-----------------------------------------------------------*/
	function goto_url(url) {
		$("#content").load(url);
	}
</script>