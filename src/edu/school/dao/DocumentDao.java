package edu.school.dao;

import java.util.List;

import edu.school.entity.Document;;

public interface DocumentDao {
    public int save(Document document);//������Ϣ
    public Document query(Integer id);
    public int update(Document document);
    public List<Document> getPage(int pageNum, int pageSize);
    public List<Document> findByMap(String title);//������ѯ��
    public int queryCount();//ͳ������
    public int delete(Integer id);//����id����
    public List<Document> findByStuno(String stuno);//������ѯ
   
}
