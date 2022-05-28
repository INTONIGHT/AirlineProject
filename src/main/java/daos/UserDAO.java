package daos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.JDBCConnection;
import models.Reservation;

public class UserDAO {
	private Connection conn = JDBCConnection.getConnection();
	private ReservationDAO rdao = new ReservationDAO();
	
	public boolean createUser(String username,String password,ArrayList<Reservation> reservations) {
		String sql = "insert into users values(default,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setArray(3, (Array) reservations);
			boolean success = ps.execute();
			return success;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//returns the reservations of a user by id
	public ArrayList<Reservation> getReservations(int id){
		//i believe it would look something like this where you get the values
		//I am not entirely sure how well SQL can handle storing arrays
		//assuming that the userid will be the user we want and that
		//the user table will have a one to many relationship with reservations
		String sql = "select * from reservations where user_id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Reservation> reservations = new ArrayList<Reservation>(); 
			while(rs.next()) {
				Reservation r = rdao.getReservation(id);
				reservations.add(r);
				
			}
			//with an actual SQL database I could test this. parts of this are more psuedocode but as an example of what you could do
			return reservations;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * the plan is to have two ways to update a user
	 * The First way will be to let you update the reservations they have by adding a reservation specifically
	 * the second is updating a username or password
	 * 
	 */
	public boolean updateUser(int userid,ArrayList<Reservation> reservations) {
		
		
		return false;
	}
}
