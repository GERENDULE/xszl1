package edu.school.dao;

import java.util.List;

import edu.school.entity.News;;
//鏂伴椈鎺ュ彛
public interface NewsDao {
    public int save(News news);//保存信息
    public News query(Integer id);
    public int update(News news);
    public List<News> getPage(int pageNum, int pageSize);
    public List<News> findByMap(String title);//条件查询
    public int queryCount();//统计数量
    public int delete(Integer id);//根据id数量
 
   
}
