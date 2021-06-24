package edu.school.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import edu.school.entity.Admin;
import edu.school.entity.Student;
import edu.school.service.AdminService;
import edu.school.service.StudentService;
import edu.school.service.impl.AdminServiceImpl;
import edu.school.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service=new StudentServiceImpl();
	private AdminService as=new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理登录
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
       
        if(type.equals("1")) {
        	 Student student = service.login(new Student(null, account, null,password,null,null,null,null));
			 if (student == null) {
				  System.out.println("1*********");
				  request.setAttribute("msg","学号或者密码错误"); //绑定参数
				  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
             } else {
            	 System.out.println("2*********");
            	  request.getSession().setAttribute("type",1);
                 request.getSession().setAttribute("student",student);
                 request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
             }
        }else {

			 Admin admin = as.login(new Admin(null,account, password,null));
			 if (admin == null) {
				  request.setAttribute("msg","管理员或者密码错误"); //绑定参数
				  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
           } else {
        	   request.getSession().setAttribute("type",2);
               request.getSession().setAttribute("admin",admin);
               request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
           }
        	
        }
 
        

    }
    
    //注册
    protected void registe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理注册
  	  String stuno=request.getParameter("stuno");
        String sname=request.getParameter("sname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String major=request.getParameter("major");
        String bj=request.getParameter("bj");
        String grade=request.getParameter("grade");
        //String type=request.getParameter("type");
      if(service.existsStuno(stuno)){
          System.out.println(stuno+"该学号已存在");
          request.setAttribute("msg","该学号已存在");
          request.setAttribute("sname",sname);     
          request.getRequestDispatcher("/WEB-INF/views/registe.jsp").forward(request,response);
      }else{
          service.registerStudent(new Student(null,stuno,sname,pwd,sex,major,bj,grade));
          request.getRequestDispatcher("/WEB-INF/views/registe_success.jsp").forward(request,response);
      }
  }

    
  //学生注册
    protected void toRegiste(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
        request.getRequestDispatcher("/WEB-INF/views/registe.jsp").forward(request,response);
    }

    protected void toMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理注册
        request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request,response);
    }

    protected void welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//处理注册
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request,response);
    }
    
    protected void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到登陆界面
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }
    protected void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到登陆界面
    	request.getSession().invalidate();
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }
}
