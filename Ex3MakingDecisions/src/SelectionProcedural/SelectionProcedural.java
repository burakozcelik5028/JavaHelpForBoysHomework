package SelectionProcedural;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.sun.prism.impl.Disposer.Record;

public class SelectionProcedural {

	static class Candidates{
		String name;
		int number;
		int voteCount;
	}
	
	public static Candidates[] CandidateList() {
		
		Candidates candidate1 = new Candidates();
		candidate1.name = "Alex";
		candidate1.number = 1;
		candidate1.voteCount = 0;
		
		Candidates candidate2 = new Candidates();
		candidate2.name = "Brian";
		candidate2.number = 2;
		candidate2.voteCount = 0;
		
		Candidates candidate3 = new Candidates();
		candidate3.name = "Cindy";
		candidate3.number = 3;
		candidate3.voteCount = 0;
		
		Candidates candidate4 = new Candidates();
		candidate4.name = "Danial";
		candidate4.number = 4;
		candidate4.voteCount = 0;
		
		Candidates candidate5 = new Candidates();
		candidate5.name = "Eliza";
		candidate5.number = 5;
		candidate5.voteCount = 0;
		
		Candidates candidate6 = new Candidates();
		candidate6.name = "Frank";
		candidate6.number = 6;
		candidate6.voteCount = 0;
		
		Candidates candidate7 = new Candidates();
		candidate7.name = "Gina";
		candidate7.number = 7;
		candidate7.voteCount = 0;
		
		Candidates candidate8 = new Candidates();
		candidate8.name = "Hansel";
		candidate8.number = 8;
		candidate8.voteCount = 0;
		
		Candidates candidate9 = new Candidates();
		candidate9.name = "Irina";
		candidate9.number = 9;
		candidate9.voteCount = 0;
		
		Candidates candidate10 = new Candidates();
		candidate10.name = "Jo";
		candidate10.number = 10;
		candidate10.voteCount = 0;
		
		Candidates[] candidates = new Candidates[10];
		candidates[0] = candidate1;
		candidates[1] = candidate2;
		candidates[2] = candidate3;
		candidates[3] = candidate4;
		candidates[4] = candidate5;
		candidates[5] = candidate6;
		candidates[6] = candidate7;
		candidates[7] = candidate8;
		candidates[8] = candidate9;
		candidates[9] = candidate10;
		
		return candidates;
		
	}
	
	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		int vote_number = 0;
		boolean flag = true;
		
		final Candidates[] candidate_list = CandidateList();
		
		System.out.println("Voting: " + candidate_list[0].number + "=" + candidate_list[0].name + " "
				+ candidate_list[1].number + "=" + candidate_list[1].name + " "
				+ candidate_list[2].number + "=" + candidate_list[2].name + " "
				+ candidate_list[3].number + "=" + candidate_list[3].name + " "
				+ candidate_list[4].number + "=" + candidate_list[4].name + " "
				+ candidate_list[5].number + "=" + candidate_list[5].name + " "
				+ candidate_list[6].number + "=" + candidate_list[6].name + " "
				+ candidate_list[7].number + "=" + candidate_list[7].name + " "
				+ candidate_list[8].number + "=" + candidate_list[8].name + " "
				+ candidate_list[9].number + "=" + candidate_list[9].name);
		
		
		for(int i = 0; i < candidate_list.length ; i++) {
			
			System.out.println(candidate_list[i].name + " who do you vote for? ");
			flag = true;
			while(flag) {
				
				try {
					vote_number = myInput.nextInt();
					flag = false;
				} catch (InputMismatchException e) {
					System.out.println("Please enter an integer value value between 1- "+ candidate_list.length + ":");
					myInput.nextLine();
					flag = true;
				}
				
				if (vote_number > candidate_list.length || vote_number < 1) {
					System.out.println("Please enter an integer value value between 1- "+ candidate_list.length + ":");
					flag = true;
				}

			}
			
			candidate_list[vote_number].voteCount = candidate_list[vote_number].voteCount + 1;
		}
		
		int max = candidate_list[0].voteCount;
		
		for (int i = 0; i < candidate_list.length; i++) {
			if (candidate_list[i].voteCount > max) {
				max = candidate_list[i].voteCount;
			}
		}
		
		
		Candidates winners[] = new Candidates[10];
		
		for(int i = 0; i < candidate_list.length; i++) {
			if (candidate_list[i].voteCount == max) {
				winners[i] = candidate_list[i];
			}
		}
		
		System.out.print("Winner(s): ");
		
		for (int i = 0; i < winners.length; i++) {
			if (winners[i] != null) {
				System.out.print(winners[i].name + " ");
			}
		}
		
	}

}
