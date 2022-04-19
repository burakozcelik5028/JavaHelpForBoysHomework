package GameMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

	public class GameLevel2 extends Game{ 	//inheritance from Game class
											//polymorphism: GameLevel2 is an instance of Game class and is an instance of Object class at the same time
		public GameLevel2(ArrayList<Integer> arrList, User user) {
			super(arrList, user); //inheritance
		}

		@Override
		public boolean calculate() {
			Scanner sc= new Scanner(System.in);
			Collections.sort(arrList);

			//to test program fastly use the following line. it will show the answer:
			//System.out.println(arrList.get(1) - arrList.get(0));
			
			if(super.getUser().getUserLevel() == 2) {
				System.out.print("What is the answer: " + arrList.get(1) + " - " + arrList.get(0) +" = ");
				int response = sc.nextInt(); 
				if (response == arrList.get(1) - arrList.get(0)) {
					user.gainPoint();
					return true;
				} else {
					user.lostPoint();
					return false;
				}
			}
			return false;
		}

}
