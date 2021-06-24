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
                  <a href="">新闻管理</a>
                  <a href="">新闻列表</a>
                
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
                                <button type="button" onclick="location.href='NewsServlet?action=list'" class="layui-btn layui-btn-blue">返回主界面</button>
                              
                            </div>
                        
                        </div>
                      
                        <table class="layui-table">
                     
							  
							  <thead>
							    <tr>
							      <th>新闻标题</th>
							      <th>编辑者</th>
							      <th>新闻内容</th>
							      <th>发布时间</th>
							    
							        <th>操作</th>
							    </tr> 
							  </thead>
							  <tbody>
							  	<c:forEach items="${list}" var="n" >
							    <tr>
							      <td>${n.title }</td>
							     <td>${n.editor }</td>
							      <td>${n.content}</td>
							      <td>$nd.fbsj }</td>							   							    
							      <td>
							      <a href="NewsServlet?action=query&id=${n.id }" class="layui-btn layui-btn-sm layui-btn-normal">修改</a>
						<a href="#" onclick="del(${n.id})" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
						
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
                   window.location.href="<%=path %>/NewsServlet?action=delete&id="+id;
               }
           }
           
          
       </script>
</body>
</html>