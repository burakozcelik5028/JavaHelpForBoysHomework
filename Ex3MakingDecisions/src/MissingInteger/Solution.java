package MissingInteger;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		int b = solution(A);
		System.out.println(b);
	}
	
	public static int solution(int[] A) {
	     // write your code in Java SE 8
	     int responce = 1;
	     Arrays.sort(A);
	     int flag = 1;
	     int lengthOfArray = A.length;
	     for(int x = 0; x < lengthOfArray; x++){
	         if(A[x] <= 0){

	         } else{
	             if(A[x] == flag){
	                 flag++;
	             }
	         }
	     }

	     return responce;
	     
	 }

}


