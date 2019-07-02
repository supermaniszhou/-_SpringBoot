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
			<div id="use6">
				<input type="button" id="createUser" value="createUser"/>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#createUser').click(function(){
				$.ajax({
					url:'${ctx}/user/testAddUser2',
					data:{
						username:"leeeh1",
						password:"password",
						salt:"123",
						locked:true
					},
					type:"POST",
					dataType:'json',
					cache:false,
					success:function(data){
						console.log(data);
					},
					error:function(data){
						
					}
				})
			})
		});
	</script>
</body>
</html>
