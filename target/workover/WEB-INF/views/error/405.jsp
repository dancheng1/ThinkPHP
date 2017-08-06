<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%response.setStatus(200);%>

<%
	//记录日志
	Logger logger = LoggerFactory.getLogger("405.jsp");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>405 error page</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
<font color="blue">
	Request method 'GET' not supported
	<br/><br/>
	The specified HTTP method is not allowed for the requested resource.
</font>
</body>
</html>
