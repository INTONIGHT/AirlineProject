package models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
	//should have an id username and password potentially email
	//as well as an array of objects containing flight reservations
	private int id;
	private String username, password;
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	public User() {
		super();
	}
	public User(int id, String username, String password, ArrayList<Reservation> reservations) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.reservations = reservations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, password, reservations, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(reservations, other.reservations) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", reservations=" + reservations
				+ "]";
	}
	
}

