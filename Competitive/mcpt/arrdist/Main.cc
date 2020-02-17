#include <iostream>
#include <vector>

using namespace std;

typedef long long big;

int main()
{
    int n,q;
    cin>>n>>q;
    vector<big> x(n+1);
    for(int i=1;i<=n;++i)
    {
        cin>>x[i];
    }
    
    vector<big> sum0(n+1);
    for(int i=1;i<=n;++i)
    {
        sum0[i]=sum0[i-1]+x[i];
    }
    vector<big> sum1(n+1),sum2(n+1);
    for(int i=1;i<=n;++i)
    {
        sum1[i]=x[i]*i+sum1[i-1];
        sum2[i]=x[i]*(n+1-i)+sum2[i-1];
    }
    
    int y;
    for(int loop=0;loop<q;++loop)
    {
        cin>>y;
        cout<<(sum2[y]-(n-y+1)*sum0[y]+(sum1[n]-sum1[y])-y*(sum0[n]-sum0[y]))%1000000007<<'\n';
    }
}
