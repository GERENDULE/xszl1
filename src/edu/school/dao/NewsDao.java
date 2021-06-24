package edu.school.dao;

import java.util.List;

import edu.school.entity.News;;
//新闻接口
public interface NewsDao {
    public int save(News news);//������Ϣ
    public News query(Integer id);
    public int update(News news);
    public List<News> getPage(int pageNum, int pageSize);
    public List<News> findByMap(String title);//������ѯ
    public int queryCount();//ͳ������
    public int delete(Integer id);//����id����
 
   
}
