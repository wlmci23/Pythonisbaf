import java.lang.Math;
import java.util.Scanner;

public class Main
{
	public static boolean isPrime(long n)
	{
		long sqrtn=(long)Math.sqrt(n);
		for(long m=2;m<=sqrtn;++m)
		{
			if(n%m==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		for(int loop=0;loop<t;++loop)
		{
			long a=input.nextLong();
			long b=input.nextLong();
			if(a-b==1&&isPrime(a+b)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
