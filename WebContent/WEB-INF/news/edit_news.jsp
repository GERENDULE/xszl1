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
          
                <div class="layui-card-header">编辑新闻信息</div>
                  <span class="msg" style="color:red;">${requestScope.msg}</span>
                <form class="layui-form layui-card-body"  action="NewsServlet?action=add" method="post">
                <input type="hidden" value="${news.id}" name="id">
                  <div class="layui-form-item">
                    <label class="layui-form-label">新闻标题：</label>
                    <div class="layui-input-block">
                      <input type="text" id="title" name="title" value="${news.title }" placeholder="请输入新闻标题" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">编辑者：</label>
                    <div class="layui-input-block">
                      <input type="text" id="editor" name="editor" value="${news.editor }" placeholder="请输入编辑者" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                   
                   
                  <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">新闻内容：</label>
                    <div class="layui-input-block">
                      <textarea name="content" id="content" value="${news.content }" placeholder="请输入新闻内容" class="layui-textarea"></textarea>
                    </div>
                  </div>
                  
                  
             
                  
                 
                 
                 
                  
                 
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn layui-btn-blue" id="updateNews" type="submit">确认编辑</button>
                      <button type="button" onclick="location.href='NewsServlet?action=list'"class="layui-btn layui-btn-primary">取消编辑</button>
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
    
    $("#updateNews").click(function () {
       
        var titleText = $("#title").val();    
        if (titleText=="") {        
            $("span.msg").text("新闻标题不许为空！");
            return false;
        }
        
        var editorText = $("#editor").val();    
        if (editorText=="") {
            $("span.msg").text("编辑者不许为空！");
            return false;
        }
       
        
        var contentText = $("#content").val();    
        if (contentText=="") {
            $("span.msg").text("新闻内容不许为空！");
            return false;
        }
      
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})







</script>
</body>
</html>