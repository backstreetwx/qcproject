<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div class="block-area" id="multi-column">
    <form id="frm_task" class="row form-columned form-validation" role="form">
    	<input type="hidden" name="sequence" value="${sequence + 1 }">
     	<input name="id" type="hidden" value="${taskVo.id }">
     	
        <div class="col-md-6">
            <input name="title" value="${taskVo.title }" type="text" class="form-control input-sm m-b-10" data-validation-engine="validate[required,maxSize[50]]" placeholder="标题">
        </div>
        <div class="col-md-6">
            <input name="subTitle" value="${taskVo.subTitle }" type="text" class="form-control input-sm m-b-10" data-validation-engine="validate[required,maxSize[50]]" placeholder="子标题">
        </div>
        
         <div class="col-md-6">
         	 <input id="task_icon" name="icon" value="${taskVo.icon }" type="text" class="form-control input-sm m-b-10" data-validation-engine="validate[required]" placeholder="图标">
         </div>
        
        <div class="col-md-6">
            <select name="type" class="select m-b-10">
            	<c:choose>
            		<c:when test="${taskVo.type == 0 }">
            			<option value="1">客户</option>
                		<option value="0" selected="selected">自定义</option>
            		</c:when>
            		<c:otherwise>
            			<option value="1" selected="selected">客户</option>
                		<option value="0">自定义</option>
            		</c:otherwise>
            	</c:choose>
                
            </select>
        </div>
        
        <div class="col-md-6">
            <input name="point" value="${taskVo.point }" type="text"  class="form-control input-sm m-b-10" data-validation-engine="validate[required,min[1]]" placeholder="阅读积分（100积分=1元）" value="10">
        </div>
        <div class="col-md-6">
            <input name="limitRead" value="${taskVo.limitRead }" type="text" class="form-control input-sm m-b-10" data-validation-engine="validate[required,min[1]]" placeholder="阅读限制" value="5000">
        </div>
        
        <div class="col-md-6">
        	<input name="startTime" value='<fmt:formatDate value="${taskVo.startTime }" pattern="yyyy-MM-dd HH"/>' type="text" class="input-sm form-control mask-date-time" placeholder="开始时间（格式：yyyy-MM-dd HH）">
        </div>
        
        
        <div class="col-md-6">
           <div class="input-icon datetime-pick date-only">
               <input name="finishTime" value='<fmt:formatDate value="${taskVo.finishTime }" pattern="yyyy-MM-dd"/>' data-format="yyyy-MM-dd" type="text" class="form-control input-sm m-b-10" data-validation-engine="validate[required]" placeholder="完成时间" value="2016-12-30"/>
               <span class="add-on">
                   <i class="sa-plus"></i>
               </span>
           </div>
        </div>
        
         <input name="status" type="hidden" value="1">
        <!-- 任务的状态 1、未知 2、进行中 3、已完成 -->
<!--         <div class="col-md-6"> -->
<!--             <select name="status" class="select m-b-10"> -->
<!--                 <option value="1">编辑中</option> -->
<!--             </select> -->
<!--         </div> -->
        
        <div class="col-md-10">
            <button type="submit" class="btn btn-sm" >确定</button>
        </div>
    </form>
</div>

<!-- ----------------------------------------------------------------  -->
 <!-- Modal Default -->	
<div class="modal fade" id="modalDefault" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p id="model-body-content">系统出现错误，请联系管理员</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm" data-dismiss="modal">我知道了</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
/* --------------------------------------------------------
Components
-----------------------------------------------------------*/
(function(){
    /* Textarea */
	if($('.auto-size')[0]) {
	    $('.auto-size').autosize();
	}
	
	    //Select
	if($('.select')[0]) {
	    $('.select').selectpicker();
	}
	    
	    //Sortable
	    if($('.sortable')[0]) {
	    $('.sortable').sortable();
	}
	
	    //Tag Select
	if($('.tag-select')[0]) {
	    $('.tag-select').chosen();
	}
	    
	    /* Tab */
	if($('.tab')[0]) {
	    $('.tab a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	    });
	}
	    
	    /* Collapse */
	if($('.collapse')[0]) {
	    $('.collapse').collapse();
	}
    
    /* Accordion */
    $('.panel-collapse').on('shown.bs.collapse', function () {
        $(this).prev().find('.panel-title a').removeClass('active');
    });

    $('.panel-collapse').on('hidden.bs.collapse', function () {
        $(this).prev().find('.panel-title a').addClass('active');
    });

    //Popover
	if($('.pover')[0]) {
	    $('.pover').popover();
	} 
    
    //WYSIWYE Editor
	if($('.wysiwye-editor')[0]) {
	    $('.wysiwye-editor').summernote({
		height: 200
	    });
	    $("#ccontent").hide();
	}
    
	if($('.mask-date-time')[0]) {
		$('.mask-date-time').mask('0000-00-00 00');
	}
})();

/* --------------------------------------------------------
Date Time Picker
-----------------------------------------------------------*/
(function(){
   //Date Only
	if($('.date-only')[0]) {
	   $('.date-only').datetimepicker({
		pickTime: false
	   });
	}
	
	   //Time only
	if($('.time-only')[0]) {
	   $('.time-only').datetimepicker({
		pickDate: false
	   });
	}
	
	   //12 Hour Time
	if($('.time-only-12')[0]) {
	   $('.time-only-12').datetimepicker({
		pickDate: false,
		pick12HourFormat: true
	   });
	}
   
   $('.datetime-pick input:text').on('click', function(){
       $(this).closest('.datetime-pick').find('.add-on i').click();
   });
})();

/* --------------------------------------------------------
Form Validation
-----------------------------------------------------------*/
(function(){
if($("[class*='form-validation']")[0]) {
    $("[class*='form-validation']").validationEngine({
    	onValidationComplete:function(form, valid){
    		if(valid) {
    			var para = $("#frm_task").serialize();
    			$.post("${path}/admin/task/copy",para, function(result){
    				if(result == 'ok') {
    					$("#content").load("${path}/admin/task/index");
    				} else {
        				$('#modalDefault').modal('show');
    				}
    			
    			});
    		}
    	}
    });
    //Clear Prompt
    $('body').on('click', '.validation-clear', function(e){
	e.preventDefault();
	$(this).closest('form').validationEngine('hide');
    });
}
})();

/* --------------------------------------------------------
Custom
-----------------------------------------------------------*/
(function(){
	$("select[name='ctype']").change(function(){
		if($("select[name='ctype']").val() == 2) {
			$("#ccontent").show();
			$("#curl").hide();
		} else {
			$("#curl").show();
			$("#ccontent").hide();
		}
	});
	
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
	
})();
</script>
