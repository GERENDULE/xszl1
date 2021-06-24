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
   
    //������Ϣ
    public int save(Document document) {
        try {
            //ִ�в���sql
            runner.update("insert into document(title,fileUrl,scsj,scr,stuno) values (?,?,?,?,?)",
            		document.getTitle(),document.getFileUrl(),document.getScsj(),document.getScr(),document.getStuno());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    
    public Document query(Integer id) {//����id��ѯ
        try {//���ز�ѯ����Ϣ
            return runner.query("select * from document where id=?", new BeanHandler<Document>(Document.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   
    public int update(Document document) {//��������Ϣ
        try {//ִ�и���
            runner.update("update document set title=?,fileUrl=?,scr=?,stuno=? where id=?",
            		document.getTitle(),document.getFileUrl(),document.getScr(),document.getStuno(),document.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
        return 1;
    }

    //��ҳ��ѯ
    public List<Document> getPage(int pageNum, int pageSize) {
        String sql="select * from document limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Document> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Document>(Document.class),new Object[] {startNo,pageSize});//���ʵ�����������������ķ���
            return list;
        } catch (SQLException e) {//�����쳣
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   //��������ѯ
    public List<Document> findByMap(String title) {
        String sql="select * from document where 1=1 ";
        List<Document> list=null;
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
            runner.update("delete from document where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

        return 1;//ɾ���ɹ�����1��ʾ����
    }


	public List<Document> findByStuno(String stuno) {
		try {
			return runner.query("select * from document where stuno=?", new BeanListHandler<Document>(Document.class),stuno);//���ʵ�����������������ķ���
		} catch (SQLException e) {//�����쳣
			throw new RuntimeException(e);//�׳������쳣
		}
	}


	
    
 
	
}
