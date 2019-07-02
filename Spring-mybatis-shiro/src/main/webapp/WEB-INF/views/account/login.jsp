<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>登录页</title>
	<link href="${ctx}/static/styles/login.css" type="text/css" rel="stylesheet" />
</head>

<body>
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="row">
				<div class="col-md-12 rowheight150"></div>
			</div>
			<form id="loginForm" class="form-horizontal" action="${ctx}/login" method="post">
			<div class="center">
				<div class="row" style="margin-top: 30px;">
					<div class="form-group">
						<label class="col-md-3 control-label">用户名</label>
						<div class="col-md-4">
							<input type="text" class="form-control" id="username"
								name="username" value="${requestScope.username}" placeholder="请输入用户名" />
						</div>
						<div class="col-md-5"></div>
					</div>
				</div>

					<div class="row">
						<div class="form-group">
							<label class="col-md-3 control-label">密码</label>
							<div class="col-md-4">
								<input type="password" class="form-control" name="password"
									placeholder="请输入密码" id="password" value=""/>
							</div>
							<div class="col-md-5"></div>
						</div>
					</div>

					<div class="row">

						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-4">
								<button class="btn btn-default buttonWidth" type="submit">登录</button>
								&nbsp;
								<button id="registerBtn"
									class="btn btn-default buttonWidth" type="button">注册</button>
								<!-- <input class="checkbox" id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/>记住我  -->
							</div>
							<div class="col-md-5"></div>
						</div>

					</div>
					</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	
	<script>
		$(document).ready(function() {
		});
	</script>
</body>
</html>
