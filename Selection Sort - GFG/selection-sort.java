//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	void select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int min=arr[i],idx=i;
        for(int j=i+1;j<arr.length;j++){
            if(min>arr[j]){
                idx=j;
                min=arr[j];
            }
        }
        int temp=arr[idx];
        arr[idx]=arr[i];
        arr[i]=temp;
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i=0;i<n;i++){
	        select(arr,i);
	    }
	}
}