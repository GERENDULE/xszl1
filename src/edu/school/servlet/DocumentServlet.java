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

import edu.school.entity.Document;
import edu.school.service.DocumentService;
import edu.school.service.impl.DocumentServiceImpl;
import edu.school.utils.WebUtils;


/**
 * Servlet implementation class DocumentServlet
 */

public class DocumentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	DocumentService service= new DocumentServiceImpl();
	
	//��ת���ϴ��ļ��Ľ���
	 protected void toAddDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ת������û�����
	    request.getRequestDispatcher("/WEB-INF/document/add_document.jsp").forward(request,response);
	 }
	 
	 
	 
		 
	//�ϴ��ļ�
	  protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			  request.setCharacterEncoding("utf-8");
			 
			  Date date = new Date();
			  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String createTime = simpleDateFormat.format(date);
			  Document document = fileUpload(request);
			  document.setScsj(createTime);
		
			  service.addDocument(document);
			  response.sendRedirect(request.getContextPath() + "/DocumentServlet?action=list");
		  } catch (Exception e) {
			  e.printStackTrace();

		  }
		  return;
	  }
	

	private Document fileUpload(HttpServletRequest request) {

		Document document=new Document();
		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					BeanUtils.setProperty(document, name, value);
					System.out.println(name);
				}else{
					String filename = item.getName();
				/*	String savefilename = makeFileName(filename);*/
					String savepath="D:\\Program Files\\eclipse_workspace\\xszl\\WebContent\\upload\\";
					//String savepath= this.getServletContext().getRealPath("/upload");//Tomcat����·��*/
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savepath + "\\" + filename);
					int len = 0;
					byte buffer[] = new byte[1024];
					while((len = in.read(buffer)) > 0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					document.setTitle(filename);
					document.setFileUrl(savepath);

					System.out.println(document.getFileUrl()+savepath);
				}
			}
			return document;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}


	//�����ļ�
	  protected void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // TODO Auto-generated method stub
		  //����ContentType�ֶ�ֵ
		 
		  File downLoadFileDir = new File("D:\\Program Files\\eclipse_workspace\\xszl\\WebContent\\upload\\");
		  String aFileName=null;//Ҫ���ص��ļ���
		  FileInputStream in=null;
		  ServletOutputStream out=null;
		  request.setCharacterEncoding("utf-8");
		  try{
			  aFileName=request.getParameter("resPath");
			  response.setHeader("Content-Type","application/x-msdownload");//���������ļ�ʹ�õı�ͷ
			  response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(aFileName,"utf-8"));
			  in=new FileInputStream(downLoadFileDir+File.separator+aFileName);//�����ļ�
			  out=response.getOutputStream();//�õ������,������ͻ����������������
			  out.flush();
			  int aRead=0;
			  byte b[]=new byte[1024];
			  while((aRead=in.read(b))!=-1 && in!=null){
				  out.write(b,0,aRead);}
			  out.flush();
			  in.close();
			  out.close();
		  }catch(Throwable e){
			  e.printStackTrace();
		  }
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
	        List<Document> bList=service.getPage(pageNum,pageSize);
	        //Я��������ҳ��
	        request.setAttribute("documentList",bList); //�󶨲���
	        int nums=service.queryCount(); //��ѯ����
	        //������ҳ��
	        int totalPage=(nums%pageSize==0)? (nums/pageSize):(nums/pageSize+1);
	        request.setAttribute("cp",pageNum); //��ǰҳ
	        request.setAttribute("tp",totalPage); //��ҳ��

	        //���� ֵ1��ֵ2
	        request.getRequestDispatcher("/WEB-INF/document/document_list.jsp").forward(request,response); //ҳ��ת��

	    }

	  
	  //ɾ���ļ�
	  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	        service.deleteDocument(id);
	        response.sendRedirect(request.getContextPath()+"/DocumentServlet?action=list");
	    }
	  
	
	  //������
	  protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����
		  int id=WebUtils.parseInt(request.getParameter("id"),0);
	         Document record=service.findByID(id);
	         request.setAttribute("record",record);
	         request.getRequestDispatcher("/WEB-INF/document/edit_document.jsp").forward(request,response);
	    }

	  //�޸�
	 protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 request.setCharacterEncoding("utf-8");
			
			
			
			 Document document = fileUpload(request);
			
			
			 service.updateDocument(document);
			 response.sendRedirect(request.getContextPath() + "/DocumentServlet?action=list");
		 } catch (Exception e) {
			 e.printStackTrace();

		 }
		 return;
		

	    }

		//ģ����ѯѧϰ����
		  protected void findByMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����			
			  String title=request.getParameter("title");
				System.out.print(title);
				 List<Document> list=service.findByMap(title);
			        if(null == list || list.size() ==0 ){
			            request.setAttribute("msg" ,"�޴���Ϣ");
			            request.getRequestDispatcher("/WEB-INF/document/list_document.jsp").forward(request, response);
			        }else {
			            request.removeAttribute("msg");
			            request.setAttribute("list" ,list);
			            request.getRequestDispatcher("/WEB-INF/document/list_document.jsp").forward(request, response);
			        }
		    }		  
		  //�Ѿ��ϴ���ѧ������
		  protected void YList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//��ѯ���ݲ�����				
			  String stuno=request.getParameter("stuno");				
				 List<Document> list=service.findByStuno(stuno);
			        if(null == list || list.size() ==0 ){
			            request.setAttribute("msg" ,"�����ϴ���ѧ������");
			            request.getRequestDispatcher("/WEB-INF/document/my_document.jsp").forward(request, response);
			        }else {
			            request.removeAttribute("msg");
			            request.setAttribute("list" ,list);
			            request.getRequestDispatcher("/WEB-INF/document/my_document.jsp").forward(request, response);
			        }
		    }
		  
	

}
