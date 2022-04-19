package GameMath;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLevel3 extends Game{ 	//level 2!! from instructions!!! inheritance from Game class
	  									//level 2!! from instructions!!! polymorphism: GameLevel3 is an instance of Game class and is an instance of Object class at the same time
	public GameLevel3(ArrayList<Integer> arrList, User user) {
		super(arrList, user); //inheritance
	}

	@Override
	public boolean calculate() {
		Scanner sc= new Scanner(System.in);

		//to test program fastly use the following line. it will show the answer:
		//System.out.println(arrList.get(0) * arrList.get(1));
		
		if(super.getUser().getUserLevel() == 3) {
			System.out.print("What is the answer: " + arrList.get(1) + " * " + arrList.get(0) +" = ");
			
			//level 3!! from instructions!!! exception handling:
			try {
				int response = sc.nextInt(); // Level 1 get input
				if (response == arrList.get(0) * arrList.get(1)) {
					user.gainPoint();
					return true;
				} else {
					user.lostPoint();
					return false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter integer values!");
			}
			
		}
		return false;
	}

}
