class sum{
	 public static void unitTests(){
	 	int pass = 0;
        int fail = 0;
        int sum = findSum("1,42,44");
        if(sum==87){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
        
        sum = findSum("");
        if(sum==0){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
       
        sum = findSum("1");
        if(sum==1){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
        
        sum = findSum("1,2");
        if(sum==3){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
        
        sum = findSum("1\n44");
        if(sum==45){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
        //System.out.println(sum);
        //sum = findSum("//;\n6;8");
        //System.out.println(sum);
        System.out.println(pass + " test case passed and "+ fail + " failed" );

	 }

	 public static int findSum(String str){
        int start_index = 0;
        char delimiter = ',';
        String number = "0"; // stores individual numbers
        int sum = 0;
        int n = str.length();

        // if length of string left is zero
        if(start_index==(n)){
            System.out.println("No numbers found");
            return(0);
        }
        for(int i = start_index; i<n; i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                number += ch;
            }
            else if(ch == delimiter || (ch == '\n' ) ){   // add the number if we encounter end of line or delimiter
                sum += Integer.parseInt(number);
                number = "0"; 
                }
             else{
                System.out.println("Invalid Input. Please give numbers separated by "+ delimiter);
                return(-1);
            }
            }
           
        
        sum += Integer.parseInt(number); // to add if number is present at end of string
        return(sum);
    }
    

	public static void main(String[] args) { 
        unitTests();
    }
}