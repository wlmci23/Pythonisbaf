#include <stdio.h>
#include <vector>
#include <stdlib.h>

using namespace std;

int set_bits(int n)
{
    int res=0;
    while(n)
    {
        res+=n&1;
        n>>=1;
    }
    return res;
}

bool check_placed(vector<int>& placed,int n)
{
    int ps=placed.size()-1;
    for(int i=0;i<ps;++i)
    {
        if(placed[i]==-1) continue;
        
        if(placed[i]==placed[ps]) return false;
        if(abs(placed[i]-placed[ps])==abs(i-ps)) return false;
    }
    return true;
}

int place_queens(vector<int>& placed,int n,int mask)
{
    int ps=placed.size();
    int res=-1;
    
    if(ps==n) res=1;
    
    else if(!(mask&(1<<ps)))
    {
        placed.push_back(-1);
        res=place_queens(placed,n,mask);
        placed.pop_back();
    }
    
    else
    {
        res=0;        
        placed.push_back(-1);

        for(int i=0;i<n;++i)
        {
            placed[ps]=i;
            if(check_placed(placed,n)) res+=place_queens(placed,n,mask);
        }
        placed.pop_back();
    }
    
    return res;
}

int main()
{
    int n,k;
    scanf("%d%d",&n,&k);
    if(k>n)
    {
        puts("0");
    }
    else
    {
        int res=0;
        for(int mask=0;mask<(1<<n);++mask)
        {
            //printf("%d %d\n",mask,set_bits(mask));
            if(set_bits(mask)==k)
            {
                //printf("%d\n",mask);
                vector<int> placed;
                res+=place_queens(placed,n,mask);
            }
        }
        printf("%d\n",res);
    }
}
