//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	    int pow=1;
	    int num=0;
	    for(int i=str.length()-1;i>=0;i--){
	        if(str.charAt(0)=='-' && i==0)num=-num;
	        else if(!Character.isDigit(str.charAt(i)))return -1;
	        else{
	            num+=pow*(str.charAt(i)-'0');
	            pow*=10;
	        }
	    }
	    return num;
    }
}
