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


class Solution {
    static void dfs(char[][]grid, int i,int j,int[][] vis){
        int n=grid.length,m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j]==1 || grid[i][j]=='X')return;
        vis[i][j]=1;
        dfs(grid,i+1,j,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i,j-1,vis);
    }
    static char[][] fill(int n, int m, char grid[][]){
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 ||i==n-1 || j==m-1 ){
                    dfs(grid,i,j,vis);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // System.out.print(vis[i][j]+" ");
                if(vis[i][j]==0)grid[i][j]='X';
            }
            // System.out.println();
        }
        return grid;
    }
}
