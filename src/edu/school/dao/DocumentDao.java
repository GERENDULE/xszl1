package edu.school.dao;

import java.util.List;

import edu.school.entity.Document;;

public interface DocumentDao {
    public int save(Document document);//保存信息
    public Document query(Integer id);
    public int update(Document document);
    public List<Document> getPage(int pageNum, int pageSize);
    public List<Document> findByMap(String title);//条件查询
    public int queryCount();//统计数量
    public int delete(Integer id);//根据id数量
    public List<Document> findByStuno(String stuno);//条件查询
   
}
