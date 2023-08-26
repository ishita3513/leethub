//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
        Map<Character,Integer>map=new HashMap<>();
        int i=0,j=0,cnt=-1;
        for(i=0;i<n;i++){
            if(map.size()>k){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))==0)map.remove(s.charAt(j));
                j++;
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.size()==k)cnt=Math.max(cnt,i-j+1);
        }
        return cnt;
    }
}