import java.util.Scanner;

class Cookie
{
	long eat,skip;
	Cookie()
	{
		eat=0;
		skip=0;
	}
	
	public String toString()
	{
		return String.format("%d %d",eat,skip);
	}
}

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		long[] cookies=new long[n];
		for(int i=0;i<n;++i)
		{
			cookies[i]=input.nextLong();
		}
		
		Cookie[] dp=new Cookie[n];
		for(int i=0;i<n;++i)
		{
			dp[i]=new Cookie();
		}
		dp[0].eat=cookies[0];
		for(int i=0;i<n-1;++i)
		{
			if(dp[i].eat>dp[i+1].skip) dp[i+1].skip=dp[i].eat;
			if(dp[i].skip+cookies[i+1]>dp[i+1].eat) dp[i+1].eat=dp[i].skip+cookies[i+1];
			if(dp[i].skip>dp[i+1].skip) dp[i+1].skip=dp[i].skip;
		}
		System.out.println(Math.max(dp[n-1].eat,dp[n-1].skip));
	}
}
