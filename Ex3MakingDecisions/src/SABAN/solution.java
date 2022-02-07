package SABAN;

public class solution {

	public static void main(String[] args) {
		
		int[] A = new int[]{ 1,0,1,0,1,1 };
		int a = solution(A);
		System.out.println(a);
		
		int[] B = new int[]{ 1,1,0,1,1 };
		int b = solution(B);
		System.out.println(b);
		
		int[] C = new int[]{ 1,0,1 };
		int c = solution(C);
		System.out.println(c);
		
		int[] D = new int[]{ 0,1,1,0 };
		int d = solution(D);
		System.out.println(d);
	}
	
	public static int solution(int[] A) {
		int result = 0;
		int zeroFlagHead = 0;
		int oneFlagHead = 0;
		
		int zeroFlagTail = 0;
		int oneFlagTail = 0;
		
		int lengthA = A.length;
		
		for(int i = 0; i < lengthA; i++) {
			if (A[i] == 0) {
				zeroFlagHead = zeroFlagHead+1;
			} else if (A[i] == 1) {
				oneFlagHead = oneFlagHead +1;
			}
			i++;
		}
		
		for(int i = 1; i < lengthA; i++) {
			if (A[i] == 0) {
				zeroFlagTail = zeroFlagTail+1;
			} else if (A[i] == 1) {
				oneFlagTail = oneFlagTail +1;
			}
			i++;
		}
		
		if (zeroFlagHead == 0 && oneFlagTail != 0) {
			result = oneFlagTail;
		}
		
		if (zeroFlagTail == 0 && oneFlagHead != 0) {
			result = oneFlagHead;
		}
		
		if (oneFlagTail == 0 && zeroFlagHead != 0) {
			result = zeroFlagHead;
		}
		
		if (oneFlagHead == 0 && zeroFlagTail != 0) {
			result = zeroFlagTail;
		}
		
		if (zeroFlagHead == oneFlagHead && oneFlagHead == zeroFlagTail && zeroFlagTail == oneFlagTail) {
			result = zeroFlagHead + oneFlagHead;
		}
		
		
		return result;
	}

}
