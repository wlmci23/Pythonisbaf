import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int w=input.nextInt();
        
        int[][] dp=new int[n+1][w+1];
        
        int weight,value;
        for(int i=1;i<=n;++i)
        {
            weight=input.nextInt();
            value=input.nextInt();
            for(int j=0;j<=w;++j)
            {
                dp[i][j]=dp[i-1][j];
            }
        
            for(int j=0;j<=w-weight;++j)
            {
                if(dp[i][weight+j]<dp[i-1][j]+value)
                {
                    dp[i][weight+j]=dp[i-1][j]+value;
                }
            }
        }
        
        int max=0;
        for(int j=0;j<=w;++j)
        {
            if(max<dp[n][j]) max=dp[n][j];
        }
        
        System.out.println(max);
    }
}
