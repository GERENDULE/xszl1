package edu.school.entity;
//ÐÂÎÅ
public class News {
	
	public News() {
		super();
	}
	public News(int id, String title, String content, String editor, String fbsj) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.editor = editor;
		this.fbsj = fbsj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	private int id;
	private String title;
	private String content;
	private String editor;
	private String fbsj;

	  
	

}
