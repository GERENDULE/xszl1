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
          
                <div class="layui-card-header">修改学习资料信息</div>
                  <span class="msg" style="color:red;">${requestScope.msg}</span>
                <form class="layui-form layui-card-body" enctype="multipart/form-data" action="DocumentServlet?action=update" method="post">
                <input type="hidden" value="${record.id}" name="id">
			    
                  <div class="layui-form-item">
                    <label class="layui-form-label">文件标题：</label>
                    <div class="layui-input-block">
                      <input type="text" id="title" name="title" value="${record.title }" placeholder="请输入文件题目" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                    <div class="layui-form-item">
                    <label class="layui-form-label">上传文件：</label>
                    <div class="layui-input-block">
                      <input type="file" id="file" name="file" placeholder="请选择文件" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
             
                  
                    <div class="layui-form-item">
                    <label class="layui-form-label">上&nbsp;传&nbsp;人：</label>
                    <div class="layui-input-block">
                      <input type="text" id="scr" name="scr" value="${record.scr }"  placeholder="请输入上传人" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                    <div class="layui-form-item">
                    <label class="layui-form-label">学&emsp;&emsp;&emsp;&emsp;号：</label>
                    <div class="layui-input-block">
                      <input type="text" id="stuno" name="stuno" value=""  placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                  
                
                 
                 
                  
                 
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn layui-btn-blue" id="updateDocument" type="submit">立即修改</button>
                      <button type="button" onclick="location.href='DocumentServlet?action=list'"class="layui-btn layui-btn-primary">取消上传</button>
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
   
    $("#updateDocument").click(function () {
       
        var snameText = $("#scr").val();    
        if (snameText=="") {
            //4 提示用户结果
            $("span.msg").text("上传人不许为空！");
            return false;
        }
        
        var titleText = $("#title").val();    
        if (titleText=="") {
            //4 提示用户结果
            $("span.msg").text("标题不许为空！");
            return false;
        }
       
        
        var fileText = $("#file").val();    
        if (fileText=="") {
            //4 提示用户结果
            $("span.msg").text("上传文件不许为空！");
            return false;
        }
       
        
        var stunoText = $("#stuno").val();    
        if (stunoText=="") {
          
            $("span.msg").text("学号不许为空！");
            return false;
        }
       

     
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})







</script>
</body>
</html>