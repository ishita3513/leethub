//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int[][] vis,char[][] a,int i,int j){
        if(i<0 || j<0 || i>=vis.length || j>=vis[0].length || vis[i][j]==1 || a[i][j]=='X')return;
        vis[i][j]=1;
        dfs(vis,a,i+1,j);
        dfs(vis,a,i,j+1);
        dfs(vis,a,i-1,j);
        dfs(vis,a,i,j-1);
    }
    static char[][] fill(int n, int m, char a[][]){
        //if somebody is not attached to boundry and visted then mark then as X
        //apply dfs on top,bottom,left, right boundry element
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    dfs(vis,a,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}