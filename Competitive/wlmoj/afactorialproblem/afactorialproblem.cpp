#include <stdio.h>

int main()
{
	int q;
	scanf("%d",&q);
	int n=0;
	int zeros=0;
	int tmp;
	while(zeros<q)
	{
		n+=25;
		zeros+=4;
		if(n%48828125==0) zeros+=11;
		else if(n%9765625==0) zeros+=10;
		else if(n%1953125==0) zeros+=9;
		else if(n%390625==0) zeros+=8;
		else if(n%78125==0) zeros+=7;
		else if(n%15625==0) zeros+=6;
		else if(n%3125==0) zeros+=5;
		else if(n%625==0) zeros+=4;
		else if(n%125==0) zeros+=3;
		else if(n%25==0) zeros+=2;
	}
	
	while(zeros>q)
	{
		tmp=n;
		while(tmp%5==0)
		{
			tmp/=5;
			--zeros;
		}
		n-=5;
	}
	if(zeros==q) printf("%d\n",n);
	else puts("No solution");
}
