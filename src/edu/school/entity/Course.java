package edu.school.entity;

import java.util.HashSet;
import java.util.Set;

public class Course {
   
	private Integer id;
	private String cno;//�γ̱��
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public Course(Integer id, String cno, String cname, String tname, String place, String weekday, String sxw,
			String lesson) {
		super();
		this.id = id;
		this.cno = cno;
		this.cname = cname;
		this.tname = tname;
		this.place = place;
		this.weekday = weekday;
		this.sxw = sxw;
		this.lesson = lesson;
	
	}
	public String getSxw() {
		return sxw;
	}
	public void setSxw(String sxw) {
		this.sxw = sxw;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	
	private String cname;//�γ�����
    private String tname;//��ʦ
    private String place;//�ڿεص�
    private String weekday;//���ڼ�
    private String sxw;//����/����/����
    private String lesson;//�ڼ���
	
    public Course() {
    }

}
