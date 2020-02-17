#include <stdio.h>
#include <vector>
#include <math.h>

using namespace std;

class Tree
{	
public:
	void getInput();
	void buildParents();
	int queryPath(int a,int b);
	
	Tree(int n) : node_count_(n),max_level_((int)(log2(n)+1)),
		parent_matrix_(n+1,vector<int>(max_level_+1)),adjacency_list_(n+1),heights_(n+1){}
	
private:
	int node_count_;
	int max_level_;
	vector<vector<int>> parent_matrix_;
	vector<vector<int>> adjacency_list_;
	vector<int> heights_;
	
	void dfs(int u);
	int lca(int a, int b);
};

void Tree::getInput()
{
	int u,v;
	for(int loop=1;loop<node_count_;++loop)
	{
		scanf("%d%d",&u,&v);
		adjacency_list_[u].push_back(v);
		adjacency_list_[v].push_back(u);
	}
}

void Tree::buildParents()
{
	heights_[1]=1;
	dfs(1);
}

void Tree::dfs(int u)
{
	for(int level=1;level<=max_level_;++level)
	{
		if(parent_matrix_[u][level-1]!=0)
		{
			parent_matrix_[u][level]=parent_matrix_[parent_matrix_[u][level-1]][level-1]; 
				// could potentially assign parent_matrix_[u][level] to zero
		}
		else break;
	}
	
	for(int v : adjacency_list_[u])
	{
		if(v!=parent_matrix_[u][0])
		{
			parent_matrix_[v][0]=u;
			heights_[v]=heights_[u]+1;
			dfs(v);
		}
	}
}

int Tree::queryPath(int a,int b)
{
	return heights_[a]+heights_[b]-2*heights_[lca(a,b)];
}

int Tree::lca(int a,int b)
{
	if(heights_[a]>heights_[b]) swap(a,b);
	
	int diff=heights_[b]-heights_[a];
	for(int level=0;level<=max_level_;++level)
	{
		if((diff>>level)&1) b=parent_matrix_[b][level];
	}
	
	if(a==b) return a;
	
	for(int level=max_level_;level>=0;--level)
	{
		if(parent_matrix_[a][level]!=parent_matrix_[b][level])
		{
			a=parent_matrix_[a][level];
			b=parent_matrix_[b][level];
		}
	}
	
	return parent_matrix_[a][0];
}

int main()
{
	int n,q;
	scanf("%d%d",&n,&q);
	
	Tree tree=Tree(n);
	tree.getInput();
	tree.buildParents();
	
	int a,b;
	for(int loop=0;loop<q;++loop)
	{
		scanf("%d%d",&a,&b);
		printf("%d\n",tree.queryPath(a,b));
	}
	return 0;
}
