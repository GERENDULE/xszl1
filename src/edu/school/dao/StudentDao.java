package edu.school.dao;

import java.util.List;

import edu.school.entity.Student;

public interface StudentDao {
    public Student queryByStuno(String stuno);//����ѧ�Ų�ѯ
    public Student queryByStunoAndPwd(String stuno, String pwd);//����ѧ�ź���������¼
    public int save(Student student);//����ѧ����Ϣ
    public Student query(Integer id);
    public int update(Student student);
    public List<Student> getPage(int pageNum, int pageSize);
    public List<Student> findByMap(String stuno,String sname,String sex);//������ѯ��
    public int queryCount();//ͳ������
    public int delete(Integer id);//����id����
    public int updatePwd(Student student);//����id����
}
