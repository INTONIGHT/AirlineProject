package models;
import java.sql.Date;
import java.time.*;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	

	public class Reservation {
		//one passenger many reservations
		//this should contain info on the flight ie flight name flight time
		//this will be tied to the user
		private int id;
		private String flightname ;
		private int flightnumber;
		private String flightairplanename;
		private int flightseat;
		private String depatureAirport;
		private String arrivalAirport;
		private String passengerName;
		//this is for storing the date and time
		private Date depatureTime;
		private Date arrivalTime;
		
		//we do actually need an empty reservation to then set things within the reservation
		public Reservation() {
			super();
		}
		
		
		public Reservation(int id, String flightname, int flightnumber, String flightairplanename, int flightseat,
				String depatureAirport, String arrivalAirport, Date depatureTime, Date arrivalTime , String passengerName) {
			super();
			this.id = id;
			this.flightname = flightname;
			this.flightnumber = flightnumber;
			this.flightairplanename = flightairplanename;
			this.flightseat = flightseat;
			this.depatureAirport = depatureAirport;
			this.arrivalAirport = arrivalAirport;
			this.depatureTime = depatureTime;
			this.arrivalTime = arrivalTime;
			this.passengerName = passengerName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFlightname() {
			return flightname;
		}
		public void setFlightname(String flightname) {
			this.flightname = flightname;
		}
		public int getFlightnumber() {
			return flightnumber;
		}
		public void setFlightnumber(int flightnumber) {
			this.flightnumber = flightnumber;
		}
		public String getFlightairplanename() {
			return flightairplanename;
		}
		public void setFlightairplanename(String flightairplanename) {
			this.flightairplanename = flightairplanename;
		}
		public int getFlightseat() {
			return flightseat;
		}
		public void setFlightseat(int flightseat) {
			this.flightseat = flightseat;
		}
		public String getDepatureAirport() {
			return depatureAirport;
		}
		public void setDepatureAirport(String depatureAirport) {
			this.depatureAirport = depatureAirport;
		}
		public String getArrivalAirport() {
			return arrivalAirport;
		}
		public void setArrivalAirport(String arrivalAirport) {
			this.arrivalAirport = arrivalAirport;
		}
		public Date getDepatureTime() {
			return depatureTime;
		}
		public void setDepatureTime(Date depatureTime) {
			this.depatureTime = depatureTime;
		}
		public Date getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(Date arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		@Override
		public int hashCode() {
			return Objects.hash(arrivalAirport, arrivalTime, depatureAirport, depatureTime, flightairplanename, flightname,
					flightnumber, flightseat, id, passengerName);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reservation other = (Reservation) obj;
			return Objects.equals(arrivalAirport, other.arrivalAirport) && Objects.equals(arrivalTime, other.arrivalTime)
					&& Objects.equals(depatureAirport, other.depatureAirport)
					&& Objects.equals(depatureTime, other.depatureTime)
					&& Objects.equals(flightairplanename, other.flightairplanename)
					&& Objects.equals(flightname, other.flightname) && flightnumber == other.flightnumber
					&& flightseat == other.flightseat && id == other.id
					&& Objects.equals(passengerName, other.passengerName);
		}
		
		@Override
		public String toString() {
			return "Reservation [id=" + id + ", flightname=" + flightname + ", flightnumber=" + flightnumber
					+ ", flightairplanename=" + flightairplanename + ", flightseat=" + flightseat + ", depatureAirport="
					+ depatureAirport + ", arrivalAirport=" + arrivalAirport + ", passengerName=" + passengerName
					+ ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime + "]";
		}
		public String getPassengerName() {
			return passengerName;
		}
		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}
		
		
	}
