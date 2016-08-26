package com.zooanimals;

import java.util.Scanner;

public class ZooAnimals {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String userMenuInput = null;
		boolean menuCorrect = false;
		
		System.out.println("Welcome to the zoo's information system!"
				+ "\nPlease select from the following options:");
		
		do {
			System.out.println("Press 1 to get the information from the system."
					+ "\nPress 2 to add information to the system.");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDatabase();
				break;
			case "2":
				DAO.writeToDatabase();
				break;
			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
	}
}
