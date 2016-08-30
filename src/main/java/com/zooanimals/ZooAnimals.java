package com.zooanimals;

import java.util.Scanner;

public class ZooAnimals {
	
	public static void main(String[] args) {
	
		System.out.println("Welcome to the zoo's information system");
		
		runProgram();	
	}
	
	public static void runProgram() {
		
		Scanner sc = new Scanner(System.in);
		String userMenuInput = null;
		boolean menuCorrect = false;
		
		System.out.println("Please select from the following options:");
		
		do {
			System.out.println("Press 1 to get the information from the system."
					+ "\nPress 2 to add information to the system."
					+ "\nPress 3 to delete information from the system."
					+ "\nPress 4 to update information in the system."
					+ "\nPress 5 to exit the system.");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDatabase();
				System.out.println("");
				runProgram();
			case "2":
				//DAO.writeToDatabase();
				System.out.println("");
				runProgram();
			case "3":
			//	DAO.deleteFromDatabase();
				System.out.println("");
				runProgram();
			case "4":
				//DAO.updateTheDatabase();
				System.out.println("");
				runProgram();
			case "5":
				System.out.println("Thank you for using the system. Goodbye.");
				System.exit(0);
			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
				break;
			}
		} while (menuCorrect);
		
	}
}
