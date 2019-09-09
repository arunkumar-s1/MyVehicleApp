package com.beanclass;
/*
 * It is bean class for advertisement
 */
public class AddPojo {
	private String name;
	private int id;
	private String kilometer;
	private String user_posted;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKilometer() {
		return kilometer;
	}
	public void setKilometer(String kilometer) {
		this.kilometer = kilometer;
	}
	public String getUser_posted() {
		return user_posted;
	}
	public void setUser_posted(String user_posted) {
		this.user_posted = user_posted;
	}
}
