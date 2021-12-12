package ex3MakingDecisions;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MakingDecisions {

	
	//Here I am defining charges class that I will use later in this class
	public static class Charges{
		public double calculatedPriceForHours;
		public boolean isDisabled;
		public double totalCharge;
		public double oneHourPrice;
		public double twoToFourHoursPrice;
		public double fiveToSixHoursPrice;
		public double sevenToEightHoursPrice;
	}

	//My Main Class
	public static void main(String[] args) {
		runForMainClass();
	}
	
	public static void runForMainClass() {
		
		Scanner myInput = new Scanner(System.in);
		
		Charges charges = new Charges();
		charges.calculatedPriceForHours = 0;
		charges.totalCharge = 0;
		charges.isDisabled = false;
		charges.oneHourPrice = 3;
		charges.twoToFourHoursPrice = 4;
		charges.fiveToSixHoursPrice = 4.5;
		charges.sevenToEightHoursPrice = 5.5;
		
		double hoursPrice = 0;
		
		isDisabled(myInput, charges);
		
		if (charges.isDisabled == true) {
			System.out.println("Parking for you is free");
		} else if(charges.isDisabled == false) {
			hoursPrice = calculateHoursPrice(myInput, charges);
			calculateDiscount(myInput, hoursPrice, charges);
			
			if(charges.totalCharge <= 0) {
				System.out.println("Parking for you is free");
			} else {
				System.out.println("The parking charge for you is "+ charges.totalCharge + " pounds.");
			}
			
		} else {
			System.out.println("Incorrect Result! Please Try Again!");
		}
	}
	
	public static boolean isDisabled(Scanner myInput, Charges charges) {
		System.out.println("Are you disabled?");
		String response = myInput.nextLine();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponse = response.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponse.equals("yes")) {
			charges.isDisabled = true;
			return true;
		} else if(ignoredSpacesResponse.equals("no")) {
			return false;
		} else { 
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			isDisabled(myInput, charges);
		}
		
		return charges.isDisabled;
	}

	public static double calculateHoursPrice(Scanner myInput, Charges charges) {
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
			charges.calculatedPriceForHours = charges.oneHourPrice;
			return charges.calculatedPriceForHours;
		} else if(2 <= response && response <= 4) {
			charges.calculatedPriceForHours = charges.twoToFourHoursPrice;
			return charges.calculatedPriceForHours;
		} else if(5 <= response && response <= 6) {
			charges.calculatedPriceForHours = charges.fiveToSixHoursPrice;
			return charges.calculatedPriceForHours;
		} else if(7 <= response && response <= 8) {
			charges.calculatedPriceForHours = charges.sevenToEightHoursPrice;
			return charges.calculatedPriceForHours;
		} else {
			if(flag == false) {
				System.out.println("Please enter an integer between 1 and 8. "
					+ "If the duration of your stay is between two integer numbers, "
					+ "please round your input to the next higher value.");
			} else {
				flag = false;
			}
			
			calculateHoursPrice(myInput, charges);			
		}
		
		return charges.calculatedPriceForHours;
	}
	
	public static double calculateDiscount(Scanner myInput, double hoursPrice, Charges charges) {
		System.out.println("Do you have an \"I live locally badge\"?");
		double response = 0;
		String responseForLocal = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseForLocal = responseForLocal.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseForLocal.equals("yes")) {
			charges.totalCharge = calculateDiscountForOAP(myInput, hoursPrice-1, charges);
			response = charges.totalCharge;
			return response;
		} else if(ignoredSpacesResponseForLocal.equals("no")) {
			charges.totalCharge = calculateDiscountForOAP(myInput, hoursPrice, charges);
			response = charges.totalCharge;
			return response;
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscount(myInput, hoursPrice, charges);
		}
		
		return charges.totalCharge;
	}
	
	public static double calculateDiscountForOAP(Scanner myInput, double hoursPrice, Charges charges) {
		System.out.println("Are you an OAP?");
		String responseForOAL = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseresponseForOAL = responseForOAL.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseresponseForOAL.equals("yes")) {
			charges.totalCharge = hoursPrice - 2;
			return charges.totalCharge;
		} else if(ignoredSpacesResponseresponseForOAL.equals("no")) {
			charges.totalCharge = hoursPrice;
			return charges.totalCharge;
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscountForOAP(myInput, hoursPrice, charges);
		}
		
		return charges.totalCharge;
	}
}
