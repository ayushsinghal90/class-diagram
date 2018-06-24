package application;

public class user {

	private String name;
	private String username;
	private String email;
	private String cno;
	private String password;
	private String path = null;

	public user() {
	}
	
	public user(String path, String name, String username, String email, String cno) {
		super();
		this.path = path;
		this.name = name;
		this.username = username;
		this.email = email;
		this.cno = cno;
	}
	
	public String getpath() {
		return path;
	}
	
	public void setpath(String path) {
		this.path = path;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getusername() {
		return username;
	}
	
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getcno() {
		return cno;
	}

	public void setcno(String cno) {
		this.cno = cno;
	}

	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return name;
	}
}
