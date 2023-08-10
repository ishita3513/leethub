//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int[][] dp=new int[x][y];
        if(s1.charAt(0)==s2.charAt(0))dp[0][0]=1;
        for(int i=1;i<x;i++){
            if(s1.charAt(i)==s2.charAt(0)){
                dp[i][0]=1;
            }
            else dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<y;i++){
            if(s1.charAt(0)==s2.charAt(i)){
                dp[0][i]=1;
            }
            else dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[x-1][y-1];
    }
    
}