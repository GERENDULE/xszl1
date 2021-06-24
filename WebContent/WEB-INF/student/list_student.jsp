<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
%>
<jsp:include page="/WEB-INF/common/header.jsp"/>


</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">学生管理</a>
                  <a href="">学生列表</a>
                
                </span>
              
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item">
                       <span class="msg" style="color:red;">${requestScope.msg}</span>
                                <button type="button" onclick="location.href='StudentServlet?action=list'" class="layui-btn layui-btn-blue">返回主界面</button>
                              
                        </div>
                      
                        <table class="layui-table">
                     
							  
							  <thead>
							    <tr>
							      <th>学号</th>
							      <th>姓名</th>
							      <th>性别</th>
							      <th>专业</th>
							      <th>年级</th>
							      <th>班级</th>
							      <th>密码</th>
							        <th>操作</th>
							    </tr> 
							  </thead>
							  <tbody>
							  	<c:forEach items="${list}" var="s" >
							    <tr>
							      <td>${s.stuno }</td>
							      <td>${s.sname }</td>
							      <td>${s.sex }</td>
							      <td>${s.major }</td>
							      <td>${s.grade }</td>
							      <td>${s.bj }</td>
							      <td>${s.pwd }</td>
							      <td>
							      <a href="StudentServlet?action=query&id=${s.id }" class="layui-btn layui-btn-sm layui-btn-normal">修改</a>
						<a href="#" onclick="del(${s.id})" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
							      </td>
							    </tr>
							  </c:forEach>
							 
							  </tbody>
							  
							</table>
     
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/layui.all.js"></script>
      <script language="javascript">
           function del(id)
           {
               if(confirm('您确定删除该条记录吗？'))
               {
                   window.location.href="<%=path %>/StudentServlet?action=delete&id="+id;
               }
           }
           
          
       </script>
</body>
</html>
		
