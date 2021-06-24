package edu.school.entity;

//管理员实体
public class Admin {
 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public Admin(Integer id, String username, String password, String nickname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private Integer id;    
    private String username;
    private String password;
    private String nickname;
	
	public Admin() {
		super();
	}
    
}