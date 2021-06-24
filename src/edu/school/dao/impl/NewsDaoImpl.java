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
   
    //保存信息
    public int save(News news) {
        try {
            //执行插入sql
            runner.update("insert into news(title,content,editor,fbsj) values (?,?,?,?)",
            		news.getTitle(),news.getContent(),news.getEditor(),news.getFbsj());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    
    public News query(Integer id) {//根据id查询
        try {//返回查询的信息
            return runner.query("select * from news where id=?", new BeanHandler<News>(News.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   
    public int update(News news) {//更改信息
        try {//执行更改
            runner.update("update news set title=?,content=?,editor=?  where id=?",
            		news.getTitle(),news.getContent(),news.getEditor(),news.getFbsj(),news.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
        return 1;
    }

    //分页查询
    public List<News> getPage(int pageNum, int pageSize) {
        String sql="select * from news limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<News> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<News>(News.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //多条件查询
    public List<News> findByMap(String title) {
        String sql="select * from news where 1=1 ";
        List<News> list=null;
        //todo 使用JavaBean对象的list集合的实现类 BeanListHandler类封装
        List<String> list1 = new ArrayList<String>();
        if (title != "") {
            //如果用户输入的cno不为空，那需要进行字符串拼接
            sql += " and title like  ? ";
            //将用户输入的参数添加到集合
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
            //将long的类型转成int类型
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   
    public int delete(Integer id) {
        try {
            //执行删除的sql
            runner.update("delete from news where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }




	
    
 
	
}
