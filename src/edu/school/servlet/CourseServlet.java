package edu.school.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.school.entity.Course;
import edu.school.service.CourseService;
import edu.school.service.impl.CourseServiceImpl;
import edu.school.utils.WebUtils;


public class CourseServlet extends BaseServlet {
    private CourseService service=new CourseServiceImpl();

    //��ҳ��ѯ
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת��ע�����
        String p=request.getParameter("p");//����ҳ��
        System.out.println(p);
        int pageSize=6;//ÿҳ��ʾ5��
        int pageNum=1; //Ĭ�ϵ�һҳ
        if(p!=null){
            pageNum= Integer.parseInt(p);
        }
        //���÷�ҳ��ѯ
        List<Course> list=service.getPage(pageNum,pageSize);
        //Я��������ҳ��
        request.setAttribute("courseList",list); //�󶨲���
        int nums=service.queryCount(); //��ѯ����
        //������ҳ��
        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
        request.setAttribute("cp",pageNum); //��ǰҳ
        request.setAttribute("tp",totalPage); //��ҳ��

        //���� ֵ1��ֵ2
        request.getRequestDispatcher("/WEB-INF/course/course_list.jsp").forward(request,response); //ҳ��ת��

    }

    //��ӿγ���Ϣ
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//���
        Course record=WebUtils.copyParamToBean(request.getParameterMap(),new Course());//ʹ��һ��BeanUtils�Ĺ����࣬�Ż�request.getParamter�Ĵ��롣
        //**����request.getParamterMap������Щ����*//*
        Map<String,String []> map=request.getParameterMap();
        for(Map.Entry<String,String[]> entry:map.entrySet()){
            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
        }
        int b=service.addCourse(record);
        if(b==1){
            response.sendRedirect(request.getContextPath()+"/CourseServlet?action=list");//�ض����ֹ�ظ��ύŶ
        }

    }
    
    //����id��ѯ
     protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
         int id=WebUtils.parseInt(request.getParameter("id"),0);
         Course record=service.queryById(id);
         request.setAttribute("course",record);
        
         request.getRequestDispatcher("/WEB-INF/course/edit_course.jsp").forward(request,response);
    }

     //����id�޸�
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//����
        int id= WebUtils.parseInt(request.getParameter("id"),0);
        String cno=request.getParameter("cno");
        String cname=request.getParameter("cname");
        String tname=request.getParameter("tname");
        String place=request.getParameter("place");
        String weekday=request.getParameter("weekday");
        String sxw=request.getParameter("sxw");
        String lesson=request.getParameter("lesson");

       int b= service.update(new Course(id,cno,cname,tname,place,weekday,sxw,lesson));
       if(b==1){
           response.sendRedirect(request.getContextPath()+"/CourseServlet?action=list");//�ض����ֹ�ظ��ύŶ
       }



    }
    
    //����idɾ��
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//����idɾ��
        int id=WebUtils.parseInt(request.getParameter("id"),0);
        service.deleteById(id);
        response.sendRedirect(request.getContextPath()+"/CourseServlet?action=list");//�ض����ֹ�ظ��ύŶ
    }

    //��������ѯ
    protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//������ѯ
        String cname=request.getParameter("cname");
        String cno=request.getParameter("cno");
        List<Course> list=service.findByMap(cno,cname);
        if(null == list || list.size() ==0 ){
            request.setAttribute("msg" ,"�޴���Ϣ");
            request.getRequestDispatcher("/WEB-INF/course/list_course.jsp").forward(request, response);
        }else {
            request.removeAttribute("msg");
            request.setAttribute("list" ,list);
            request.getRequestDispatcher("/WEB-INF/course/list_course.jsp").forward(request, response);
        }
    }

    //��ת����ӿγ�ҳ��
    protected void toAddCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת������û�����

        request.getRequestDispatcher("/WEB-INF/course/add_course.jsp").forward(request,response);
    }

}
