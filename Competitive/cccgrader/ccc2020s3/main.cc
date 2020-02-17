#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <functional>

using namespace std;

bool same_occs(vector<int>& a,vector<int>& b)
{
    for(char c='a';c<='z';++c)
    {
        if(a[c]!=b[c]) return false;
    }
    return true;
}

int main()
{
    string n,h;
    cin>>n>>h;

    set<size_t> hashes;

    int nl=n.length(),hl=h.length();
    vector<int> occ_n(128);
    
    for(int i=0;i<nl;++i)
    {
        ++occ_n[n[i]];
    }
    vector<int> occ(128);
    if(hl>=nl)
    {
        for(int i=0;i<nl;++i)
        {
            ++occ[h[i]];
        }
    }
    hash<string> str_hash;
    if(same_occs(occ,occ_n)) hashes.insert(str_hash(h.substr(0,nl)));
    for(int i=1;i<=hl-nl;++i)
    {
        --occ[h[i-1]];
        ++occ[h[i+nl-1]];
        if(same_occs(occ,occ_n)) hashes.insert(str_hash(h.substr(i,nl)));
    }
    cout<<hashes.size()<<'\n';
}
