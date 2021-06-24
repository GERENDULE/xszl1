package edu.school.service;

import edu.school.entity.Student;

import java.util.List;

public interface StudentService {
    /*
    ע��ѧ��
   */
    public void registerStudent(Student record);
    /*
      ��¼,����null,��ʾ��¼ʧ�ܣ������и�ֵ����ʾ��½�ɹ���
     */
    public Student login(Student record);

    /*
     �ж��û��Ƿ����,����true��ʾѧ���Ѿ����ڣ�����false��ʾ��ѧ�ſ�����
    */
    public boolean existsStuno(String stuno);
    public List<Student> getPage(int pageNum, int pageSize);//��ҳ��ѯ
    public List<Student> findByMap(String stuno,String sname,String sex);//������ѯ
    public int queryCount();//ͳ������
    public int update(Student record);//�޸�
    public int delete(Integer id);//����id����
    public Student queryById(Integer id);//����id��ѯ
    public Student findByStuno(String stuno);
    public int updatePwd(Student user);
}
