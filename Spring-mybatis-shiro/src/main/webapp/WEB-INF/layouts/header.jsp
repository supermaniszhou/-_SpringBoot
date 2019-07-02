<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="row headerBorder">
	<div class="col-md-12">
		<div class="pull-left">&nbsp;&nbsp;<a href="http://www.myspring.cc">主页</a> &nbsp;约吗 &nbsp;论坛&nbsp;
			<a href="${ctx}/guestbook/normal/list">留言</a>
		</div>
		<!--  <a href="http://127.0.0.1:8080/myspring"> -->
		<!--  <a href="http://127.0.0.1:8080/myspring"> -->
		<div class="pull-right" style="padding-right:75px;">
			<shiro:guest><a href="${ctx}/login">登录</a></shiro:guest>
			<shiro:user>你好, <a href="${ctx}/public/userinfo/userinfo" target="_blank"><shiro:principal property="loginName"/></a> <a href="${ctx}/logout">退出</a></shiro:user>
 			| 
			<a href="${ctx}/blog/help/donat" target="_blank">捐赠</a>
 			| 
			<a href="${ctx }/blog/help/help" target="_blank">帮助</a>&nbsp;&nbsp;
		</div>
	</div>
</div>