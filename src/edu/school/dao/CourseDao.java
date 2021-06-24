package edu.school.dao;

import edu.school.entity.Course;
import edu.school.entity.Admin;

import java.util.List;

public interface CourseDao {
    public int save(Course record);//������Ϣ
    public Course query(Integer id);//����ID����
    public int update(Course record);//����
    public List<Course> getPage(int pageNum, int pageSize);
    public List<Course> selectAll();//��ѯ���пγ�
    public List<Course> findByMap(String cno,String cname);//������ѯ��
    public int queryCount();//ͳ������
    public int delete(Integer id);//����idɾ��
}
