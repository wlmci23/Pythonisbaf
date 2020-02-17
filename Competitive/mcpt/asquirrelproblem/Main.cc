#include <iostream>
#include <vector>

using namespace std;

typedef long long big;

class SegmentTree
{
private:
    int n;
    vector<big> dat;
    
    int left(int p)
    {
        return p*2;
    }
    int right(int p)
    {
        return p*2+1;
    }
    void prvBuild(int p,int segmentStart,int segmentEnd,vector<big>& original)
    {
        if(segmentStart==segmentEnd) dat[p]=original[segmentStart];
        else
        {
            prvBuild(left(p),segmentStart,(segmentStart+segmentEnd)/2,original);
            prvBuild(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,original);
        }
    }
    void prvUpdate(int p,int segmentStart,int segmentEnd,int rangeStart,int rangeEnd,int delta)
    {
        if(segmentStart>rangeEnd||segmentEnd<rangeStart) return;
        else if(segmentStart>=rangeStart&&segmentEnd<=rangeEnd)
        {
            dat[p]+=delta;
        }
        else
        {
            prvUpdate(left(p),segmentStart,(segmentStart+segmentEnd)/2,rangeStart,rangeEnd,delta);
            prvUpdate(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,rangeStart,rangeEnd,delta);
        }
    }
    big prvFind(int p,int segmentStart,int segmentEnd,int i)
    {
        if(segmentStart==segmentEnd) return dat[p];
        else
        {
            if(i<=(segmentStart+segmentEnd)/2) 
            {
                return dat[p]+prvFind(left(p),segmentStart,(segmentStart+segmentEnd)/2,i);
            }
            else
            {
                return dat[p]+prvFind(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,i);
            }
        }
    }
    
public:
    SegmentTree(int sz,vector<big>& original)
    {
        n=sz;
        dat.assign((sz+1)*4,0);
        prvBuild(1,1,n,original);
    }
    void update(int rangeStart,int rangeEnd,int delta)
    {
        prvUpdate(1,1,n,rangeStart,rangeEnd,delta);
    }
    big find(int i)
    {
        return prvFind(1,1,n,i);
    }
};

int main()
{
    int n;
    cin>>n;
    
    vector<big> snacks(n+1);
    for(int i=1;i<=n;++i)
    {
        cin>>snacks[i];
    }
    SegmentTree dat(n,snacks);
    
    int q;
    cin>>q;
    int type;
    for(int loop=0;loop<q;++loop)
    {
        cin>>type;
        if(type==1)
        {
            int i;
            cin>>i;
            cout<<dat.find(i)<<'\n';
        }
        else
        {
            int l,r,v;
            cin>>l>>r>>v;
            dat.update(l,r,v);
        }
    }
}
