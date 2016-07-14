<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
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