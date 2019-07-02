<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>test</title>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<div id="testhandlebars"></div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			var data=[{name:'lee'},{name:'lee2'}];
			var html=render('#template-list',data);
			$('#testhandlebars').html(html);
		});
	</script>
	<script id="template-list" type="x-handlebars-template">
		{{#each .}}
			Hello:
			{{name}}
			GoodBye.
		{{/each}}
	</script>
</body>
</html>
