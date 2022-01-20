package MountlyPayments;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {100, 100, 100, -10};
		String[] D = {"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};

		int[] B = {180, -50, -25, -25};
		String[] E = {"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"};

		int[] K = {1, -1, 0, -105, 1};
		String[] L = {"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"};

		int[] M = {100, 100, -10, -20, -30};
		String[] N = {"2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08"};

		
		int c = solution(A, D);
		System.out.println(c);

		int x = solution(B, E);
		System.out.println(x);

		int y = solution(K, L);
		System.out.println(y);

		int z = solution(M, N);
		System.out.println(z);
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
			
			if (firstValues[1].equals(secondValues[1]) && firstValues[1].equals(thirdValues[1] )
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
