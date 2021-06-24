package edu.school.service;

import java.util.List;

import edu.school.entity.Document;;

public interface DocumentService {
    public int addDocument(Document document);//保存信息
    public Document findByID(Integer id);
    public int updateDocument(Document document);
    public List<Document> getPage(int pageNum, int pageSize);
    public List<Document> findByMap(String title);//条件查询
    public int queryCount();//统计数量
    public int deleteDocument(Integer id);//根据id数量
    public List<Document> findByStuno(String stuno);//条件查询
   
}
