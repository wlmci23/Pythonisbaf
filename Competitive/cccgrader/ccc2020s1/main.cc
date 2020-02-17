#include <iostream>
#include <math.h>
#include <vector>
#include <algorithm>

using namespace std;

struct Measurement
{
    int t,x;
    bool operator<(Measurement& other)
    {
        return t<other.t;
    }
};

int main()
{
    int n;
    cin>>n;

    vector<Measurement> ms(n);

    for(int i=0;i<n;++i)
    {
        cin>>ms[i].t;
        cin>>ms[i].x;
    }

    sort(ms.begin(),ms.end());

    double speed,max_speed;
    for(int i=1;i<n;++i)
    {
        speed=abs((double)(ms[i].x-ms[i-1].x)/(ms[i].t-ms[i-1].t));
        if(speed>max_speed) max_speed=speed;
    }
    cout<<max_speed<<'\n';
}
