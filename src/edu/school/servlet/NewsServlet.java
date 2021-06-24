package edu.school.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.school.entity.News;
import edu.school.service.NewsService;
import edu.school.service.impl.NewsServiceImpl;
import edu.school.utils.WebUtils;


/**
 * Servlet implementation class NewsServlet
 */

public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	NewsService service= new NewsServiceImpl();
	
	//��ת�����ŵĽ���
	 protected void toAddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת������û�����
	    request.getRequestDispatcher("/WEB-INF/news/add_news.jsp").forward(request,response);
	 }
	 
	 protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//���
	        String title=request.getParameter("title");
	        String content=request.getParameter("content");
	        String editor=request.getParameter("editor");

	        try {
	            Date nowtime = new Date();
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            String fbsj = simpleDateFormat.format(nowtime);
	            News news =new News();
	            news.setContent(content);
	            news.setTitle(title);
	            news.setEditor(editor);
	            news.setFbsj(fbsj);
	            service.addNews(news);
	        }catch (Exception e){}
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//�ض����ֹ�ظ��ύŶ


	    }

	
	 //�ļ���ҳ�б�
	  protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת��ע�����
	        String p=request.getParameter("p");//����ҳ��
	   
	        int pageSize=6;//ÿҳ��ʾ5��
	        int pageNum=1; //Ĭ�ϵ�һҳ
	        if(p!=null){
	            pageNum= Integer.parseInt(p);
	        }
	        //���÷�ҳ��ѯ
	        List<News> bList=service.getPage(pageNum,pageSize);
	        //Я��������ҳ��
	        request.setAttribute("newsList",bList); //�󶨲���
	        int nums=service.queryCount(); //��ѯ����
	        //������ҳ��
	        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
	        request.setAttribute("cp",pageNum); //��ǰҳ
	        request.setAttribute("tp",totalPage); //��ҳ��

	        //���� ֵ1��ֵ2
	        request.getRequestDispatcher("/WEB-INF/news/news_list.jsp").forward(request,response); //ҳ��ת��

	    }
	  
	  

	  
	  //ɾ������
	  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	        service.deleteNews(id);
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");
	    }
	  
	
	  //���ű�����
	  protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	         News record=service.findById(id);
	         request.setAttribute("news",record);
	         request.getRequestDispatcher("/WEB-INF/news/edit_news.jsp").forward(request,response);
	    }

	  //�޸�����
	 protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String title=request.getParameter("title");
	        String content=request.getParameter("content");
	        String editor=request.getParameter("editor");
	        int id=WebUtils.parseInt(request.getParameter("id"),0);	
	        News news =new News();
	        news.setContent(content);
	        news.setTitle(title);
	        news.setEditor(editor);
	        news.setId(id);
	        service.updateNews(news);	      
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//�ض����ֹ�ظ��ύŶ

		

	    }
	  
	  
	 
		//ģ����ѯ����
		  protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
			
			  String title=request.getParameter("title");
				System.out.print(title);
				 List<News> list=service.findByMap(title);
			        if(null == list || list.size() ==0 ){
			            request.setAttribute("msg" ,"�޴���Ϣ");
			            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
			        }else {
			            request.removeAttribute("msg");
			            request.setAttribute("list" ,list);
			            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
			        }
		    }
	

}
