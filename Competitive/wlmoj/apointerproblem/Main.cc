#include <iostream>
#include <vector>

#define INF 0x3f3f3f3f

using namespace std;

int main()
{
    int n,m;
    cin>>n>>m;
    vector<int> nums(n);
    for(int i=0;i<n;++i)
    {
        cin>>nums[i];
    }
    
    int start=0,end=0,min_len=INF,current_sum=0;
    
    while(end<n)
    {
        while(current_sum<m&&end<n)
        {
            current_sum+=nums[end];
            ++end;
        }
        while(current_sum>=m&&start<n)
        {
            if(end-start<min_len) min_len=end-start;
            current_sum-=nums[start];
            ++start;
        }
    }

    if(min_len<INF) cout<<min_len<<'\n';
    else cout<<"-1\n";
}
