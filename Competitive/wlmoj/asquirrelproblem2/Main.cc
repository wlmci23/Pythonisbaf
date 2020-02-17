#include <iostream>
#include <vector>

using namespace std;

class SegmentTree
{
private:
    vector<int> tree;
    int n;
    
    int left(int p) 
    {
        return p*2;
    }
    int right(int p)
    {
        return p*2+1;
    }
    
    void prvUpdate(int p,int segmentStart,int segmentEnd,int rangeStart,int rangeEnd)
    {
        if(segmentStart>rangeEnd||segmentEnd<rangeStart) return;
        else if(segmentStart>=rangeStart&&segmentEnd<=rangeEnd)
        {
            ++tree[p];
        }
        else
        {
            prvUpdate(left(p),segmentStart,(segmentStart+segmentEnd)/2,rangeStart,rangeEnd);
            prvUpdate(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,rangeStart,rangeEnd);
        }
    }
    int prvFind(int p,int segmentStart,int segmentEnd,int i)
    {
        if(segmentStart==segmentEnd) return tree[p];
        else
        {
            if(i<=(segmentStart+segmentEnd)/2) 
            {
                return tree[p]+prvFind(left(p),segmentStart,(segmentStart+segmentEnd)/2,i);
            }
            else
            {
                return tree[p]+prvFind(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,i);
            }
        }
    }
public:
    SegmentTree(int size)
    {
        tree.assign((size+1)*4,0);
        n=size;
    }
    void updateTo(int i)
    {
        prvUpdate(1,1,n,1,i);
    }
    int find(int i)
    {
        return prvFind(1,1,n,i);
    }
};

int main()
{
    int n,q;
    cin>>n>>q;
    
    vector<int> snacks(n+1);
    
    for(int i=1;i<=n;++i)
    {
        cin>>snacks[i];
    }
    
    SegmentTree dat(n);
    
    int type,r;
    for(int loop=0;loop<q;++loop)
    {
        cin>>type>>r;
        
        if(type==1)
        {
            cout<<(snacks[r]>>min(31,dat.find(r)))<<'\n';
            //cout<<(snacks[r]>>dat.find(r))<<'\n';
        }
        else
        {
            dat.updateTo(r);
        }
    }
}
