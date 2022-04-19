package GameMath;

import java.util.Scanner;

public class User implements UserInterface{	
	//level 2 Polymorphism: User class is instance of Object class. 
	//level 2 using interfaces
	
		private String userName;
		private String userTitle;
		private int userPoint;
		private int userLevel;
		
		public User(String userName) {
			this.userName = userName;
			this.userTitle = "FISH";
			this.userPoint = 0;
			this.userLevel = 1;
		}
		
		@Override
		public void changeTitle(String newTitle) {
			this.setUserTitle(newTitle);
		}
		
		@Override
		public void gainPoint() {
			Scanner sc= new Scanner(System.in);
			this.userPoint = this.userPoint + 1;
			if(this.userPoint % 5 == 0) {
				this.userLevel = this.userPoint/5+1;
				System.out.println("Congrats!!! " + this.userTitle +" You are on new Level!!! Level-" + this.userLevel);
			}
			
			System.out.println("Your final points: " + this.userPoint);
			
			if(this.userPoint == 20) {
				System.out.println("You Succesfully Complete The Game!");
			}
			
			//Level 5 I am adding a special rule to the game with this part!!!
			if(this.userPoint < 20 && this.userPoint > 9) {
				System.out.print("You level higher than Level-2. Do you wanna change your Title? Yes or No:");
				String answerr = sc.nextLine(); // Level 1 get input
				if(answerr.toLowerCase().equals("yes")) {
					System.out.print("Please enter your new title: ");
					String newTitle = sc.nextLine(); // Level 1 get input
					this.changeTitle(newTitle);
				} 
			}
			
		}
		
		@Override
		public void lostPoint() {
			this.userPoint = this.userPoint - 1;
			if(this.userPoint % 5 == 4) {
				this.userLevel = this.userPoint/5+1;
				System.out.println("Unfortunatelly you lost level...!!! " + this.userTitle +"  Level-" + this.userLevel);
			}
			System.out.println("Your final points: " + this.userPoint);
		}
		
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserTitle() {
			return userTitle;
		}

		private void setUserTitle(String userTitle) {
			if(this.userLevel >=2) {
				
				this.userTitle = userTitle;
			} else {
				System.out.println("You should be at least Level-2 to change your title!");
			}
		}

		public int getUserPoint() {
			return userPoint;
		}

		public int getUserLevel() {
			return userLevel;
		}
}
