package edu.school.entity;

public class Document {

	public Document() {
		super();
	}
	
	private Integer id;//主键
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getScsj() {
		return scsj;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public String getScr() {
		return scr;
	}
	
	public void setScr(String scr) {
		this.scr = scr;
	}

	public Document(Integer id, String title, String fileUrl, String scsj, String stuno, String scr) {
		super();
		this.id = id;
		this.title = title;
		this.fileUrl = fileUrl;
		this.scsj = scsj;
		this.stuno = stuno;
		this.scr = scr;
	}

	private String title;//文件标题
    private String fileUrl;//文件路径
    private String scsj;//上传时间
    public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	private String stuno;//上传人
    private String scr;//上传人
}
