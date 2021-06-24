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
	
	//跳转到新闻的界面
	 protected void toAddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到添加用户界面
	    request.getRequestDispatcher("/WEB-INF/news/add_news.jsp").forward(request,response);
	 }
	 
	 protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//添加
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
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//重定向防止重复提交哦


	    }

	
	 //文件分页列表
	  protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//跳转到注册界面
	        String p=request.getParameter("p");//接收页码
	   
	        int pageSize=6;//每页显示5条
	        int pageNum=1; //默认第一页
	        if(p!=null){
	            pageNum= Integer.parseInt(p);
	        }
	        //调用分页查询
	        List<News> bList=service.getPage(pageNum,pageSize);
	        //携带参数到页面
	        request.setAttribute("newsList",bList); //绑定参数
	        int nums=service.queryCount(); //查询总数
	        //计算总页数
	        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
	        request.setAttribute("cp",pageNum); //当前页
	        request.setAttribute("tp",totalPage); //总页数

	        //条件 值1：值2
	        request.getRequestDispatcher("/WEB-INF/news/news_list.jsp").forward(request,response); //页面转发

	    }
	  
	  

	  
	  //删除新闻
	  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	        service.deleteNews(id);
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");
	    }
	  
	
	  //新闻表单回显
	  protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	         News record=service.findById(id);
	         request.setAttribute("news",record);
	         request.getRequestDispatcher("/WEB-INF/news/edit_news.jsp").forward(request,response);
	    }

	  //修改新闻
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
	        response.sendRedirect(request.getContextPath()+"/NewsServlet?action=list");//重定向防止重复提交哦

		

	    }
	  
	  
	 
		//模糊查询新闻
		  protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//查询数据并回显
			
			  String title=request.getParameter("title");
				System.out.print(title);
				 List<News> list=service.findByMap(title);
			        if(null == list || list.size() ==0 ){
			            request.setAttribute("msg" ,"无此信息");
			            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
			        }else {
			            request.removeAttribute("msg");
			            request.setAttribute("list" ,list);
			            request.getRequestDispatcher("/WEB-INF/news/list_news.jsp").forward(request, response);
			        }
		    }
	

}
