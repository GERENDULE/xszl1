package edu.school.service;

import java.util.List;

import edu.school.entity.News;;

public interface NewsService {
    public int addNews(News news);//保存信息
    public News findById(Integer id);
    public int updateNews(News news);
    public List<News> getPage(int pageNum, int pageSize);
    public List<News> findByMap(String title);//条件查询
    public int queryCount();//统计数量
    public int deleteNews(Integer id);//根据id数量
 
   
}
