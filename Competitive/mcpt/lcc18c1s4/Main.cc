#include <stdio.h>
#include <stdlib.h>
#include <unordered_set>

#define MOD 2147483648LL

using namespace std;

typedef long long big;

int main()
{
    int n;
    scanf("%d",&n);

    unordered_set<big> nums;
    big tmp;
    
    for(int loop=0;loop<n;++loop)
    {
        scanf("%lld",&tmp);
        nums.insert(tmp);
    }

    for(big i=0;;++i)
    {
        int j=rand()%MOD;
        tmp=(j*1103515245+12345)%MOD;
        if(nums.find(tmp)!=nums.end())
        {
            printf("%d\n",j);
            break;
        }
    }
}
