package edu.school.entity;

public class Student {
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public Student(Integer id, String stuno, String sname, String pwd, String major, String sex, String bj,
			String grade) {
		super();
		this.id = id;
		this.stuno = stuno;
		this.sname = sname;
		this.pwd = pwd;
		this.major = major;
		this.sex = sex;
		this.bj = bj;
		this.grade = grade;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBj() {
		return bj;
	}
	public void setBj(String bj) {
		this.bj = bj;
	}
	public Student() {
		super();
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	private Integer id;//����
    private String stuno;//ѧ��
    private String sname;//ѧ������
    private String pwd;//����
    private String major;//רҵ
    private String  sex;//�Ա�
    private String  bj;//�༶
    private String grade;//�꼶

}
