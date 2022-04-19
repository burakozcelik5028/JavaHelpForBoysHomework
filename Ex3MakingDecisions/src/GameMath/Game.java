package GameMath;

import java.util.ArrayList;

public class Game {
	//level 2 Polymorphism: Game class is instance of Object class.
		
	ArrayList<Integer> arrList;  //Level 3 using ArrayList
	User user;
	
	public Game(ArrayList<Integer> arrList, User user) {
		this.arrList = arrList;
		this.user = user;
	}
	
	public boolean calculate() {
		return false;
	}
	

	public ArrayList<Integer> getArrList() {
		return arrList;
	}

	public void setArrList(ArrayList<Integer> arrList) {
		this.arrList = arrList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
