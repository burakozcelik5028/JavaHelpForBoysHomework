package MountlyPayments;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {100, 100, 100, -10};
		String[] D = {"2020-12-13", "2020-12-13", "2020-12-22", "2020-12-29"};

		int[] B = {180, -50, -25, -25};
		String[] E = {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-01"};
		
		int c = solution(A, D);
		System.out.println(c);
		

		int x = solution(B, E);
		System.out.println(x);
	}
	
	public static int solution(int[] A, String[] D) {
		int total = 0;
		for(int a : A) {
			total = total + a;
		}
		int paymentMountlyTotal = total - (12*5);
		
		for (int i = 0; i < D.length-2; i++) {
			String first = D[i];
			String second = D[i+1];
			String third = D[i+2];
			
			String[] firstValues = first.split("-");
			String[] secondValues = second.split("-");
			String[] thirdValues = third.split("-");
			
			int firstMonth = Integer.parseInt(firstValues[1]);
			int secondMonth = Integer.parseInt(secondValues[1]);
			int thirdMonth = Integer.parseInt(thirdValues[1]);
			
			if (firstMonth == secondMonth && firstMonth == thirdMonth 
					&& A[i] < 0 
					&& A[i+1] < 0 
					&& A[i+2] < 0 
					&& (A[i] + A[i+1] + A[i+2]) <= -100) {
				
				paymentMountlyTotal = paymentMountlyTotal + 5;
				
			}
		}
		
		return paymentMountlyTotal;
    }

}
