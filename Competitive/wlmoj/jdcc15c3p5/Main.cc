#include <stdio.h>
#include <string.h>
#include <map>

using namespace std;

int main()
{
    int t;
    scanf("%d",&t);
    for(int loop=0;loop<t;++loop)
    {
        map<int,int> diff_array;
        int n,m,a,l,b;
        scanf("%d%d",&n,&m);
        for(int i=0;i<m;++i)
        {
            scanf("%d%d%d",&a,&l,&b);
            diff_array[a]+=b;
            diff_array[a+l]-=b;
        }
        diff_array[0]=0;
        map<int,int>::iterator it=diff_array.begin(), t=diff_array.begin();
        int max_brightness=0,brightness=0;
        while(it!=diff_array.end())
        {
            brightness=(it++)->second;
            brightness+=it->second;
            it->second=brightness;
            //printf("Time: %d Brightness: %d\n",it->first,brightness);
            if(brightness>=max_brightness)
            {
                max_brightness=brightness;
                t=it;
            }
        }
        
        ++t;
        
        printf("%d\n",(t->first)-1);
    }
}
