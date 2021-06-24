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
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header custom-header">
            
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item slide-sidebar" lay-unselect>
                    <a href="javascript:;" class="icon-font"><i class="ai ai-menufold"></i></a>
                </li>
            </ul>

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                <c:if test="${type==1 }">
                    <a href="javascript:;">欢迎学生：${student.sname }</a>
                    </c:if>
                       <c:if test="${type==2 }">
                    <a href="javascript:;">欢迎管理员：${admin.nickname }</a>
                    </c:if>
                    <dl class="layui-nav-child">
                       
                        <dd><a href="LoginServlet?action=loginOut">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-side custom-admin">
            <div class="layui-side-scroll">

                <div class="custom-logo">
                    <img src="assets/images/logo.png" alt=""/>
                    <h1>学生资料系统后台</h1>
                </div>
                  <c:if test="${type==1 }">
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe609;</i>
                            <em>主页</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="LoginServlet?action=welcome">控制台</a></dd>
                        </dl>
                    </li>
                  
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe612;</i>
                            <em>个人信息管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="StudentServlet?action=findMyInfo&stuno=${student.stuno }">我的信息</a></dd>
                            
                        </dl>
                    </li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>学习资料管理</em>
                        </a>    
                                <dl class="layui-nav-child">
                                    <dd>
                                        <a href="DocumentServlet?action=list">学习资料列表</a>   </dd>
                                         <dd><a href="DocumentServlet?action=YList&stuno=${student.stuno }">已上传的学习资料</a></dd>
                                          <dd><a href="DocumentServlet?action=toAddDocument">我要上传学习资料</a></dd>
     
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>课程管理</em>
                        </a>
                       
                                <dl class="layui-nav-child">
                                    <dd>
                                         <a href="CourseServlet?action=list">课程列表</a>
                                           
                                    </dd>
                                </dl>
                           
                    </li>
                     <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>新闻管理</em>
                        </a>
                        
                                
                                <dl class="layui-nav-child">
                                    <dd>
                                        <a href="NewsServlet?action=list">新闻列表</a>
                                          
                                    </dd>
                                </dl>
                          
                    </li>
                </ul>
                </c:if>
                <c:if test="${type==2 }">
                <ul id="Nav" class="layui-nav layui-nav-tree">
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe609;</i>
                            <em>主页</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="LoginServlet?action=welcome">控制台</a></dd>
                        </dl>
                    </li>
                  
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe612;</i>
                            <em>学生管理</em>
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="StudentServlet?action=list">学生信息</a></dd>
                            <dd><a href="StudentServlet?action=toAddStudent">添加学生</a></dd>
                        </dl>
                    </li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>学习资料管理</em>
                        </a>
                        <dl class="layui-nav-child">
                             <dd> <a href="DocumentServlet?action=list">学习资料列表</a></dd>
                        </dl>
                           
                        
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>课程管理</em>
                        </a>
                        <dl class="layui-nav-child">
                              <dd>
                                         <a href="CourseServlet?action=list">课程列表</a> </dd>
                           <dd>  <a href="CourseServlet?action=toAddCourse">发布课程</a></dd>
                                  
                        </dl>

                               
                           
                    </li>
                     <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe62a;</i>
                            <em>新闻管理</em>
                        </a>
                                <dl class="layui-nav-child">
                                    <dd><a href="NewsServlet?action=list">新闻列表</a> </dd>
                                      <dd> <a href="NewsServlet?action=toAddNews">发布新闻</a>  </dd>                                      
                                </dl>                  
                    </li>
                      <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon">&#xe620;</i>
                            <em>系统管理</em>
                        </a>
                                <dl class="layui-nav-child">
                                    <dd><a href="AdminServlet?action=toEditAdmin">修改密码</a> </dd>
                                                                    
                                </dl>                  
                    </li>
                </ul>
                </c:if>

            </div>
        </div>

        <div class="layui-body">
             <div class="layui-tab app-container" lay-allowClose="true" lay-filter="tabs">
                <ul id="appTabs" class="layui-tab-title custom-tab"></ul>
                <div id="appTabPage" class="layui-tab-content"></div>
            </div>
        </div>

        <div class="layui-footer">
            <p>© 2021 DEMO</p>
        </div>

        <div class="mobile-mask"></div>
    </div>
    <script src="assets/layui.js"></script>
      <script src="assets/home.js"></script>
<!--    <script src="assets/index.js" data-main="home"></script>> -->
</body>
</html>