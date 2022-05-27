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
		String passengerName, Date depatureTime, Date arrivalTime) 
{
		String sql = "insert into reservations values(default,?,?,?,?,?,?,?,?);" ;
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, flightname);
		ps.setInt(2, flightnumber);
		ps.setString(3, flightairplanename);
		ps.setInt(4, flightseat);
		ps.setString(5, depatureAirport);
		ps.setString(6, passengerName);
		//hopefully this works as Im not sure if sending a date will work as I intend it to
		ps.setDate(7, depatureTime);
		ps.setDate(8,arrivalTime);
		
		boolean success = ps.execute();
		return success;
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	return false;
	
}
//the id in this case would be the id of the reservation set in the system. 
//unfortunarely all values will be required for now. It would be nice to handle every case of updating but that is beyond scope for now.
//if I where to add something it would be a more dynamic way to allow a user to give any values but there would be quite a few possibilities 
//due to the different fields.
public boolean updateReservation(String flightname, int flightnumber,String flightairplanename, int flightseat, String depatureAirport,
		String passengerName, Date depatureTime, Date arrivalTime,int id) 
{
	String sql = "insert into reservations values(default,?,?,?,?,?,?,?,?) where id = ?;";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, flightname);
		ps.setInt(2, flightnumber);
		ps.setString(3, flightairplanename);
		ps.setInt(4, flightseat);
		ps.setString(5, depatureAirport);
		ps.setString(6, passengerName);
		ps.setDate(7, depatureTime);
		ps.setDate(8,arrivalTime);
		ps.setInt(9, id);
		boolean success = ps.execute();
		return success;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
}
//gets a reservation with id and then fills out the result set and returns the reservation
public Reservation getReservation(int id) {
	String sql = "select * from reservations where id = ?;";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Reservation r = new Reservation();
			r.setId(rs.getInt("id"));
			r.setFlightname(rs.getString("flightname"));
			r.setFlightnumber(rs.getInt("flightnumber"));
			r.setFlightairplanename(rs.getString("flightairplanename"));
			r.setId(rs.getInt("flightseat"));
			r.setDepatureAirport(rs.getString("depatureairport"));
			r.setPassengerName(rs.getString("passengerName"));
			r.setDepatureTime(rs.getDate("depatureTime"));
			r.setArrivalTime(rs.getDate("arrivalTime"));
			return r;
			
			
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;
}
public boolean deleteReservation(int id) {
	String sql = "delete * from reservations where id = ?;";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		boolean success = ps.execute();
		return success;
		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
}
	
}
