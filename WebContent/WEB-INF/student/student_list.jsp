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
                        
                            <div class="layui-inline">
                            
                            <form action="StudentServlet?action=findByMap" method="post">
                         
                              <div class="layui-form-mid">学号:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" name="stuno"  class="layui-input">
                                </div>
                                <div class="layui-form-mid">姓名:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text"  name="sname"  class="layui-input">
                                </div>
                                <div class="layui-form-mid">性别:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                    <select name="sex">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>     
                                </div>
                                <button type="submit" class="layui-btn layui-btn-blue">查询</button>
                                <button class="layui-btn layui-btn-primary">重置</button>
                                    </form>   
                            </div>
                        
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
							  	<c:forEach items="${studentList}" var="s" >
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
      <div style="text-align: center">
                    

                        <a href="StudentServlet?action=list&p=1">首页</a>
                             
                        <c:if test="${cp>1}">
                            <a  href="StudentServlet?action=list&p=${cp-1}">上一页</a>
                        </c:if>
                           
                        <c:forEach begin="${cp-2>1 ? (cp-2) :1}" end="${cp+2>tp?tp:(cp+2)}" var="e">
                                       
                            <c:if test="${cp==e}">
                                <a  href="StudentServlet?action=list&p=${e}">${e}</a>
                            </c:if>
                            <c:if test="${cp!=e}">
                                <a  href="StudentServlet?action=list&p=${e}">${e}</a>
                            </c:if>

                        </c:forEach>

                             
                        <c:if test="${cp<tp}">
                            <a  href="StudentServlet?action=list&p=${cp+1}">下一页</a>
                        </c:if>
                        <a  href="StudentServlet?action=list&p=${tp}">尾页</a>

                    
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
                   window.location.href="<%=path %>/StudentServlet?action=delete&id="+id;
               }
           }
           
          
       </script>
</body>
</html>
	