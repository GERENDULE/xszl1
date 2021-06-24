
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()
            +"://"
            +request.getServerName()
            +":"+
            +request.getServerPort()
            +request.getContextPath()
            +"/";
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/view.css"/>
    <title>学生资料后台</title>
    
  <%--   <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/style.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/base.css" /> --%>