package daos;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.JDBCConnection;
import models.Reservation;

public class UserDAO {
	private Connection conn = JDBCConnection.getConnection();
	
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
	
	/**
	 * the plan is to have two ways to update a user
	 * The First way will be to let you update the reservations they have
	 * the second is updating a username or password
	 * 
	 */
	public boolean updateUser()
}
