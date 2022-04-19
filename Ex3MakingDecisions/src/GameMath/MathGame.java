package GameMath;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MathGame {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Be ready for basic MATH GAME!");
		
		System.out.print("Enter an username: ");
	    String userName = sc.nextLine();  // Level 1 get input
	    
	    User newUser = new User(userName);
	    newUser.setUserName(userName);
	    
	    System.out.println("Welcome " + newUser.getUserName() + "!!!");
	    System.out.println("Your point is: " + newUser.getUserPoint());
	    System.out.println("Your level is: " + newUser.getUserLevel());
	    System.out.println("Your title is: " + newUser.getUserTitle());
	    System.out.println("Don't worry! you can change your title after you will be Level-3!"); //Level 5 I am adding a special rule to the game with this part!!!
	    System.out.println("Every 5 Point you win, every Level you step!!!");
	    
	    for (; newUser.getUserLevel() < 5;) {
	    	ArrayList<Integer> arrList = new ArrayList<Integer>();
	    	arrList.add(rand.nextInt(999));
	    	arrList.add(rand.nextInt(999));
	    	
			GameLevel1 newGame = new GameLevel1(arrList, newUser);
			newGame.calculate();
			
		}
	}

}
