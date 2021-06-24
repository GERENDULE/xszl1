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
          
                <div class="layui-card-header">发布课程</div>
                  <span class="msg" style="color:red;">${requestScope.msg}</span>
                <form class="layui-form layui-card-body" action="CourseServlet?action=add" method="post">
              
			    
                  <div class="layui-form-item">
                    <label class="layui-form-label">课程编号：</label>
                    <div class="layui-input-block">
                      <input type="text" id="cno" name="cno" placeholder="请输入课程编号" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                     <div class="layui-form-item">
                    <label class="layui-form-label">课程名称：</label>
                    <div class="layui-input-block">
                      <input type="text" id="cname" name="cname" placeholder="请输入课程名称" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                    <div class="layui-form-item">
                    <label class="layui-form-label">教师姓名：</label>
                    <div class="layui-input-block">
                      <input type="text" id="tname" name="tname" placeholder="请输入教师姓名" autocomplete="off" class="layui-input">
                    </div>
                  </div>
                  
                  <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">授课地点：</label>
                    <div class="layui-input-block">
                      <textarea name="place" id="place" placeholder="请输入授课地点" class="layui-textarea"></textarea>
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">星期几：</label>
                    <div class="layui-input-block">
                      <select name="weekday" lay-verify="required">
                
                        <option value="星期一">星期一</option>
                        <option value="星期二">星期二</option>
                        <option value="星期三">星期三</option>
                        <option value="星期四">星期四</option>
                          <option value="星期五">星期五</option>
                           <option value="星期六">星期六</option>
                            <option value="星期日">星期日</option>
                       
                      </select>
                    </div>
                  </div>
                  
                   <div class="layui-form-item">
                    <label class="layui-form-label">上/下/晚：</label>
                    <div class="layui-input-block">
                      <select name="sxw" lay-verify="required">
                
                        <option value="上午">上午</option>
                        <option value="下午">下午</option>
                        <option value="晚上">晚上</option>
                      
                       
                      </select>
                    </div>
                  </div>
                  
                  <div class="layui-form-item">
                    <label class="layui-form-label">节数：</label>
                    <div class="layui-input-block">
                      <select name="lesson" lay-verify="required">
                
                        <option value="一、二节">一、二节</option>
                        <option value="三、四节">三、四节</option>
                   
                      
                       
                      </select>
                    </div>
                  </div>
                  
                  
                  
             
                  
                   
                 
                  
                 
                  <div class="layui-form-item">
                    <div class="layui-input-block">
                      <button class="layui-btn layui-btn-blue" id="addCourse" type="submit">确认添加</button>
                      <button type="button" onclick="location.href='CourseServlet?action=list'"class="layui-btn layui-btn-primary">取消添加</button>
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
    
    $("#addCourse").click(function () {
    	
    	  var cnoText = $("#cno").val();    
          if (cnoText=="") {     
              $("span.msg").text("课程编号不许为空！");
              return false;
          }
       
        var cnameText = $("#cname").val();    
        if (cnameText=="") {     
            $("span.msg").text("课程名称不许为空！");
            return false;
        }
        
        var tnameText = $("#tname").val();    
        if (tnameText=="") {
           
            $("span.msg").text("教师名称不许为空！");
            return false;
        }
       
        
        var placeText = $("#place").val();    
        if (placeText=="") {
            $("span.msg").text("授课地点不许为空！");
            return false;
        }
       

     
        
               
    });
    // 去掉错误信息
    setTimeout(function(){ $(".msg").html("")},10000);
})







</script>
</body>
</html>