package edu.school.service;

import edu.school.entity.Course;

import java.util.List;

public interface CourseService {

    public int addCourse(Course record);//����γ���Ϣ
    public Course queryById(Integer id);//����id����
    public int update(Course record);//����
    public List<Course> getPage(int pageNum, int pageSize);
    public List<Course> findByMap(String cno,String cname);//������ѯ
    public List<Course> selectAll();//��ѯ���пγ�
    public int queryCount();//ͳ������
    public int deleteById(Integer id);//����idɾ��
}
