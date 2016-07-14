<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div class="block-area" id="tableHover">
    <div class="table-responsive overflow">
        <table class="table table-bordered table-hover tile">
            <thead>
                <tr>
                    <th>图标</th>
                    <th>标题</th>
                    <th>子标题</th>
                    <th style="min-width: 120px;">操作</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="taskVo" items="${pageBean.recordList }" varStatus="status">
                <tr id="task_tr_${taskVo.id }" data-id="${taskVo.id }" data-sequence="${taskVo.sequence }">
                    <td>
                    	<img src="${taskVo.icon }" style="width: 50px;height: auto;">
                    </td>
                    <td>${taskVo.title }</td>
                    <td>${taskVo.subTitle }</td>
                    <td>
                    	<c:if test="${!status.first  }">
                    			<a class="task_up" href="javascript:;" data-id="${taskVo.id }">上移</a>
                    	</c:if>
                    	
                    	<c:if test="${!status.last  }">
                    			<a class="task_down" href="javascript:;" data-id="${taskVo.id }">下移</a>
                    	</c:if>
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
		    	<li><a href="javascript:;" data-url="${path }/admin/task/gotoSequence?pageIndex=1"><i class="fa fa-angle-left"></i></a></li>
			</c:otherwise>
		</c:choose>
	    <c:forEach begin="${pageBean.beginPageIndex }" end="${pageBean.endPageIndex }" var="index">
				<c:choose>
			<c:when test="${index == pageBean.pageIndex }">
				<li class="active"><a href="javascript:;" data-url="">${index }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:;" data-url="${path }/admin/task/gotoSequence?pageIndex=${index}">${index }</a></li>
	    	</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
		<c:when test="${pageBean.pageIndex == pageBean.pageCount || pageBean.pageCount == 0}">
			<li><a href="javascript:;" data-url=""><i class="fa fa-angle-right"></i></a></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:;" data-url="${path }/admin/task/gotoSequence?pageIndex=${pageBean.pageCount }"><i class="fa fa-angle-right"></i></a></li>
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
		
		$(".task_up").click(function(){
			var cur = $(this).parents("tr");
			var curId = cur.attr("data-id");
			var curSequence = cur.attr("data-sequence");
			
			var pre = cur.prev();
			var preId = pre.attr("data-id");
			var preSequence = pre.attr("data-sequence");
			
			$.get("${path}/admin/task/changeSequence",{"firstId":curId, "firstSequence":preSequence,"secondId":preId,"secondSequence":curSequence}, function(result){
				if(result == "ok") {
					goto_url("${path }/admin/task/gotoSequence?pageIndex=${pageBean.pageIndex }");
				}
			});
		});
		
		$(".task_down").click(function(){
			var cur = $(this).parents("tr");
			var curId = cur.attr("data-id");
			var curSequence = cur.attr("data-sequence");
			
			var next = cur.next();
			var nextId = next.attr("data-id");
			var nextSequence = next.attr("data-sequence");
			
			$.get("${path}/admin/task/changeSequence",{"firstId":curId, "firstSequence":nextSequence,"secondId":nextId,"secondSequence":curSequence}, function(result){
				if(result == "ok") {
					goto_url("${path }/admin/task/gotoSequence?pageIndex=${pageBean.pageIndex }");
				}
			});
		});
	})();

	/* --------------------------------------------------------
	Custom Scrollbar
	-----------------------------------------------------------*/
	function goto_url(url) {
		$("#content").load(url);
	}
</script>