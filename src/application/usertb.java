package application;

import java.sql.*;

public class usertb {
 
	public Connection com;
	String encPasDb;
	private PreparedStatement myStmt = null;
	public usertb() {
		try {
   	   com= DriverManager.getConnection("jdbc:mysql://localhost:3306/classdiagram","root","");
        }
		catch(Exception e) {
			
		}
	}
	
	public void addUser(user theUser) {
		try {
			// prepare statement
			myStmt = com.prepareStatement("insert into userinfo"
					+ " (name, username, email, contno, password)"
					+ " values (?, ?, ?, ?, ?)");
			
			myStmt.setString(1, theUser.getname());
			myStmt.setString(2, theUser.getusername());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setString(4, theUser.getcno());
			
			String encPas = PasswordUtils.encPas(theUser.getpassword());
			myStmt.setString(5, encPas);
			
			myStmt.executeUpdate();		
			myStmt = null;
		}
		catch(Exception e) {
		}
		
	}
	public boolean chexuser(user theuser){
		Boolean check = false;
		try {
		String s= "SELECT * from userinfo WHERE username =?";
		myStmt = com.prepareStatement(s);
		myStmt.setString(1, theuser.getusername());
		ResultSet rs=myStmt.executeQuery();
		if(rs.next()) {
		     check = true;
		     encPasDb = rs.getString("password");
		     if(rs.getString("path")!=null)
		     theuser.setpath(rs.getString("path"));
		     
		}
		}
		catch(Exception e) {
		}
	    return check;
	}
	public boolean chexcno(user theuser){
		Boolean check = false;
		try {
		String s= "SELECT * from userinfo WHERE contno =?";
		myStmt = com.prepareStatement(s);
		myStmt.setString(1, theuser.getcno());
		ResultSet rs=myStmt.executeQuery();
		if(rs.next()) {
		     check = true;
		}
		}
		catch(Exception e) {
		}
		return check;
	}
	public boolean authenticate(user theUser) {
		boolean result = false;
		try {
		String plainTextPassword = theUser.getpassword();
		result = PasswordUtils.checkPassword(plainTextPassword, encPasDb);
		}
		catch(Exception e)
		{}
		return result;
	}
	public void updpth(user u)
	{
		try {
		myStmt = com.prepareStatement("UPDATE userinfo SET path =? WHERE username =?");
		
		myStmt.setString(1, u.getpath());
		myStmt.setString(2, u.getusername());
		myStmt.executeUpdate();		
		myStmt = null;
	}
		catch(Exception e) {}
	}
	public void getall(user u)
	{
		try {
			String s= "SELECT * from userinfo WHERE username =?";
			myStmt = com.prepareStatement(s);
			myStmt.setString(1, u.getusername());
			
			
		}
		catch(Exception e) {}
	}
	
}
