#include <iostream>
#include <vector>

using namespace std;

class TwoDimSegmentTree
{
private:
    int n;
    int dat[20005][5005];
    
    int left(int p)
    {
        return p*2;
    }
    int right(int p)
    {
        return p*2+1;
    }
    void prvUpdate(int p,int segmentStart,int segmentEnd,int xRangeStart,int xRangeEnd,
        int yRangeStart,int yRangeEnd,int delta)
    {
        if(segmentStart>xRangeEnd||segmentEnd<xRangeStart) return;
        else if(segmentStart>=xRangeStart&&segmentEnd<=xRangeEnd)
        {
            int* dd=dat[p];
            for(int i=yRangeStart;i<=yRangeEnd;++i) dd[i]+=delta;
        }
        else
        {
            prvUpdate(left(p),segmentStart,(segmentStart+segmentEnd)/2,xRangeStart,xRangeEnd,yRangeStart,yRangeEnd,delta);
            prvUpdate(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,xRangeStart,xRangeEnd,yRangeStart,yRangeEnd,delta);
        }
    }
    int prvFind(int p,int segmentStart,int segmentEnd,int i,int j)
    {
        if(segmentStart==segmentEnd) return dat[p][j];
        else
        {
            if(i<=(segmentStart+segmentEnd)/2) 
            {
                return dat[p][j]+prvFind(left(p),segmentStart,(segmentStart+segmentEnd)/2,i,j);
            }
            else
            {
                return dat[p][j]+prvFind(right(p),(segmentStart+segmentEnd)/2+1,segmentEnd,i,j);
            }
        }
    }
    
public:
    TwoDimSegmentTree(int sz)
    {
        n=sz;
        //dat.assign((sz+1)*4,vector<int>(sz+1));
    }
    void update(int xRangeStart,int xRangeEnd,int yRangeStart,int yRangeEnd,int delta)
    {
        prvUpdate(1,1,n,xRangeStart,xRangeEnd,yRangeStart,yRangeEnd,delta);
    }
    int find(int i,int j)
    {
        return prvFind(1,1,n,i,j);
    }
};

int main()
{
    int n;
    cin>>n;
    
    TwoDimSegmentTree dat(n);
    
    int q;
    cin>>q;
    int type;
    for(int loop=0;loop<q;++loop)
    {
        cin>>type;
        if(type==1)
        {
            int x1,y1,x2,y2,v;
            cin>>x1>>y1>>x2>>y2>>v;
            dat.update(x1,x2,y1,y2,v);
        }
        else
        {
            int x,y;
            cin>>x>>y;
            cout<<dat.find(x,y)<<'\n';
        }
    }
}
