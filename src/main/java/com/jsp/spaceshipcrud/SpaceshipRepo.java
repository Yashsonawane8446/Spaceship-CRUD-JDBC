package com.jsp.spaceshipcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SpaceshipRepo {
	static Connection conn;
	static Scanner sc = new Scanner(System.in);

	static {

		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Class loaded sucessfully");

			String url = "jdbc:postgresql://localhost:5432/spaceshipcrud";
			String user = "postgres";
			String pass = "tiger";

			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertQuery() {
		String sql = "Insert into spaceship values(?,?,?,?,?,?,?)";
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			System.out.println("how many data you want");
			int data = sc.nextInt();

			for (int i = 0; i < data; i++) {
				System.out.println("Enter shidid :");
				int id = sc.nextInt();
				System.out.println("Enter shipname :");
				String shipname = sc.next();
				System.out.println("Enter fuellevel :");
				double fuellevel = sc.nextDouble();
				System.out.println("Enter crewcount :");
				int crewcount = sc.nextInt();
				System.out.println("Enter missionstatus :");
				String missionstatus = sc.next();
				System.out.println("Enter launchdate :");
				String launchdate = sc.next();
				System.out.println("Enter destination :");
				String destination = sc.next();
				st.setInt(1, id);
				st.setString(2, shipname);
				st.setDouble(3, fuellevel);
				st.setInt(4, crewcount);
				st.setString(5, missionstatus);
				st.setString(6, launchdate);
				st.setString(7, destination);
				st.execute();
			}

			// st.close();

		} catch (SQLException e) {
			System.out.println("Statement not created");
			e.printStackTrace();
		}

	}

	public static void updateQuery() {

		String sql = "UPDATE spaceship set shipname=? where shipid=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			System.out.println("Enter a shipname");
			String shipname = sc.next();
			st.setString(1, shipname);
			System.out.println("Enter a id: ");
			int id = sc.nextInt();
			st.setInt(2, id);

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static void deleteQuery() {
		String sql = "DELETE from spaceship where shipid=?";
		try {

			PreparedStatement sta = conn.prepareStatement(sql);
			System.out.println("Enter your id that need to delete");
			int id = sc.nextInt();
			sta.setInt(1, id);
			sta.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void readQuery() {
		String sql = "Select * from spaceship";

		try {
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int shipid = rs.getInt(1);
				String shipname = rs.getString(2);
				double fuellevel = rs.getDouble(3);
				int crewcount = rs.getInt(4);
				String missionstatus = rs.getString(5);
				String launchdate = rs.getString(6);
				String destination = rs.getString(7);

				System.out.println("shipid = " + shipid);
				System.out.println("shipname = " + shipname);
				System.out.println("fuellevel = " + fuellevel);
				System.out.println("crewcount = " + crewcount);
				System.out.println("missionstatus = " + missionstatus);
				System.out.println("launchdate = " + launchdate);
				System.out.println("destination = " + destination);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
