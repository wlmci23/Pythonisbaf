#include <vector>
#include <iostream>

using namespace std;

#define UNVISITED -1

struct Edge
{
    int end,weight;
};

void dfs(int start,vector<int>& times,vector<vector<Edge>>& adj)
{
    for(Edge& e : adj[start])
    {
        if(times[e.end]==UNVISITED)
        {
            times[e.end]=times[start]+e.weight;
            dfs(e.end,times,adj);
        }
    }
}

int main()
{
    int n;
    cin>>n;
    
    vector<vector<Edge>> adj(n+1);
    
    int parent,weight;
    for(int i=1;i<=n;++i)
    {
        cin>>parent>>weight;
        adj[parent].push_back({i,weight});
    }
    
    vector<int> times(n+1,UNVISITED);
    times[1]=0;
    dfs(1,times,adj);
    
    for(int i=1;i<=n;++i) cout<<times[i]<<' ';
    cout<<'\n';
}
