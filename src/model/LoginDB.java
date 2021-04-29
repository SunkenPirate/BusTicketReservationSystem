package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDB {
    private DataBaseModel dbModel;
    public LoginDB(DataBaseModel dbModel) throws Exception{
	this.dbModel = dbModel;
	createLoginTable();
	addNewUser("admin", "admin");
    }
    
    public void createLoginTable() throws Exception{
	try{
	    Connection conn = dbModel.getConnectionToBusDataBase();
	    PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS logintable("
		    + "username varchar(255) NOT NULL, "
		    + "password varchar(255) NOT NULL, "
		    + "PRIMARY KEY(username))");


	    create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }

    
    public void addNewUser(String username, String password) throws Exception{

	Connection conn = dbModel.getConnectionToBusDataBase();
	PreparedStatement create = conn.prepareStatement("INSERT IGNORE INTO logintable ("
		+ "username, "
		+ "password) "
		+ "values ( "
		+ "'" + username + "'," 
		+ "'" + password + "'" 
		+ ")"); 
	create.executeUpdate();
    }

    
    public void deleteUser(String username) throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("DELETE FROM logintable WHERE username='" + username + "'");
	create.executeUpdate();
    }

    
    public ResultSet getUser(String username) throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM logintable WHERE username='" + username+"'");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    

    public ResultSet getAdminTable() throws Exception{
	Connection conn = dbModel.getConnectionToBusDataBase();
	PreparedStatement create = conn.prepareStatement("SELECT * FROM logintable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
}
