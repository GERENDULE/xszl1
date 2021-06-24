package edu.school.service.impl;

import java.util.List;

import edu.school.dao.NewsDao;
import edu.school.dao.impl.NewsDaoImpl;
import edu.school.entity.News;
import edu.school.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao dao =new NewsDaoImpl();

	public int addNews(News news) {
		// TODO Auto-generated method stub
		return dao.save(news);
	}

	public News findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return dao.update(news);
	}

	public List<News> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<News> findByMap(String title) {
		// TODO Auto-generated method stub
		return dao.findByMap(title);
	}

	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteNews(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	

}
