import java.io.*;
import java.util.*;

public class Main
{
	static long largest_digit(long n)
	{
		long res=1;
		while(res<=n) res*=10;
		res/=10;
		return res;
	}
	
	static long digit_sum(long n)
	{
		long res=0;
		while(n>0)
		{
			res+=n%10;
			n/=10;
		}
		return res;
	}
	
	static long sum_max(long n,long m)
	{
		if(n==0||m==0) return 0;
		if(m<10) return m;
		long lg=largest_digit(m);
		if(lg==largest_digit(n)&&m/lg==n/lg)
		{
			return m/lg+sum_max(n%lg,m%lg);
		}
		else
		{
			return digit_sum(m/lg*lg-1);
		}
	}
	
    public static void main(String[] args) 
    {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		for(int loop=0;loop<q;++loop)
		{
			long n = scan.nextLong();
			long m = scan.nextLong();
			System.out.println(sum_max(n,m));
		}
    }
}
