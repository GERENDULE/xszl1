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
                  <a href="">课程管理</a>
                  <a href="">课程列表</a>
                
                </span>
              
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item">
                        
                            <div class="layui-inline">

                                   <span class="msg" style="color:red;">${requestScope.msg}</span>
                                <button type="button" onclick="location.href='CourseServlet?action=list'" class="layui-btn layui-btn-blue">返回主界面</button>
                              
                           
                            </div>
                        
                        </div>
                      
                        <table class="layui-table">
                   
							  
							  <thead>
							    <tr>
							      <th>课程编号</th>
							      <th>课程名称</th>
							      <th>授课老师</th>
							      <th>上课地点</th>
							      <th>星期几</th>
							      <th>上/下/晚</th>
							         <th>第几节</th>
							        <th>操作</th>
							    </tr> 
							  </thead>
							  <tbody>
							  	<c:forEach items="${list}" var="c" >
							    <tr>
							      <td>${c.cno }</td>
							     <td>${c.cname }</td>
							      <td>${c.tname}</td>
							      <td>${c.place }</td>	
							      <td>${c.weekday }</td>	
							      <td>${c.sxw }</td>
							      <td>${c.lesson }</td>										   							    
							      <td>
							      <a href="CourseServlet?action=query&id=${c.id }" class="layui-btn layui-btn-sm layui-btn-normal">修改</a>
						<a href="#" onclick="del(${c.id})" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
						
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
                   window.location.href="<%=path %>/CourseServlet?action=delete&id="+id;
               }
           }
           
          
       </script>
</body>
</html>
	