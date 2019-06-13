package by.jd.matveev.beans;

public class Room {

	public Room(int roomNumber, int roomCapacity, int smoking) {
		super();
		this.roomNumber = roomNumber;
		this.roomCapacity = roomCapacity;
		this.smoking = smoking;
	}
	
	public Room() {
	}

	private int roomId;
	private int roomNumber;
	private int roomCapacity;
	private int smoking;
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNomber) {
		this.roomNumber = roomNomber;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public int getSmoking() {
		return smoking;
	}

	public void setSmoking(int smoking) {
		this.smoking = smoking;
	}

}
