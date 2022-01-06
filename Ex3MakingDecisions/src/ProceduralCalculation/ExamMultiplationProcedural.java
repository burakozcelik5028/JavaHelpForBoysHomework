package ProceduralCalculation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExamMultiplationProcedural {

	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		
		int totalMultiplation = 0;
		int correctAnswer = 0;
		int x_Start = 0;
		int x_end = 0;
		int input_response = 0;
		
		Boolean flag = true;
		
		System.out.println("Enter x_start (x_start > 0): ");
		
		while(flag) {
			try {
				x_Start = myInput.nextInt();
				flag = false;
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer value value higher than 0: ");
				myInput.nextLine();
				flag = true;
			}
			
			if(x_Start <= 0 && flag == false) {
				System.out.println("Please enter an integer value higher than 0: ");
				myInput.nextLine();
				flag = true;
			}

		}
		
		flag = true;
		System.out.println("Enter x_end (x_end >= x_start): ");
		
		while(flag) {
			try {
				x_end = myInput.nextInt();
				flag = false;
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer value value higher than x_Start or equal to x_Start: ");
				myInput.nextLine();
				flag = true;
			}
			
			if(x_Start > x_end && flag == false) {
				System.out.println("Please enter an integer value value higher than x_Start or equal to x_Start: ");
				myInput.nextLine();
				flag = true;
			}

		}
		
		totalMultiplation = (x_end - x_Start + 1) * 12;
		flag = true;
		
		for (int i = 1; i <= 12; i++) {
			
			System.out.println("What is " + x_Start + " * " + i + " = ");
			flag = true;
			while(flag) {
				try {
					input_response = myInput.nextInt();
					flag = false;
				} catch (InputMismatchException e) {
					myInput.nextLine();
					flag = false;
				}
				
				if(input_response == (x_Start * i)) {
					correctAnswer = correctAnswer + 1;
					System.out.println("Correct.");
				} else {
					System.out.println("Incorrect.");
				}
			}
			
			if(i == 12 && x_end - x_Start != 0) {
				i = 0;
				x_Start++;
			}
		}
		int calculation = 100/totalMultiplation*correctAnswer;
		
		String grade = "";
		
		if (calculation >= 70) {
			grade = "A";
		} else if (calculation < 70 && calculation >= 60) {
			grade = "B";
		} else if (calculation < 60 && calculation >= 50) {
			grade = "C";
		} else if (calculation < 50 && calculation >= 40) {
			grade = "D";
		} else if (calculation < 40) {
			grade = "F";
		}
		
		
		System.out.println("You scored " +correctAnswer+ "\\"+ totalMultiplation +" ("+calculation +"%) "+grade + " grade.");
		
	}

}
