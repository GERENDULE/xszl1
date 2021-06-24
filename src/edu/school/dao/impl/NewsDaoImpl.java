package edu.school.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.school.dao.NewsDao;
import edu.school.entity.News;
import edu.school.utils.C3p0Utils;



public class NewsDaoImpl implements NewsDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
   
    //������Ϣ
    public int save(News news) {
        try {
            //ִ�в���sql
            runner.update("insert into news(title,content,editor,fbsj) values (?,?,?,?)",
            		news.getTitle(),news.getContent(),news.getEditor(),news.getFbsj());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    
    public News query(Integer id) {//����id��ѯ
        try {//���ز�ѯ����Ϣ
            return runner.query("select * from news where id=?", new BeanHandler<News>(News.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   
    public int update(News news) {//������Ϣ
        try {//ִ�и���
            runner.update("update news set title=?,content=?,editor=?  where id=?",
            		news.getTitle(),news.getContent(),news.getEditor(),news.getFbsj(),news.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
        return 1;
    }

    //��ҳ��ѯ
    public List<News> getPage(int pageNum, int pageSize) {
        String sql="select * from news limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<News> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<News>(News.class),new Object[] {startNo,pageSize});//���ʵ�����������������ķ���
            return list;
        } catch (SQLException e) {//�����쳣
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   //��������ѯ
    public List<News> findByMap(String title) {
        String sql="select * from news where 1=1 ";
        List<News> list=null;
        //todo ʹ��JavaBean�����list���ϵ�ʵ���� BeanListHandler���װ
        List<String> list1 = new ArrayList<String>();
        if (title != "") {
            //����û������cno��Ϊ�գ�����Ҫ�����ַ���ƴ��
            sql += " and title like  ? ";
            //���û�����Ĳ�����ӵ�����
            list1.add("%" + title + "%");
        }
       
        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<News>(News.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
	

 
    public int queryCount() {
        String sql="select count(*) from news";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //��long������ת��int����
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   
    public int delete(Integer id) {
        try {
            //ִ��ɾ����sql
            runner.update("delete from news where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

        return 1;//ɾ���ɹ�����1��ʾ����
    }




	
    
 
	
}
