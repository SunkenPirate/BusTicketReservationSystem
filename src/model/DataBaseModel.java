package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseModel {

    
   public Connection getConnectionToBusDataBase() throws Exception{
	try{
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/busticketreservationsystem";
	    String user = "root";
	    String password = "";
	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url, user, password);
	    return conn;
	}catch(SQLException e){
	    System.out.println("SQLException: " + e.getMessage());
	    System.out.println("SQLState: " + e.getSQLState());
	    System.out.println("Vendor Error: " + e.getErrorCode());
	    return null;
	}
    }

    
    public void createBusTimeTable() throws Exception{
	try{
	    Connection conn = getConnectionToBusDataBase();
	    PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS busTimeTable("
		    + "busId int NOT NULL, "
		    + "busName varchar(255), "
		    + "busType varchar(255), "
		    + "seatsOccupied varchar(255), "
		    + "source varchar(255), "
		    + "timingSource TIME(0), "
		    + "destination varchar(255), "
		    + "timingDestination TIME(0), "
		    + "distance float NOT NULL, "
		    + "PRIMARY KEY(busId))");

	    create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }

   
    public void createTicketTable() throws Exception{
	try{
	    Connection conn = getConnectionToBusDataBase();
	    PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ticketTable("
		    + "ticketNumber BIGINT NOT NULL, "
		    + "source varchar(255), "
		    + "destination varchar(255), "
		    + "date DATE, "
		    + "timing TIME(0), "
		    + "distance float NOT NULL, "
		    + "cost float NOT NULL, "
		    + "busId int NOT NULL, "

	   	+ "seat int NOT NULL, "
	   	+ "passengerName varchar(255), "
	   	+ "mobile varchar(255), "
	   	+ "email varchar(255), "
	   	+ "PRIMARY KEY(ticketNumber))");

	    create.executeUpdate();
	}catch(Exception e){System.out.println(e);}
    }

    
    public void insertNewBus(int busId, String busName, String busType, String seatsOccupied, 
	    String source, String timing, String destination, String timingDestination, double distance) throws Exception{

	Connection conn = getConnectionToBusDataBase();
	PreparedStatement create = conn.prepareStatement("INSERT INTO busTimeTable ("
		+ "busId, "
		+ "busName, "
		+ "busType, "
		+ "seatsOccupied, "
		+ "source, "
		+ "timingSource, "
		+ "destination, "
		+ "timingDestination, "
		+ "distance) "
		+ "values ( "
		+ "'" + busId + "'," 
		+ "'" + busName + "'," 
		+ "'" + busType + "',"
		+ "'" + seatsOccupied + "',"
		+ "'" + source + "',"
		+ "'" + timing + "',"
		+ "'" + destination + "',"
		+ "'" + timingDestination + "',"
		+ "'" + distance + "'" 
		+ ")"); 
	create.executeUpdate();
	
    }

    
    public ResultSet getBusTimeTable() throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM busTimeTable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    
    public ResultSet getAllBusID() throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT busId FROM busTimeTable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    

    public void deleteBusWithID(int id) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("DELETE FROM bustimetable WHERE busId=" + Integer.toString(id));
	create.executeUpdate();
    }

    
    public void updateBusRecord(int busId, String busName, String busType, String seatsOccupied, 
	    String source, String timing, String destination, String timingDestination, double distance) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("UPDATE bustimetable SET "
		+ "busName = ?,"
		+ "busType = ?,"
		+ "seatsOccupied = ?,"
		+ "source = ?,"
		+ "timingSource = ?,"
		+ "destination = ?,"
		+ "timingDestination = ?,"
		+ "distance = ? "
		+ "WHERE busId = ?");
	create.setString(1, busName);
	create.setString(2, busType);
	create.setString(3, seatsOccupied);
	create.setString(4, source);
	create.setString(5, timing);
	create.setString(6, destination);
	create.setString(7, timingDestination);
	create.setString(8, Double.toString(distance));
	create.setString(9, Integer.toString(busId));
	create.executeUpdate();
    }

    
    public ResultSet getBusDetials(String from, String to) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM busTimeTable WHERE source='" + from + "'" + " AND destination='" + to + "'");
	ResultSet rs = create.executeQuery();
	return rs;
    }

    
    public ResultSet getBusWithID(String id) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM busTimeTable WHERE busId=" + Integer.parseInt(id));
	ResultSet rs = create.executeQuery();
	return rs;
    }

    
    public void addNewTicket(String ticketNumber, String source, String destination, String date, String timing, String distance, String cost, String busId,
	    String seat, String passengerName, String mobile, String email) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("INSERT INTO tickettable ("
		+ "ticketNumber, "
		+ "source, "
		+ "destination, "
		+ "date, "
		+ "timing, "
		+ "distance, "
		+ "cost, "
		+ "busId, "
		+ "seat, "
		+ "passengerName, "
		+ "mobile, "
		+ "email) "
		+ "values ( "
		+ "'" + Long.parseLong(ticketNumber) + "',"
		+ "'" + source + "'," 
		+ "'" + destination + "',"
		+ "STR_TO_DATE('" + date +"', '%d/%m/%Y'),"
		+ "'" + timing + "',"
		+ "'" + Float.parseFloat(distance) + "',"
		+ "'" + Float.parseFloat(cost) + "',"
		+ "'" + Integer.parseInt(busId) + "',"
		+ "'" + Integer.parseInt(seat) + "'," 
		+ "'" + passengerName + "'," 
		+ "'" + mobile + "'," 
		+ "'" + email + "'" 
		+ ")"); 
	create.executeUpdate();
    }

    
    public ResultSet getAllTicketNumbers() throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT ticketNumber FROM tickettable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    
    public void updateBusSeats(int busId,  String seatsOccupied) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("UPDATE bustimetable SET "
		+ "seatsOccupied = ?"
		+ "WHERE busId = ?");
	create.setString(1, seatsOccupied);
	create.setInt(2, busId);
	create.executeUpdate();
    }
    
    public ResultSet getTicketTable() throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM tickettable");
	ResultSet rs = create.executeQuery();
	return rs;
    }
    
    
    public void updateTicketRecord(long ticketNumber, String passengerName, String mobile, String email) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("UPDATE ticketTable SET "
		+ "passengerName = ?,"
		+ "mobile = ?,"
		+ "email = ? "
		+ "WHERE ticketNumber = ?");
	create.setString(1, passengerName);
	create.setString(2, mobile);
	create.setString(3, email);
	create.setString(4, Long.toString(ticketNumber));
	create.executeUpdate();
    }
    
    

    public void deleteTicketWithNumber(String ticketNumber) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("DELETE FROM tickettable WHERE ticketNumber=" + ticketNumber);
	create.executeUpdate();
    }
    
    

    public void deleteTicketAssociatedWithBus(String busId) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("DELETE FROM tickettable WHERE busId=" + busId);
	create.executeUpdate();
    }
    
    
    public ResultSet getTicketWithNo(String ticketNumber) throws Exception{
	Connection conn = getConnectionToBusDataBase(); 
	PreparedStatement create = conn.prepareStatement("SELECT * FROM tickettable WHERE ticketNumber=" + ticketNumber);
	ResultSet rs = create.executeQuery();
	return rs;
    }
}