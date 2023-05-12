//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj=new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends



class Solution {

    void printTriangle(int n) {
        // code here
        char[][] arr=new char[n][2*n-1];
        for(char[] c:arr)Arrays.fill(c,' ');
        for(int i=0;i<n;i++){
            arr[i][n-1]='*';
            int k=0;
            while(k<i){
                arr[i][n+k]='*';
                k++;
            }
            k=0;
            while(k<i){
                arr[i][n-k-2]='*';
                k++;
            }
            
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n+i;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}