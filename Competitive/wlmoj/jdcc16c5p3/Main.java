import java.util.Scanner;

public class Main
{
	public static long smallCase(long n,long m)
	{
		long maxLevel=1;
		while(maxLevel*10<=m) maxLevel*=10;
		
		long res=0;
		for(long level=maxLevel;level>=1;level/=10)
		{
			long digit=0;
		    for(long i=n;i<=m;++i)
		    {
		    	digit+=(i/level)%10;
		    }
			digit%=10;
			res*=10;
			res+=digit;
		}
		return res;
	}
	
	public static long largeCase(long n,long m)
	{
		long nTen=n/10*10;
		if(nTen<n) nTen+=10;
		long mTen=m/10*10;
		
		long maxLevel=1;
		while(maxLevel*10<=m) maxLevel*=10;
		
		long res=0;
		for(long level=maxLevel;level>=10;level/=10)
		{
			long digit=0;
		    for(long i=n;i<nTen;++i)
		    {
		    	digit+=(i/level)%10;
		    }
		    for(long i=mTen;i<=m;++i)
		    {
		    	digit+=(i/level)%10;
		    }
			digit%=10;
			res*=10;
			res+=digit;
		}
		
		long onesDigit=0;
		
		long nTwenty=n/20*20;
		if(nTwenty<n) nTwenty+=20;
		long mTwenty=m/20*20;
		
		for(long i=n;i<nTwenty;++i)
		{
			onesDigit+=i%10;
		}
		for(long i=mTwenty;i<=m;++i)
		{
			onesDigit+=i%10;
		}
		onesDigit%=10;
		
		res*=10;
		res+=onesDigit;
		
		return res;
	}
	
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		long n=input.nextLong(),m=input.nextLong();
		
		long res=0;
		if(m-n<20) res=smallCase(n,m);
		else res=largeCase(n,m);
		
		System.out.println(res);
    }
}
