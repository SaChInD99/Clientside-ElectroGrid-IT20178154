package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Powerstation {
	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogridclient", "root", "");

			// For testing
			System.out.print("Successfully connected");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String readPowerstation() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Station Name</th>" + "<th>Province</th><th>Location</th>"
					+ "<th>Powergenerated</th>";

			String query = "select * from powerstation";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String PowerstationID = Integer.toString(rs.getInt("PowerstationID"));
				String Stationname = rs.getString("Stationname");
				String Province = rs.getString("Province");
				String Location = rs.getString("Location");
				String Powergenerated = Integer.toString(rs.getInt("Powergenerated"));

				// Add into the html table

				output += "<tr><td><input id='hidPowerstationIDUpdate' name='hidPowerstationIDUpdate' type='hidden' value='"
						+ PowerstationID + "'>" + Stationname + "</td>";

				output += "<td>" + Province + "</td>";
				output += "<td>" + Location + "</td>";
				output += "<td>" + Powergenerated + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-PowerstationID='"
						+ PowerstationID + "'>" + "</td></tr>";

			}

			con.close();

			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Powerstation Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Insert appointment
	public String insertPowerstation(String Stationname, String Province, String Location, String Powergenerated) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into powerstation (`PowerstationID`,`Stationname`,`Province`,`Location`,`Powergenerated`)"
					+ " values (?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Stationname);
			preparedStmt.setString(3, Province);
			preparedStmt.setString(4, Location);
			preparedStmt.setString(5, Powergenerated);

			// execute the statement
			preparedStmt.execute();
			con.close();

			// Create JSON Object to show successful msg.
			String newPowerstation = readPowerstation();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerstation + "\"}";
		} catch (Exception e) {
			// Create JSON Object to show Error msg.
			output = "{\"status\":\"error\", \"data\": \"Error while Inserting Powerstation.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

	// Update Customer Details
	public String updatePowerstation(String PowerstationID, String Stationname, String Province, String Location,
			String Powergenerated) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE powerstation SET Stationname=?,Province=?,Location=?,Powergenerated=? WHERE PowerstationID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, Stationname);
			preparedStmt.setString(2, Province);
			preparedStmt.setString(3, Location);
			preparedStmt.setInt(4, Integer.parseInt(Powergenerated));
			preparedStmt.setInt(5, Integer.parseInt(PowerstationID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			// create JSON object to show successful msg
			String newPowerstation = readPowerstation();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerstation + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while Updating Powerstation Details.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deletePowerstation(String PowerstationID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "DELETE FROM powerstation WHERE PowerstationID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(PowerstationID));
			// execute the statement
			preparedStmt.execute();
			con.close();

			// create JSON Object
			String newPowerstation = readPowerstation();
			output = "{\"status\":\"success\", \"data\": \"" + newPowerstation + "\"}";
		} catch (Exception e) {
			// Create JSON object
			output = "{\"status\":\"error\", \"data\": \"Error while Deleting Powerstation.\"}";
			System.err.println(e.getMessage());

		}

		return output;
	}

}
