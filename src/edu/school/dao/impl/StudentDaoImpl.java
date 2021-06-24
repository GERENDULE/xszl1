package edu.school.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.school.dao.StudentDao;
import edu.school.entity.Course;
import edu.school.entity.Student;
import edu.school.utils.C3p0Utils;


public class StudentDaoImpl implements StudentDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDs());
    //����ѧ�Ų�ѯ
    public Student queryByStuno(String stuno) {
        try {//���ز�ѯ����Ϣ
            return runner.query("select * from student where stuno=?", new BeanHandler<Student>(Student.class),stuno);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

    }

  //���ز�ѯ����Ϣ
    public Student queryByStunoAndPwd(String stuno, String pwd) {
        try {
            return runner.query("select * from student where stuno=? and pwd=?", new BeanHandler<Student>(Student.class),stuno,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

    }

    //����ѧ����Ϣ
    public int save(Student student) {
        try {
            //ִ�в���sql
            runner.update("insert into student(stuno,sname,major,sex,bj,grade,pwd) values (?,?,?,?,?,?,?)",
                   student.getStuno(),student.getSname(),student.getMajor(),student.getSex(),student.getBj(),student.getGrade(),student.getPwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    
    public Student query(Integer id) {//����id��ѯ
        try {//���ز�ѯ����Ϣ
            return runner.query("select * from student where id=?", new BeanHandler<Student>(Student.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   
    public int update(Student student) {//����ѧ����Ϣ
        try {//ִ�и���
            runner.update("update student set stuno=?,sname=?,major=?,sex=?,bj=?,grade=?,pwd=? where id=?",
                    student.getStuno(),student.getSname(),student.getMajor(),student.getSex(),student.getBj(),student.getGrade(),student.getPwd(),student.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
        return 1;
    }


    public List<Student> getPage(int pageNum, int pageSize) {
        String sql="select * from student limit ?,?";
        int startNo=(pageNum-1)*pageSize;
        List<Student> list=null;
        try {
            list= runner.query(sql, new BeanListHandler<Student>(Student.class),new Object[] {startNo,pageSize});//���ʵ�����������������ķ���
            return list;
        } catch (SQLException e) {//�����쳣
            throw new RuntimeException(e);//�׳������쳣
        }
    }


   
    //��������ѯѧ��
    public List<Student> findByMap(String stuno,String sname,String sex) {
        String sql="select * from student where 1=1 ";
        List<Student> list=null;
     
        List<String> list1 = new ArrayList<String>();
        if (stuno != "") {
           
            sql += " and stuno like  ? ";
            list1.add("%" + stuno + "%");
        }
        if (sname != "") {
            sql += "and sname like ? ";
            list1.add("%" + sname + "%");
        }
        if (sex != "") {
            sql += "and sex like ? ";
            list1.add("%" + sex + "%");
        }

        Object[] params = list1.toArray();
        try {
            list=runner.query(sql, params, new BeanListHandler<Student>(Student.class));
            System.out.println(list.size());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //ͳ������
    public int queryCount() {
        String sql="select count(*) from student";
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
            runner.update("delete from student where id=?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }

        return 1;//ɾ���ɹ�����1��ʾ����
    }

    
    public int updatePwd(Student student) {
        try {//ִ�и���
            runner.update("update student set pwd=? where stuno=?",
                    student.getPwd(),student.getStuno());
        } catch (SQLException e) {
            throw new RuntimeException(e);//�׳������쳣
        }
        return 1;
    }

	
}
