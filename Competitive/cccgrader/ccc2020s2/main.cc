#include <stdio.h>
#include <math.h>

int grid[1005][1005];
bool visited[1005][1005];
int m,n;

void dfs(int i,int j)
{
    visited[i][j]=true;
    int current=grid[i][j];
    int sq=sqrt(current);
    int b;
    for(int a=1;a<=sq;++a)
    {
        if(current%a==0)
        {
            b=current/a;
            if(a<=m&&b<=n&&!visited[a][b])
            {
                dfs(a,b);
            }
            if(b<=m&&a<=n&&!visited[b][a])
            {
                dfs(b,a);
            }
        }
    }
}

int main()
{
    scanf("%d%d",&m,&n);

    for(int i=1;i<=m;++i)
    {
        for(int j=1;j<=n;++j)
        {
            scanf("%d",&grid[i][j]);
        }
    }
    dfs(1,1);

    if(visited[m][n])
    {
        puts("yes");
    }
    else
    {
        puts("no");
    }
}
