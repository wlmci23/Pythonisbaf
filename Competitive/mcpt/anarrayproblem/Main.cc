#include <vector>
#include <iostream>

using namespace std;

int main()
{
    int n,q;
    cin>>n>>q;
    
    vector<int> nums(n+1);
    
    for(int i=1;i<=n;++i)
    {
        cin>>nums[i];
    }
    
    for(int loop=0;loop<q;++loop)
    {
        int type;
        cin>>type;
        if(type==1)
        {
            int l,r,v,k;
            cin>>l>>r>>v>>k;
            for(int i=l;i<=r;++i)
            {
                if(nums[i]>k)
                {
                    nums[i]-=v;
                }
            }
        }
        else
        {
            int l,r,k;
            cin>>l>>r>>k;
            int sum=0;
            for(int i=l;i<=r;++i)
            {
                if(nums[i]>k)
                {
                    sum+=nums[i];
                }
            }
            cout<<sum<<'\n';
        }
    }
}
