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
          
                <div class="layui-card-header">修改管理员密码</div>
                  <span class="msg" style="color:red;">${requestScope.msg}</span>
                <form class="layui-form layui-card-body" action="AdminServlet?action=updatePwd" method="post">
           
			      <input type="hidden" value="${admin.id}" name="id">
                  <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                      <input type="text" id="username" name="username" value="${admin.username }"  readonly placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">密&emsp;&emsp;码：</label>
                    <div class="layui-input-block">
                      <input type="password" id="pwd" name="pwd" required  value="${admin.password }" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                     <div class="layui-form-item">
                    <label class="layui-form-label">确认密码：</label>
                    <div class="layui-input-block">
                      <input type="password" id="rpwd" name="rpwd"  value="" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                   
                 
                  
                 
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn layui-btn-blue" id="editAdmin" type="submit">立即修改</button>
                      <button type="button" onclick="location.href='LoginServlet?action=welcome'"class="layui-btn layui-btn-primary">取消修改</button>
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
    $("#editAdmin").click(function () {
       
        
        //校验密码
        var passwordText = $("#pwd").val();    
        var passwordPatt = /^\w{5,12}$/;     
        if (!passwordPatt.test(passwordText)) {
         
            $("span.msg").text("密码至少6位！");
            return false;
        }
      //校验确认密码
        var rpwdText = $("#rpwd").val();    
        if (rpwdText=="") {
           
            $("span.msg").text("确认密码不许为空！");
            return false;
        }
		
        if (passwordText!=rpwdText) {
            
            $("span.msg").text("两次密码不一致！");
            return false;
        }
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})







</script>
</body>
</html>