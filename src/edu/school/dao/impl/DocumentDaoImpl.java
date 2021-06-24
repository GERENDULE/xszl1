package edu.school.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.school.dao.DocumentDao;
import edu.school.entity.Document;
import edu.school.utils.C3p0Utils;



public class DocumentDaoImpl implements DocumentDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
   
    //保存信息
    public int save(Document document) {
        try {
            //执行插入sql
            runner.update("insert into document(title,fileUrl,scsj,scr,stuno) values (?,?,?,?,?)",
            		document.getTitle(),document.getFileUrl(),document.getScsj(),document.getScr(),document.getStuno());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    
    public Document query(Integer id) {//根据id查询
        try {//返回查询的信息
            return runner.query("select * from document where id=?", new BeanHandler<Document>(Document.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   
    public int update(Document document) {//更改生信息
        try {//执行更改
            runner.update("update document set title=?,fileUrl=?,scr=?,stuno=? where id=?",
            		document.getTitle(),document.getFileUrl(),document.getScr(),document.getStuno(),document.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }
        return 1;
    }

    //分页查询
    public List<Document> getPage(int pageNum, int pageSize) {
        String sql="select * from document limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Document> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Document>(Document.class),new Object[] {startNo,pageSize});//添加实体类的适配器进行类的反射
            return list;
        } catch (SQLException e) {//捕获异常
            throw new RuntimeException(e);//抛出运行异常
        }
    }


   //多条件查询
    public List<Document> findByMap(String title) {
        String sql="select * from document where 1=1 ";
        List<Document> list=null;
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
            list=runner.query(sql, params, new BeanListHandler<Document>(Document.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    
	

 
    public int queryCount() {
        String sql="select count(*) from document";
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
            runner.update("delete from document where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出运行异常
        }

        return 1;//删除成功返回1表示结束
    }


	public List<Document> findByStuno(String stuno) {
		try {
			return runner.query("select * from document where stuno=?", new BeanListHandler<Document>(Document.class),stuno);//添加实体类的适配器进行类的反射
		} catch (SQLException e) {//捕获异常
			throw new RuntimeException(e);//抛出运行异常
		}
	}


	
    
 
	
}
