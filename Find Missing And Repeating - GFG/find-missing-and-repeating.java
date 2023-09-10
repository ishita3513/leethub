//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here
        int xr=0;
        for(int i=0;i<n;i++){
            xr=xr^a[i];
            xr=xr^(i+1);
        }
        int num=xr & ~(xr-1);
        
        int zero=0,one=0;
        for(int i=0;i<n;i++){
            if((a[i] & num)!=0){
                one=one^a[i];
            }
            else{
                zero=zero^a[i];
            }
        }
        for(int i=1;i<=n;i++){
            if((i & num)!=0){
                one^=i;
            }
            else{
                zero^=i;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(a[i]==zero)cnt++;
        }
        if(cnt==2)return new int[]{zero,one};
        return new int[]{one,zero};
    }
}