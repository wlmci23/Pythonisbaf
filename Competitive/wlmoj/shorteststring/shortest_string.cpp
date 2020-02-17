#include <bits/stdc++.h>

using namespace std;

typedef int flag;

flag adj[200][200];
string res[200][200];

int main() {
    int n,q;
    cin>>n>>q;

    string s;
    cin>>s;

    for(int i=0;i<n-1;++i)
    {
        adj[s[i]][s[i+1]]=1;
    }

    flag visited[200];

    for(char start='a';start<='z';++start)
    {
    	for(char finish='a';finish<='z';++finish)
    	{
    		if(start==finish) continue;
		    vector<string> pathto(200);

		    queue<char> qq;
		    memset(visited,0,sizeof(visited));
		    visited[start]=1;
		    qq.push(start);
		    pathto[start]=start;
		    while(!qq.empty())
		    {
		        char u=qq.front();
		        qq.pop();
		        for(char v='a';v<='z';++v)
		        {
		            if(adj[u][v]&&!visited[v])
		            {
		                qq.push(v);
		                visited[v]=1;
		                pathto[v]=pathto[u]+v;
		            }
		        }
		    }
		    if(pathto[finish].length()!=0) res[start][finish]=pathto[finish];
		    else res[start][finish]="-1";
		}
    }
     char start,finish;
    for(int loop=0;loop<q;++loop)
    {
    	cin>>start>>finish;
    	cout<<res[start][finish]<<'\n';
    }
    return 0;
}
