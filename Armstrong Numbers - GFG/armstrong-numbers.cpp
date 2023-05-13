//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string armstrongNumber(int n){
        // code here
        int temp=n;
        vector<long long>v;
        long long cnt=0,sum=0;
        while(temp>0){
            cnt++;
            v.push_back(temp%10);
            temp/=10;
        }
        for(auto i:v){
            sum+=(long long)pow(i,cnt);
        }
        if(sum==n)return "Yes";
        return "No";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.armstrongNumber(n) << endl;
    }
    return 0;
}

// } Driver Code Ends