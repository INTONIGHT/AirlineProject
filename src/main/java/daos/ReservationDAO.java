package daos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

import connection.JDBCConnection;
import models.Reservation;

public class ReservationDAO {
private Connection conn = JDBCConnection.getConnection();
//will want to do CRUD operations here which are Create read Update and Delete reservations
public boolean createReservation(String flightname, int flightnumber,String flightairplanename, int flightseat, String depatureAirport,
		String passengerName, Clock depatureTime, Clock arrivalTime) {
	String sql = "insert into reservations values(default,?,?,?,?,?,?,?,?);" ;
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, flightname);
		ps.setInt(2, flightnumber);
		ps.setString(3, flightairplanename);
		ps.setInt(4, flightseat);
		ps.setString(5, depatureAirport);
		ps.setString(6, passengerName);
		//error here not sure how to send a clock object
		ps.setDate(7, (Date)depatureTime);
		
		boolean success = ps.execute();
		return success;
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	return false;
	
}
	
	
}
