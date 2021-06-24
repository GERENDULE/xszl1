<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
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
    <title>学生资料管理系统</title>
</head>
<body class="login-wrap">
    <div class="login-container">
        <form class="login-form" action="LoginServlet?action=registe" method="post">
          <h2>学生资料管理系统注册</h2>
            <span class="msg" style="color:red;">${requestScope.msg}</span>
            
           <div class="input-group">
           
            <input type="text" id="stuno" placeholder="请输入学号" name="stuno" class="input-field">
              <label for="stuno" class="input-label">
                   
                </label>
            </div>
          
             <div class="input-group">
                <input type="text" id="sname" placeholder="请输入姓名"  name="sname" class="input-field">
                <label for="sname" class="input-label">
                
                </label>
            </div>
            <div class="input-group">
                <input type="password" id="pwd" placeholder="请输入密码"  name="pwd" class="input-field">
                <label for="password" class="input-label">
                  
                </label>
            </div>
            <div class="input-group">
                <input type="text" id="major" name="major" placeholder="请输入专业"  class="input-field">
                <label for="major" class="input-label">
                    
                </label>
            </div>
             <div class="input-group">
                <input type="radio" name="sex" value="男" >男 &emsp;
                 <input type="radio" name="sex" value="女"  checked>女
            </div>
             <div class="input-group">
                <input type="text" id="bj" name="bj" placeholder="请输入班级"  class="input-field">
                <label for="bj" class="input-label">
                    
                </label>
            </div>
             <div class="input-group">
                <input type="text" id="grade" name="grade" placeholder="请输入年级"  class="input-field">
                <label for="bj" class="input-label">
                    
                </label>
            </div> 
            <button type="submit" id="registe" class="login-button">注册<i class="ai ai-enter"></i></button>
             <button onclick="location.href='LoginServlet?action=toLogin'" type="button" class="login-button" >去登录<i class="ai ai-enter"></i></button>
        </form>
    </div>

</body>
<script src="${pageContext.request.contextPath }/assets/js/jquery-1.8.0.min.js"></script>
<script>
$(function () {
    // 给注册绑定单击事件
    $("#registe").click(function () {
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
            $("span.msg").text("年纪不许为空！");
            return false;
        }

     
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})
(function () {

    var entry,
        // 配置所有应用的入口文件，程序将会按照data-main属性中设置的值进行索引查找
        // 如果你在引入此脚本的script标签上没有设置data-main属性，程序将会默认访问home.js文件
        app = {
            home : '{/}home',
            login : '{/}login'
        };

    (function(){

        var dataMain, scripts = document.getElementsByTagName('script'),
            eachScripts = function(el){
                dataMain = el.getAttribute('data-main');
                if(dataMain){
                    entry = dataMain;
                }
            };

        [].slice.call(scripts).forEach(eachScripts);

    })();

    layui.config({
        base: 'assets/lay/modules/'
    }).extend(app).use(entry || 'home');

})();






</script>
<script src="assets/layui.js"></script> 
<!-- <script src="assets/index.js" data-main="login"></script>  -->
</html>