package edu.school.service;

import java.util.List;

import edu.school.entity.News;;

public interface NewsService {
    public int addNews(News news);//������Ϣ
    public News findById(Integer id);
    public int updateNews(News news);
    public List<News> getPage(int pageNum, int pageSize);
    public List<News> findByMap(String title);//������ѯ
    public int queryCount();//ͳ������
    public int deleteNews(Integer id);//����id����
 
   
}
