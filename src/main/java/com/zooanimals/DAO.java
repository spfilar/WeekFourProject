package com.zooanimals;

import java.sql.*;
import java.util.ArrayList;


public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static void connectToDatabase() {
		
		try {
			System.out.println("Attempting to connect to database..");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Successfully connected to database.");
		} catch (SQLException e) {
			System.out.println("Unable to establish connection to database");
			e.printStackTrace();
		}
	}
	
	public static void readFromDatabase() {
		
		connectToDatabase();
		
		ArrayList<Animals> myAnimals = new ArrayList<>();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM `zoo_animals`.`animal_list`;");
			
			while (RES_SET.next()) {
				Animals animalsInDatabase = new Animals();
				
				animalsInDatabase.setAnimalID(RES_SET.getInt("animal_id"));
				animalsInDatabase.setAnimalName(RES_SET.getString("animal_name"));
				animalsInDatabase.setAnimalType(RES_SET.getString("animal_type"));
				animalsInDatabase.setAnimalAge(RES_SET.getInt("animal_age"));
				animalsInDatabase.setAnimalHabitat(RES_SET.getString("animal_habitat"));
				animalsInDatabase.setAnimalFood(RES_SET.getString("animal_food"));
				
				myAnimals.add(animalsInDatabase);
			}
			for (Animals animals : myAnimals) {
				System.out.println(animals.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
