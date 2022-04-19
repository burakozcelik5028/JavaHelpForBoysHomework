package GameMath;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLevel1 extends Game{ 	//inheritance from Game class
									  	//polymorphism: GameLevel1 is an instance of Game class and is an instance of Object class at the same time
	public GameLevel1(ArrayList<Integer> arrList, User user) {
		super(arrList, user); //inheritance
	}
	
	@Override
	public boolean calculate() {
		Scanner sc= new Scanner(System.in);
		
		//to test program fastly use the following line. it will show the answer:
		//System.out.println(arrList.get(0) + arrList.get(1));
		
		if(super.getUser().getUserLevel() == 1) {
			System.out.print("What is the answer: " + arrList.get(1) + " + " + arrList.get(0) +" = ");
			int response = sc.nextInt(); 
			if (response == arrList.get(0) + arrList.get(1)) {
				user.gainPoint();
				return true;
			} else {
				user.lostPoint();
				return false;
			}
			
		} else if(super.getUser().getUserLevel() == 2) {
			GameLevel2 level2Game = new GameLevel2(arrList, user);
			level2Game.calculate();
		} else if(super.getUser().getUserLevel() == 3) {
			GameLevel3 level3Game = new GameLevel3(arrList, user);
			level3Game.calculate();
		} else if(super.getUser().getUserLevel() == 4) {
			GameLevel4 level4Game = new GameLevel4(arrList, user);
			level4Game.calculate();
		} else if(super.getUser().getUserLevel() > 4) {
			System.out.println("Tebrikler!!! Oyunu Başarı ile tamamladınız!!!");
		}
		return false;
	}

}