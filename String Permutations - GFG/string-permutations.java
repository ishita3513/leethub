//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    void solve(String s,String str,ArrayList<String>list,Set<Integer>set){
        if(s.length()==str.length()){
            list.add(str);
            return ;
        }
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                str+=s.charAt(i);
                set.add(i);
                solve(s,str,list,set);
                set.remove(i);
                str=str.substring(0,str.length()-1);
            }
        }
    }
    public ArrayList<String> permutation(String s)
    {
        ArrayList<String>list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        solve(s,"",list,set);
        Collections.sort(list);
        return list;
    }
	   
}
