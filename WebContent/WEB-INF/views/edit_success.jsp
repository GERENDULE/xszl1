<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
%>
<jsp:include page="/WEB-INF/common/header.jsp"/>
		
	</head>
  <body>
       
<h4 style="color:red">修改成功</h4>
<button type="button" class="layui-btn layui-btn-blue"  onclick="location.href='AdminServlet?action=toEditAdmin&stuno=${sessionScope.student.stuno}'">返回查看我的信息</button>
  </body>
</html>
