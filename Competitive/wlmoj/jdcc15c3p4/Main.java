import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		final long MOD=1000000007;
		Scanner input=new Scanner(System.in);
		int t=input.nextInt();
		for(int loop=0;loop<t;++loop)
		{
			int n=input.nextInt();
			char[][] map=new char[n][];
			long[][] dp=new long[n][n];
			
			for(int i=0;i<n;++i)
			{
				map[i]=input.next().toCharArray();
			}
			for(int j=0;j<n;++j)
			{
				if(map[0][j]=='O') dp[0][j]=1;
			}
			
			for(int i=0;i<n-1;++i)
			{
				for(int j=0;j<n;++j)
				{
					if(dp[i][j]==0) continue;
					if(j-1>=0&&map[i+1][j-1]=='O')
					{
						dp[i+1][j-1]+=dp[i][j];
						dp[i+1][j-1]%=MOD;
					}
					if(map[i+1][j]=='O')
					{
						dp[i+1][j]+=dp[i][j];
						dp[i+1][j]%=MOD;
					}
					if(j+1<n&&map[i+1][j+1]=='O')
					{
						dp[i+1][j+1]+=dp[i][j];
						dp[i+1][j+1]%=MOD;
					}
				}
			}
			
			long res=0;
			for(int j=0;j<n;++j)
			{
				res+=dp[n-1][j];
			}
			System.out.println(res%MOD);
		}
	}
}
