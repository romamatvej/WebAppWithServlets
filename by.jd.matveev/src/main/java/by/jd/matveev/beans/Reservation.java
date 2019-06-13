package by.jd.matveev.beans;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reservation {

	private int reservationId;
	private Calendar moveInDay;
	private Calendar moveOutDay;
	private int roomId;
	private int clientId;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Calendar getMoveInDay() {
		return moveInDay;
	}
	public void setMoveInDay(int year, int month, int day) {
		this.moveInDay = new GregorianCalendar(year, month, day);
	}
	public Calendar getMoveOutDay() {
		return moveOutDay;
	}
	public void setMoveOutDay(int year, int month, int day) {
		this.moveOutDay = new GregorianCalendar(year, month, day);
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
}
