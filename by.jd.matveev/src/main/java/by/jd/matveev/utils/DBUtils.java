package by.jd.matveev.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.jd.matveev.beans.Client;
import by.jd.matveev.beans.Room;

public class DBUtils {

	public static Client findClient(Connection conn, String userName, String password) throws SQLException {
		String sql = "SELECT name, password, email FROM clients a WHERE name = ? and password = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String email = rs.getString("email");
			Client client = new Client();
			client.setName(userName);
			client.setPassword(password);
			client.setEmail(email);
			return client;
		}
		return null;
	}

	public static Client findClient(Connection conn, String userName) throws SQLException {
		String sql = "SELECT name, password, email FROM clients a WHERE name = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String password = rs.getString("password");
			String email = rs.getString("email");
			Client client = new Client();
			client.setEmail(email);
			client.setPassword(password);
			client.setName(userName);
			return client;
		}
		return null;
	}

	public static List<Room> queryRooms(Connection conn) throws SQLException {
		String sql = "SELECT roomNumber, roomCapacity, smoking FROM rooms";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Room> list = new ArrayList<Room>();
		while (rs.next()) {
			int roomNumber = rs.getInt("roomNumber");
			int roomCapacity = rs.getInt("roomCapacity");
			int smoking = rs.getInt("smoking");
			Room room = new Room();
			room.setRoomCapacity(roomCapacity);
			room.setRoomNumber(roomNumber);
			room.setSmoking(smoking);
			list.add(room);
		}
		return list;
	}

	public static Room findRoom(Connection conn, int roomNumber) throws SQLException {
		String sql = "SELECT a.roomNumber, a.roomCapacity, a.smoking FROM rooms a WHERE a.roomNumber=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, roomNumber);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int roomCapacity = rs.getInt("roomCapacity");
			int smoking = rs.getInt("smoking");
			Room room = new Room();
			room.setRoomNumber(roomNumber);
			room.setSmoking(smoking);
			room.setRoomCapacity(roomCapacity);
			return room;
		}
		return null;
	}
	
	public static void updateRoom (Connection conn, Room room) throws SQLException {
		String sql = "UPDATE rooms SET roomCapacity=?, smoking = ? WHERE roomNumber=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, room.getRoomCapacity());
		pstm.setInt(2, room.getSmoking());
		pstm.setInt(3, room.getRoomNumber());
		pstm.executeUpdate();
	}
	
	public static void insertRoom (Connection conn, Room room) throws SQLException{
		String sql = "INSERT into rooms (roomNumber, roomCapacity, smoking) values (?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, room.getRoomNumber());
		pstm.setInt(2, room.getRoomCapacity());
		pstm.setInt(3, room.getSmoking());
		
		pstm.executeUpdate();
	}
	
	public static void deleteRoom (Connection conn, int roomNumber) throws SQLException{
		String sql ="DELETE from rooms where roomNumber = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, roomNumber);
		
		pstm.executeUpdate();
	}
	
}
