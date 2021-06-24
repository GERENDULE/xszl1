package edu.school.service;

import java.util.List;

import edu.school.entity.Document;;

public interface DocumentService {
    public int addDocument(Document document);//������Ϣ
    public Document findByID(Integer id);
    public int updateDocument(Document document);
    public List<Document> getPage(int pageNum, int pageSize);
    public List<Document> findByMap(String title);//������ѯ
    public int queryCount();//ͳ������
    public int deleteDocument(Integer id);//����id����
    public List<Document> findByStuno(String stuno);//������ѯ
   
}
