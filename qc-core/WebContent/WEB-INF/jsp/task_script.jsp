<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<div style="display: none;">
<script src="http://s95.cnzz.com/z_stat.php?id=1257627622&web_id=1257627622" language="JavaScript"></script>
</div>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${path }/js/fingerprint2.min.js"></script>
<script type="text/javascript" src="${path }/js/utils.js"></script>
<script>
	$(document).ready(function(){
		if(isWeiXin()) {
			var key = "t_f_${taskId }";
			var count = utils.getCookie(key);
			if(count == null || count == '' || count == undefined) {
				count = utils.getLocalStorage(key);
				if(count == null || count == '' || count == undefined) {
					utils.setCookie(key, 1 , 365 * 24 * 60 * 60 * 1000);
					utils.setLocalStorage(key, 1);
					
					// 获取浏览器指纹
					new Fingerprint2().get(function(result,components){
						$.get("${path}/public/task/read?taskId=${taskId }&id=${id }&sign=${sign }&timestamp=${timestamp }&finger=" + result);
						var type = parseInt("${readTaskContent.type }");
						if(type == 1) {
							location.href = "${readTaskContent.url }";
						}

					});
				}
			} else {
				var type = parseInt("${readTaskContent.type }");
				if(type == 1) {
					location.href = "${readTaskContent.url }";
				}
			}
			
		}
	});
	
	function isWeiXin() {
	    var a = window.navigator.userAgent.toLowerCase();
	    if (a.match(/MicroMessenger/i) == "micromessenger") {
	        return true;
	    } else {
	        return false;
	    }
	 };
   </script>