<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
%>
<jsp:include page="/WEB-INF/common/header.jsp"/>

</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-row">
         <div class="layui-col-md6">
            <div class="layui-card">
          
                <div class="layui-card-header">我的个人信息</div>
                <form class="layui-form layui-card-body" action="StudentServlet?action=update" method="post">
                <input type="hidden" value="${type}" name="type">
			      <input type="hidden" value="${student.id}" name="id">
                  <div class="layui-form-item">
                    <label class="layui-form-label">学号：</label>
                    <div class="layui-input-block">
                      <input type="text" id="stuno" name="stuno"  value="${student.stuno }"  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                    <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                      <input type="text" id="sname" name="sname"   lay-verify="required" value="${student.sname }" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                      <input type="password" id="pwd" name="pwd"   lay-verify="required" value="${student.pwd }" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">性别：</label>
                    <div class="layui-input-block">
                      <input type="radio" name="sex" value="男" title="男">
                      <input type="radio" name="sex" value="女" title="女" checked>
                    </div>
                  
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">专业：</label>
                    <div class="layui-input-block">
                      <input type="text" id="major" name="major" required  value="${student.major }" lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">年级：</label>
                    <div class="layui-input-block">
                      <select name="grade" lay-verify="required">
                        <option value=""></option>
                        <option value="大一">大一</option>
                        <option value="大二">大二</option>
                        <option value="大三">大三</option>
                        <option value="大四">大四</option>
                       
                      </select>
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">班级：</label>
                    <div class="layui-input-block">
                      <input type="text" id="bj" name="bj" required  lay-verify="required" value="${student.bj }" placeholder="请输入班级" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                 
                 
                  
                 
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn layui-btn-blue" type="submit">立即修改</button>
                      <button type="button" onclick="location.href='LoginServlet?action=welcome'"class="layui-btn layui-btn-primary">取消修改</button>
                    </div>
                  </div>
                </form>  
            </div>
            </div>
        </div>
    </div>
    <script src="assets/layui.all.js"></script>
   
</body>
</html>