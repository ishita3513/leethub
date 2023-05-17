//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int numberOfEnclaves(int grid[][]){
        int n=grid.length,m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<List<Integer>>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 ||i==n-1 || j==m-1) && grid[i][j]==1 ){
                    // dfs(grid,i,j,vis);
                    vis[i][j]=1;
                    List<Integer>list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    q.add(list);
                }
            }
        }
        
        int[] delR={-1,0,1,0};
        int[] delC={0,-1,0,1};
        while(!q.isEmpty()){
            int size=q.size();
            int r=q.peek().get(0);
            int c=q.peek().get(1);
            q.poll();
            for(int i=0;i<4;i++){
                int nr=delR[i]+r;
                int nc=delC[i]+c;
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    vis[nr][nc]=1;
                    List<Integer>list=new ArrayList<>();
                    list.add(nr);
                    list.add(nc);
                    q.add(list);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // System.out.print(vis[i][j]+" ");
                if(vis[i][j]==0 && grid[i][j]==1)cnt++;;
            }
            // System.out.println();
        }
        return cnt;
    }
}