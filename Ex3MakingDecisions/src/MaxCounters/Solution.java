package MaxCounters;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		int N = 5;
		
		int[] B = solution(N, A);
		
		System.out.println(Arrays.toString(B));
	}
	
	public static int[] solution(int N, int[] A) {
		int[] B = new int[N];
		Arrays.fill(B, 0, N, 0);
		
		for(int x= 0; x < A.length; x++) {
			if(A[x] <= N && A[x] >= 1) {
				B[A[x]-1] = B[A[x]-1] + 1;
			} else if(A[x] == N+1) {
				int max = maximum(B);
				Arrays.fill(B, 0, N, max);
			}
		}
		
		return B;
	}
	public static int maximum(int[] numbers)
    {
        int maxSoFar = numbers[0];
         
        // for each loop
        for (int num : numbers)
        {
            if (num > maxSoFar)
            {
                maxSoFar = num;
            }
        }
    return maxSoFar;
    }

}
