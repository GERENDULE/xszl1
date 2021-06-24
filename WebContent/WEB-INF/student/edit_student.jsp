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
          
                <div class="layui-card-header">修改学生信息</div>
                <form class="layui-form layui-card-body" action="StudentServlet?action=update" method="post">
                <input type="hidden" value="${type}" name="type">
			      <input type="hidden" value="${student.id}" name="id">
                  <div class="layui-form-item">
                    <label class="layui-form-label">学号：</label>
                    <div class="layui-input-block">
                      <input type="text" id="stuno" name="stuno" required value="${student.stuno }"  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                    <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                      <input type="text" id="sname" name="sname" required  lay-verify="required" value="${student.sname }" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                      <input type="password" id="pwd" name="pwd" required  lay-verify="required" value="${student.pwd }" placeholder="请输入密码" autocomplete="off" class="layui-input">
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
                      <button class="layui-btn layui-btn-blue" id="updateStudent" type="submit">立即修改</button>
                      <button type="button" onclick="location.href='StudentServlet?action=list'"class="layui-btn layui-btn-primary">取消修改</button>
                    </div>
                  </div>
                </form>  
            </div>
            </div>
        </div>
    </div>
    <script src="assets/layui.all.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery-1.8.0.min.js"></script>
<script>
$(function () {
    // 给注册绑定单击事件
    $("#updateStudent").click(function () {
        // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
        //1 获取用户名输入框里的内容
        var stunoText = $("#stuno").val();
        //2 创建正则表达式对象
        var stunoPatt = /^\w{5,12}$/;
        //3 使用test方法验证
        if (!stunoPatt.test(stunoText)) {
            //4 提示用户结果
            $("span.msg").text("学号至少5位！");

            return false;
        }
        //校验姓名
        var snameText = $("#sname").val();    
        if (snameText=="") {
            //4 提示用户结果
            $("span.msg").text("姓名不许为空！");
            return false;
        }
        //校验密码
        var passwordText = $("#pwd").val();    
        var passwordPatt = /^\w{5,12}$/;     
        if (!passwordPatt.test(passwordText)) {
            //4 提示用户结果
            $("span.msg").text("密码至少6位！");
            return false;
        }
      //校验专业
        var majorText = $("#major").val();    
        if (majorText=="") {
            //4 提示用户结果
            $("span.msg").text("专业不许为空！");
            return false;
        }
		//校验班级
        var bjText = $("#bj").val();    
        if (bjText=="") {
            //4 提示用户结果
            $("span.msg").text("班级不许为空！");
            return false;
        }
        
        var gradeText = $("#grade").val();    
        if (gradeText=="") {
            //4 提示用户结果
            $("span.msg").text("年级不许为空！");
            return false;
        }

     
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})

</script>
</body>
</html>