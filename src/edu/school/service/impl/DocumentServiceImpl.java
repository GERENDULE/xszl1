package edu.school.service.impl;

import java.util.List;

import edu.school.dao.DocumentDao;
import edu.school.dao.impl.DocumentDaoImpl;
import edu.school.entity.Document;
import edu.school.service.DocumentService;

public class DocumentServiceImpl implements DocumentService {
    private DocumentDao dao=new DocumentDaoImpl();

	public int addDocument(Document document) {
		// TODO Auto-generated method stub
		return dao.save(document);
	}

	public Document findByID(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateDocument(Document document) {
		// TODO Auto-generated method stub
		return dao.update(document);
	}

	public List<Document> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Document> findByMap(String title) {
		// TODO Auto-generated method stub
		return dao.findByMap(title);
	}

	public int queryCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteDocument(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	public List<Document> findByStuno(String stuno) {
		// TODO Auto-generated method stub
		return dao.findByStuno(stuno);
	}


}
