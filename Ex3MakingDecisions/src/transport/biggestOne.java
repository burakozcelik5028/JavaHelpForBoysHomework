package transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class biggestOne {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("dsd");
		list.add(3);
		for (String s: list)
			System.out.print(s);
		// TODO Auto-generated method stub
		int a = solution(553);
		System.out.println(a);
		
		int b = solution(213);
		System.out.println(b);
		
		int c = solution(32442);
		System.out.println(c);
		
		
	}
	
	 public static int solution(int N) {
	        if(N<0){
	 	       N = N * (-1);
	 	    }
	 		 
	 	    String s = String.valueOf(N);
	 	    String[] ar = s.split("");
	 	    int a = Integer.parseInt(ar[0]);
	 	    String[] res = new String[ar.length]; 
	 	     
	 	     
	 	    for (int i = 0; i < ar.length; i++) {
	 	    	a = Integer.parseInt(ar[i]);
	 			for (int j = 0; j < ar.length; j++) {
	 				if(a < Integer.parseInt(ar[j])) {
	 					res[i] = ar[j];
	 				}
	 				if (res[i] == null) {
	 					res[i] = String.valueOf(a);
					}
	 			}
	 			
	 			for (int j = 0; j < ar.length; j++) {
					if (ar[j].equals(res[i])) {
						ar[j] = "0";
						break;
					}
				}

	 		}
	 	     
	 	    String responce = "";
	 	    for (int i = 0; i < res.length; i++) {
	 	    	responce = responce + res[i];
	 		}
	 	     
	 	    a = Integer.parseInt(responce);
	 	    return a;
	 }

}
