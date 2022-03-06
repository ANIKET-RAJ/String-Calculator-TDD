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

        sum = findSum("//#\n6#8"); //chamge delimiter
        if(sum==14){
            System.out.println("Pass");
            pass++;
        }
        else{
            System.out.println("Fail");
            fail++;
        }
        System.out.println(pass + " test case passed and "+ fail + " failed" );

	 }

	public static boolean isDelimiterChange(String str){
        int n = str.length();
        if(n<4){
            return(false);
        }
        if(str.charAt(0)=='/' && str.charAt(1)=='/' && str.charAt(3)=='\n'){
            return(true);
        }
        return(false);
    }
    public static char getDelimiter(String str){
        if(isDelimiterChange(str)){
            return(str.charAt(2)); // character at index2 contains the changed delimiter
        }
        return(',');
    }

    public static int getStartIndex(String str){
        if(isDelimiterChange(str)){  // first 4 characters are for delimiter change request
            return(4);
        }
        return(0);
        
    }

	 public static int findSum(String str){
        int start_index = getStartIndex(str);
        char delimiter = getDelimiter(str);
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