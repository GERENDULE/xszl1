<%@ page language="java" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="assets/css/layui.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="login-wrap">
    <div class="login-container">
  
        <form class="login-form" action="LoginServlet?action=login" method="post">
          <h2>学生资料管理系统登录</h2>
            <span class="msg" style="color:red;">${requestScope.msg}</span>
            <div class="input-group">
          <input type="text" id="account"  placeholder="请输入用户名"  name="account" class="input-field">
                <label for="account" class="input-label">
              
                 
                </label>
            </div>
            <span style="color:red">${msg}</span>
            <div class="input-group">
                <input type="password" id="password"  placeholder="请输入密码" name="password"class="input-field">
              <label for="password" class="input-label">
                   
                </label> 
            </div>
             <div class="input-group">
                <input type="radio" name="type" value="1" >学生 &emsp;
      <input type="radio" name="type" value="2"  checked>管理员
            </div>
            <button type="submit" id="login" class="login-button">登录<i class="ai ai-enter"></i></button>
             <button onclick="location.href='LoginServlet?action=toRegiste'" type="button" class="login-button ">去注册<i class="ai ai-enter"></i></button>
        </form>
    </div>
</body>
<script src="${pageContext.request.contextPath }/assets/layui.js"></script>
<script src="assets/index.js" data-main="login"></script>
<script src="${pageContext.request.contextPath }/assets/js/jquery-1.8.0.min.js"></script>
    <script>
$(function () {
    // 给注册绑定单击事件
    $("#login").click(function () {
       
        
     
      //校验用户名
        var accountText = $("#account").val();    
        if (accountText=="") {
           
            $("span.msg").text("用户名不许为空！");
            return false;
        }
      
        
        var passwordText = $("#password").val();    
        if (passwordText=="") {
           
            $("span.msg").text("密码不许为空！");
            return false;
        }
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})







</script>
</html>