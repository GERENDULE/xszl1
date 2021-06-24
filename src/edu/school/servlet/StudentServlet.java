package edu.school.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.school.entity.Admin;
import edu.school.entity.Student;
import edu.school.service.AdminService;
import edu.school.service.StudentService;
import edu.school.service.impl.AdminServiceImpl;
import edu.school.service.impl.StudentServiceImpl;
import edu.school.utils.WebUtils;

public class StudentServlet extends BaseServlet {
    private StudentService service=new StudentServiceImpl();
    private AdminService as=new AdminServiceImpl();
   
    //��ҳ��ѯѧ����Ϣ
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת��ע�����
        String p=request.getParameter("p");//����ҳ��
   
        int pageSize=6;//ÿҳ��ʾ5��
        int pageNum=1; //Ĭ�ϵ�һҳ
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //���÷�ҳ��ѯ
        List<Student> bList=service.getPage(pageNum,pageSize);
        //Я��������ҳ��
        request.setAttribute("studentList",bList); //�󶨲���
        int nums=service.queryCount(); //��ѯ����
        //������ҳ��
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //��ǰҳ
        request.setAttribute("tp",totalPage); //��ҳ��

        //���� ֵ1��ֵ2
        request.getRequestDispatcher("/WEB-INF/student/student_list.jsp").forward(request,response); //ҳ��ת��

    }

		
	//���ѧ����Ϣ
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//���
        String stuno=request.getParameter("stuno");
        String sname=request.getParameter("sname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String major=request.getParameter("major");
        String bj=request.getParameter("bj");
        String grade=request.getParameter("grade");
        if(service.existsStuno(stuno)){

            request.setAttribute("msg","��ѧ���Ѵ���");
            request.setAttribute("stuno",stuno);
            request.setAttribute("sname",sname);
            request.getRequestDispatcher("/WEB-INF/student/add_student.jsp").forward(request,response);//���ص���½����
        }else {
            service.registerStudent(new Student(null,stuno,sname,pwd,major,sex,bj,grade));
            response.sendRedirect(request.getContextPath()+"/StudentServlet?action=list");//�ض����ֹ�ظ��ύŶ

        }
    }

    	//����id��ѯ
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Student student=service.queryById(id);
         request.setAttribute("student",student);
       
         request.getRequestDispatcher("/WEB-INF/student/edit_student.jsp").forward(request,response);
    }

     //��ѯѧ��������Ϣ
    protected void findMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ������Ϣ
        String stuno=request.getParameter("stuno");
        Student student=service.findByStuno(stuno);
        request.setAttribute("student",student);
        System.out.println(student);
        request.getRequestDispatcher("/WEB-INF/student/student_info.jsp").forward(request,response);
    }

    //�༭ѧ����Ϣ
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//����
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String stuno=request.getParameter("stuno");
        String sname=request.getParameter("sname");
        String pwd=request.getParameter("pwd");
        String sex=request.getParameter("sex");
        String major=request.getParameter("major");
        String bj=request.getParameter("bj");
        String grade=request.getParameter("grade");
        String type=request.getParameter("type");
        if (type.equals("1")) {
            service.update(new Student(id,stuno,sname,pwd,major,sex,bj,grade));
            request.getRequestDispatcher("/WEB-INF/student/edit_success.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"/StudentServlet?action=findMyInfo&stuno="+stuno);//�ض����ֹ�ظ��ύŶ
        }else {
            service.update(new Student(id,stuno,sname,pwd,major,sex,bj,grade));
            response.sendRedirect(request.getContextPath()+"/StudentServlet?action=list");//�ض����ֹ�ظ��ύŶ
        }



    }
  //ɾ��ѧ��
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//����idɾ��
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        service.delete(id);
        response.sendRedirect(request.getContextPath()+"/StudentServlet?action=list"); //�ض����ֹ�ظ��ύŶ
    }
    
    //������ģ����ѯѧ����Ϣ
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//������ѯ
        String stuno=request.getParameter("stuno");
        String sname=request.getParameter("sname");
        String sex=request.getParameter("sex");
      System.out.print(stuno+sex+sname);
        List<Student> list=service.findByMap(stuno, sname,sex);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"�޴���Ϣ");
            request.getRequestDispatcher("/WEB-INF/student/list_student.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/student/list_student.jsp").forward(request, response);
        }
    }

 
    

   
    
    

    //��ת�����ѧ������Ϣ
    protected void toAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת������û�����
        request.getRequestDispatcher("/WEB-INF/student/add_student.jsp").forward(request,response);
    }
    
 
    
    //ѧ���޸�����
    protected void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
    	
        String stuno=request.getParameter("stuno");
        String pwd=request.getParameter("pwd");      
        int b=service.updatePwd(new Student(null,stuno,null,pwd,null,null,null,null));
        if(b==1) {
       	  request.getRequestDispatcher("/WEB-INF/student/edit_success.jsp").forward(request,response);
        }
          
       


  }
  
}
