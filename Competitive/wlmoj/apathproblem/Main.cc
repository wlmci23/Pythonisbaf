#include <stdio.h>
#include <vector>
#include <queue>

using namespace std;

typedef int flag;

class UnionFind
{
private:
    vector<int> parent;
    int numSets;
public:
    UnionFind(int n)
    {
        parent.assign(n,0);
        for(int i=0;i<n;++i)
        {
            parent[i]=i;
        }        
    }
    int findSet(int i)
    {
        if(parent[i]==i) return parent[i];
        parent[i]=findSet(parent[i]);
        return parent[i];
    }

    void unionSet(int i,int j)
    {
        int x=findSet(i);
        int y=findSet(j);
        if(x==y) return;
        parent[x]=y;
    }
};

int main()
{
    int n,m;
    scanf("%d%d",&n,&m);
    
    UnionFind forest(n+1);
    
    int a,b;
    for(int loop=0;loop<m;++loop)
    {
        scanf("%d%d",&a,&b);
        forest.unionSet(a,b);
    }
    
    vector<int> rep(n+1);
    for(int i=1;i<=n;++i)
    {
        ++rep[forest.findSet(i)];
    }
    
    long long paths=0,sz;
    for(int i=1;i<=n;++i)
    {
        paths+=((long long)rep[i])*rep[i];       
    }
    printf("%lld\n",paths);
}
