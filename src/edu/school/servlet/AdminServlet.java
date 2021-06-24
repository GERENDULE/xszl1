package edu.school.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.school.entity.Admin;
import edu.school.entity.Student;
import edu.school.service.AdminService;
import edu.school.service.impl.AdminServiceImpl;
import edu.school.utils.WebUtils;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminService as=new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //管理员修改密码
    protected void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
    	
    	int id=WebUtils.parseInt(request.getParameter("id"),0);
         String password=request.getParameter("password");      
         int b=as.updatePwd(new Admin(id,null,password,null));
         if(b==1) {
        	  request.getRequestDispatcher("/WEB-INF/views/edit_success.jsp").forward(request,response);
         }

   }
    //跳转到修改管理员个人信息列表
    protected void toEditAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
        request.getRequestDispatcher("/WEB-INF/views/edit_admin.jsp").forward(request,response);
	}
	

}
