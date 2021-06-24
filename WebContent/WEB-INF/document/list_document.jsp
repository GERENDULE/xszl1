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
                  <a href="">学习资料管理</a>
                  <a href="">学习资料列表</a>
                
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
							      <th>资料名称</th>
							      <th>学号</th>
							      <th>上传人</th>
							      <th>上传时间</th>
							    
							        <th>操作</th>
							    </tr> 
							  </thead>
							  <tbody>
							  	<c:forEach items="${list}" var="d" >
							    <tr>
							      <td>${d.title }</td>
							     <td>${d.stuno }</td>
							      <td>${d.scr}</td>
							      <td>${d.scsj }</td>							   							    
							        <td>
							      <c:if test="${type==2 }">
							      <a href="DocumentServlet?action=query&id=${d.id }" class="layui-btn layui-btn-sm layui-btn-normal">修改</a>
						<a href="#" onclick="del(${d.id})" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
						</c:if>
						 <a  class="layui-btn layui-btn-sm layui-bg-orange"  href="DocumentServlet?action=download&resPath=${d.title}" >下载</a>				
						
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
                   window.location.href="<%=path %>/DocumentServlet?action=delete&id="+id;
               }
           }
           
          
       </script>
</body>
</html>
