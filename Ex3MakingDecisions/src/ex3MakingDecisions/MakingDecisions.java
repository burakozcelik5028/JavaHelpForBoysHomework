package ex3MakingDecisions;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MakingDecisions {

	//Here I am defining global charges
	public static class Charges{
		public static double calculatedPriceForHours;
		public static boolean isDisabled = false;
		public static double totalCharge;
		public static double oneHourPrice = 3;
		public static double twoToFourHoursPrice = 4;
		public static double fiveToSixHoursPrice = 4.5;
		public static double sevenToEightHoursPrice = 5.5;
	}

	//My Main Class
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		double hoursPrice = 0;
		
		isDisabled(myInput);
		
		if (Charges.isDisabled == true) {
			System.out.println("Parking for you is free");
		} else if(Charges.isDisabled == false) {
			hoursPrice = calculateHoursPrice(myInput);
			calculateDiscount(myInput, hoursPrice);
			
			if(Charges.totalCharge <= 0) {
				System.out.println("Parking for you is free");
			} else {
				System.out.println("The parking charge for you is "+ Charges.totalCharge + " pounds.");
			}
			
		} else {
			System.out.println("Incorrect Result! Please Try Again!");
		}
		
	}
	
	
	public static boolean isDisabled(Scanner myInput) {
		System.out.println("Are you disabled?");
		String response = myInput.nextLine();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponse = response.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponse.equals("yes")) {
			Charges.isDisabled = true;
			return true;
		} else if(ignoredSpacesResponse.equals("no")) {
			return false;
		} else { 
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			isDisabled(myInput);
		}
		
		return Charges.isDisabled;
	}

	public static double calculateHoursPrice(Scanner myInput) {
		int response = 0;
		boolean flag = false;
		
		System.out.println("How many hours do you wish to park (1-8)?");
		
		try {
			response = myInput.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter an integer between 1 and 8. "
					+ "\nIf the duration of your stay is between two integer numbers, "
					+ "\nplease round your input to the next higher value.");
			myInput.nextLine();
			flag = true;
		}
		
		if (response == 1) {
			Charges.calculatedPriceForHours = Charges.oneHourPrice;
			return Charges.calculatedPriceForHours;
		} else if(2 <= response && response <= 4) {
			Charges.calculatedPriceForHours = Charges.twoToFourHoursPrice;
			return Charges.calculatedPriceForHours;
		} else if(5 <= response && response <= 6) {
			Charges.calculatedPriceForHours = Charges.fiveToSixHoursPrice;
			return Charges.calculatedPriceForHours;
		} else if(7 <= response && response <= 8) {
			Charges.calculatedPriceForHours = Charges.sevenToEightHoursPrice;
			return Charges.calculatedPriceForHours;
		} else {
			if(flag == false) {
				System.out.println("Please enter an integer between 1 and 8. "
					+ "If the duration of your stay is between two integer numbers, "
					+ "please round your input to the next higher value.");
			} else {
				flag = false;
			}
			
			calculateHoursPrice(myInput);			
		}
		
		return Charges.calculatedPriceForHours;
	}
	
	public static double calculateDiscount(Scanner myInput, double hoursPrice) {
		System.out.println("Do you have an \"I live locally badge\"?");
		double response = 0;
		String responseForLocal = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseForLocal = responseForLocal.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseForLocal.equals("yes")) {
			Charges.totalCharge = calculateDiscountForOAP(myInput, hoursPrice-1);
			response = Charges.totalCharge;
			return response;
		} else if(ignoredSpacesResponseForLocal.equals("no")) {
			Charges.totalCharge = calculateDiscountForOAP(myInput, hoursPrice);
			response = Charges.totalCharge;
			return response;
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscount(myInput, hoursPrice);
		}
		
		return Charges.totalCharge;
	}
	
	public static double calculateDiscountForOAP(Scanner myInput, double hoursPrice) {
		System.out.println("Are you an OAP?");
		String responseForOAL = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseresponseForOAL = responseForOAL.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseresponseForOAL.equals("yes")) {
			Charges.totalCharge = hoursPrice - 2;
			return Charges.totalCharge;
		} else if(ignoredSpacesResponseresponseForOAL.equals("no")) {
			Charges.totalCharge = hoursPrice;
			return Charges.totalCharge;
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscountForOAP(myInput, hoursPrice);
		}
		
		return Charges.totalCharge;
	}
}
