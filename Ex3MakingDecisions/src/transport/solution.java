package transport;

public class solution {

	static String printBinary(int[] binary, int id)
    {
		String a = "";
        // Iteration over array
        for (int i = id - 1; i >= 0; i--) {
        	a = a + binary[i];
        }
        return a;
    }
 
    // Function converting decimal to binary
    public static String decimalToBinary(int num)
    {
        // Creating and assigning binary array size
        int[] binary = new int[35];
        int id = 0;
 
        // Number should be positive
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }
 
        // Print Binary
        return printBinary(binary, id);
    }
 
    // Main Driver Code
    public static void main(String[] args)
    {
        // Entered number to be convert into binary
    	int num = A*B;
        if(num < 0){
            num = num * (-1);
        }
         
        // Calling Our Above Function
        String a = decimalToBinary(num);

        int charCount = 0;
        String[] ch = a.split("");

        for (String c : ch) {
            if(c.equals("1")){
                charCount = charCount +1;
            }
        }

        return charCount;
    }
	

}
