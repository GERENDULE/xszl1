package edu.school.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.school.dao.CourseDao;
import edu.school.entity.Course;
import edu.school.utils.C3p0Utils;

public class CourseDaoImpl implements CourseDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());


    public int save(Course record) {
        try {
            //ִ�в���sql
            runner.update("insert into course(cno,cname,tname,place,weekday,sxw,lesson) values (?,?,?,?,?,?,?)",
            		record.getCno(),record.getCname(),record.getTname(),record.getPlace(),record.getWeekday(),record.getSxw(),record.getLesson());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

  


   //�޸Ŀγ���Ϣ
    public int update(Course record) {
        try {
            //ִ�в���sql
            runner.update("update course set cno=?,cname=?,tname=?,place=?,weekday=?,sxw=?,lesson=? where id=?",
            		record.getCno(),record.getCname(),record.getTname(),record.getPlace(),record.getWeekday(),record.getSxw(),record.getLesson(),record.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;

    }
    
    //��ѯ����
    public List<Course> selectAll() {
		try {
			return runner.query("select * from course", new BeanListHandler<Course>(Course.class));//���ʵ�����������������ķ���
		} catch (SQLException e) {//�����쳣
			throw new RuntimeException(e);//�׳������쳣
		}

	}
    
 
   

    
    //��ҳ��ѯ
    public List<Course> getPage(int pageNum, int pageSize) {
        String sql="select * from course  limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Course> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Course>(Course.class),new Object[] {startNo,pageSize});//���ʵ�����������������ķ���
            return list;
        } catch (SQLException e) {//�����쳣
            throw new RuntimeException(e);//�׳������쳣
        }
    }

    //��������ѯ
    public List<Course> findByMap(String cno,String cname) {
        String sql="select * from course where 1=1 ";
        List<Course> list=null;
        //todo ʹ��JavaBean�����list���ϵ�ʵ���� BeanListHandler���װ
        List<String> list1 = new ArrayList<String>();
        if (cno != "") {
            //����û������cno��Ϊ�գ�����Ҫ�����ַ���ƴ��
            sql += " and cno like  ? ";
            //���û�����Ĳ�����ӵ�����
            list1.add("%" + cno + "%");
        }
        if (cname != "") {
            sql += "and cname like ? ";
            list1.add("%" + cname + "%");
        }

        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Course>(Course.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //ͳ������
    public int queryCount() {
        String sql="select count(*) from course";
        try {
            Long count =  (Long) runner.query(sql, new ScalarHandler());
            //��long������ת��int����
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

   
    //����idɾ��
    public int delete(Integer id) {
        try {
            //ִ��ɾ����sql
            runner.update("delete from course where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

        return 1;//ɾ���ɹ�����1��ʾ����
    }

    //����id��ѯ
	public Course query(Integer id) {
		 try {//���ز�ѯ����Ϣ
	            return runner.query("select * from course where id=?", new BeanHandler<Course>(Course.class),id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);//�׳������쳣
	        }
	}
}
