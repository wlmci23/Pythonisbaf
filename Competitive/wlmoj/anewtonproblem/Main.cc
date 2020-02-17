#include <stdio.h>
#include <math.h>

#define ERROR 1e-12

int a,b,c;

bool sign(double x)
{
    return (a*x+b*sin(x)-c)>=0;
}

double binary_search(double lower,double upper)
{
    if(abs(upper-lower)<=ERROR) return lower;
    
    double middle=(lower+upper)/2;
    
    if(sign(middle)!=sign(lower))
    {
        return binary_search(lower,middle);
    }
    else
    {
        return binary_search(middle,upper);
    }
}

int main()
{
    scanf("%d%d%d",&a,&b,&c);
    printf("%.10f\n",binary_search(-1e9,1e9));
}
