<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>myspring7z<sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link href="${ctx}/static/bootstrap3/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>


<sitemesh:head/>
</head>

<body>
	<div class="container-fluid index">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
			<sitemesh:body/>
		<%-- <%@ include file="/WEB-INF/layouts/footer.jsp"%> --%>
	</div>
	<script src="${ctx}/static/bootstap3/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/handlebars/handlebars-v4.0.11.js" type="text/javascript"></script>
	<script type="text/javascript">
		function render(templateId, data) {
			var source = $(templateId).html();
			var template = Handlebars.compile(source);
			var html = template(data);
			return html;
		}
	</script>
</body>
</html>