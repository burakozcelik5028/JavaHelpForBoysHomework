package ex3MakingDecisions;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MakingDecisions {

	//My Main Class
	public static void main(String[] args) {
		runForMainClass();
	}
	
	public static void runForMainClass() {
		
		Scanner myInput = new Scanner(System.in);
		HashMap<String, Double> charges = new HashMap<String, Double>();
		charges.put("calculatedPriceForHours", (double) 0);
		charges.put("totalCharge", (double) 0);
		charges.put("oneHourPrice", (double) 3);
		charges.put("twoToFourHoursPrice", (double) 4);
		charges.put("fiveToSixHoursPrice", 4.5);
		charges.put("sevenToEightHoursPrice", 5.5);
		
		HashMap<String, Boolean> isDisabled = new HashMap<String, Boolean>();
		isDisabled.put("isDisabled", false);
		
		double hoursPrice = 0;
		
		isDisabled(myInput, charges, isDisabled);
		
		if (isDisabled.get("isDisabled") == true) {
			System.out.println("Parking for you is free");
		} else if(isDisabled.get("isDisabled") == false) {
			hoursPrice = calculateHoursPrice(myInput, charges);
			calculateDiscount(myInput, hoursPrice, charges);
			
			if(charges.get("totalCharge") <= 0) {
				System.out.println("Parking for you is free");
			} else {
				System.out.println("The parking charge for you is "+ charges.get("totalCharge") + " pounds.");
			}
			
		} else {
			System.out.println("Incorrect Result! Please Try Again!");
		}
	}
	
	public static boolean isDisabled(Scanner myInput, HashMap<String, Double> charges, HashMap<String, Boolean> isDisabled) {
		System.out.println("Are you disabled?");
		String response = myInput.nextLine();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponse = response.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponse.equals("yes")) {
			isDisabled.put("isDisabled", true);
			return true;
		} else if(ignoredSpacesResponse.equals("no")) {
			return false;
		} else { 
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			isDisabled(myInput, charges, isDisabled);
		}
		
		return isDisabled.get("isDisabled");
	}

	public static double calculateHoursPrice(Scanner myInput, HashMap<String, Double> charges) {
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
			charges.put("calculatedPriceForHours", charges.get("oneHourPrice"));
			return charges.get("calculatedPriceForHours");
		} else if(2 <= response && response <= 4) {
			charges.put("calculatedPriceForHours", charges.get("twoToFourHoursPrice"));
			return charges.get("calculatedPriceForHours");
		} else if(5 <= response && response <= 6) {
			charges.put("calculatedPriceForHours", charges.get("fiveToSixHoursPrice"));
			return charges.get("calculatedPriceForHours");
		} else if(7 <= response && response <= 8) {
			charges.put("calculatedPriceForHours", charges.get("sevenToEightHoursPrice"));
			return charges.get("calculatedPriceForHours");
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
		
		return charges.get("calculatedPriceForHours");
	}
	
	public static double calculateDiscount(Scanner myInput, double hoursPrice, HashMap<String, Double> charges) {
		System.out.println("Do you have an \"I live locally badge\"?");
		double response = 0;
		String responseForLocal = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseForLocal = responseForLocal.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseForLocal.equals("yes")) {
			charges.put("totalCharge", calculateDiscountForOAP(myInput, hoursPrice-1, charges));
			response = charges.get("totalCharge");
			return response;
		} else if(ignoredSpacesResponseForLocal.equals("no")) {
			charges.put("totalCharge", calculateDiscountForOAP(myInput, hoursPrice, charges));
			response = charges.get("totalCharge");
			return response;
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscount(myInput, hoursPrice, charges);
		}
		
		return charges.get("totalCharge");
	}
	
	public static double calculateDiscountForOAP(Scanner myInput, double hoursPrice, HashMap<String, Double> charges) {
		System.out.println("Are you an OAP?");
		String responseForOAL = myInput.next();
		
		// Here I am deleting all spaces with using java regex method from user response AND 
		// I am changing response to lower case characters. 
		String ignoredSpacesResponseresponseForOAL = responseForOAL.toLowerCase().replaceAll("\\s", "");
		
		if(ignoredSpacesResponseresponseForOAL.equals("yes")) {
			charges.put("totalCharge", hoursPrice - 2);
			return charges.get("totalCharge");
		} else if(ignoredSpacesResponseresponseForOAL.equals("no")) {
			charges.put("totalCharge", hoursPrice);
			return charges.get("totalCharge");
		} else {
			// Here I am handling if someone write different answer to the question
			System.out.println("Please, Only Answer \"yes\" or \"no\"");
			calculateDiscountForOAP(myInput, hoursPrice, charges);
		}
		
		return charges.get("totalCharge");
	}
}
