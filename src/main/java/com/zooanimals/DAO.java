package com.zooanimals;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	static Scanner sc = new Scanner(System.in);
	
	public static void connectToDatabase() {
		
		try {
			
			Class.forName(JDBC_DRIVER);
			
			System.out.println("Attempting to connect to database..");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Successfully connected to database.");
			
		} catch (SQLException | ClassNotFoundException e) {
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
	
	public static void writeToDatabase(Animals animal) {
		
		Animals animalToAdd = new Animals();
		
		animalToAdd = animal;
		
		try {
			
			connectToDatabase();			
			
			PREP_STMT = CONN.prepareStatement("INSERT INTO `zoo_animals`.`animal_list`"
					+ "(animal_name, animal_type, animal_age, animal_habitat, animal_food)"
					+ " VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			PREP_STMT.setString(1, animalToAdd.getAnimalName());
			PREP_STMT.setString(2, animalToAdd.getAnimalType());
			PREP_STMT.setInt(3, animalToAdd.getAnimalAge());
			PREP_STMT.setString(4, animalToAdd.getAnimalHabitat());
			PREP_STMT.setString(5, animalToAdd.getAnimalFood());
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFromDatabase(Animals animal) {
		
		Animals animalToDelete = new Animals();
		
		animalToDelete = animal;
		
	/*	readFromDatabase();
		
		System.out.println("What is the ID# of the animal you'd like to delete?");
		
		String id = sc.nextLine();
		*/
		try {
			
			connectToDatabase();
			
			PREP_STMT = CONN.prepareStatement("DELETE FROM `zoo_animals`.`animal_list` WHERE animal_id = ?");
			PREP_STMT.setInt(1, animalToDelete.getAnimalID());
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTheDatabase(Animals animal) {
		
		System.out.println("What is the ID# of the animal you'd like to update?");
		
		//int idNumber = Integer.parseInt(sc.nextLine());
		
		Animals animalToUpdate = new Animals();
		
		animalToUpdate = animal;
		
		try {
			
			connectToDatabase();
			
			PREP_STMT = CONN.prepareStatement("UPDATE `zoo_animals`.`animal_list` SET"
					+ " `animal_name` = ?, `animal_type` = ?, `animal_age` = ?, `animal_habitat` = ?,"
					+ " `animal_food` = ? WHERE `animal_id` = ?;");
			PREP_STMT.setString(1, animalToUpdate.getAnimalName());
			PREP_STMT.setString(2, animalToUpdate.getAnimalType());
			PREP_STMT.setInt(3, animalToUpdate.getAnimalAge());
			PREP_STMT.setString(4, animalToUpdate.getAnimalHabitat());
			PREP_STMT.setString(5, animalToUpdate.getAnimalFood());
			PREP_STMT.setInt(6, animalToUpdate.getAnimalID());
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
		
	public static Animals addAllTheAnimals() {
		
		Animals animalToAdd = new Animals();
		
		System.out.println("What is the animal's name?");
		animalToAdd.setAnimalName(sc.nextLine());
		
		System.out.println("What is the animal's type?");
		animalToAdd.setAnimalType(sc.nextLine());
		
		System.out.println("What is the animal's age?");
		animalToAdd.setAnimalAge(Integer.parseInt(sc.nextLine()));
		
		System.out.println("What is animal's normal habitat?");
		animalToAdd.setAnimalHabitat(sc.nextLine());
		
		System.out.println("What is the animal's food type? (e.g. carnivore)");
		animalToAdd.setAnimalFood(sc.nextLine());
		
		return animalToAdd;		
	}
}
