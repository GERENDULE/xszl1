<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/common/header.jsp"/>
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
                           
                             <form action="CourseServlet?action=findByMap" method="post">
                              <div class="layui-form-mid">课程编号:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" name="cno"  class="layui-input">
                                </div>
                              <div class="layui-form-mid">课程名称:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" name="cname"  class="layui-input">
                                </div>
                               
                                <input value="查询" type="submit" class="layui-btn layui-btn-blue" />
                                  <c:if test="${type==2 }">
                                      <button type="button" onclick="location.href='CourseServlet?action=toAddCourse'" class="layui-btn layui-btn-narmal">新增</button>
                                </c:if>
                                <button class="layui-btn layui-btn-primary">重置</button>
                          
                                    </form>  
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
							           <c:if test="${type==2 }">
							        <th>操作</th>
							        </c:if>
							    </tr> 
							  </thead>
							  <tbody>
							  	<c:forEach items="${courseList}" var="c" >
							    <tr>
							      <td>${c.cno }</td>
							     <td>${c.cname }</td>
							      <td>${c.tname}</td>
							      <td>${c.place }</td>	
							      <td>${c.weekday }</td>	
							      <td>${c.sxw }</td>
							      <td>${c.lesson }</td>			
							        <c:if test="${type==2 }">							   							    
							      <td>
							      <a href="CourseServlet?action=query&id=${c.id }" class="layui-btn layui-btn-sm layui-btn-normal">修改</a>
						<a href="#" onclick="del(${c.id})" class="layui-btn layui-btn-sm layui-btn-danger">删除</a>
						
							      </td>
							      </c:if>
							    </tr>
							  </c:forEach>
							 
							  </tbody>
							  
							</table>
      <div style="text-align: center">
                    

                        <a href="CourseServlet?action=list&p=1">首页</a>
                             
                        <c:if test="${cp>1}">
                            <a  href="CourseServlet?action=list&p=${cp-1}">上一页</a>
                        </c:if>
                           
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                                       
                            <c:if test="${cp==e}">
                                <a  href="CourseServlet?action=list&p=${e}">${e}</a>
                            </c:if>
                            <c:if test="${cp!=e}">
                                <a  href="CourseServlet?action=list&p=${e}">${e}</a>
                            </c:if>

                        </c:forEach>

                             
                        <c:if test="${cp<tp}">
                            <a  href="CourseServlet?action=list&p=${cp+1}">下一页</a>
                        </c:if>
                        <a  href="CourseServlet?action=list&p=${tp}">尾页</a>

                    
                </div>
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
	