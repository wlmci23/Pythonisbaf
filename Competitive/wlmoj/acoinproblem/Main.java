import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int s=input.nextInt();
        
        int[] coins=new int[n];
        for(int i=0;i<n;++i)
        {
            coins[i]=input.nextInt();
        }
        
        boolean[] possible=new boolean[s+1];
        possible[0]=true;
        
        boolean updated=true;
        while(updated)
        {
            updated=false;
            for(int coin : coins)
            {
                for(int i=0;i<=s-coin;++i)
                {
                    if(possible[i]&&!possible[i+coin])
                    {
                        possible[i+coin]=true;
                        updated=true;
                    }
                }
            }
        }
        
        if(possible[s]) System.out.println("YES");
        else System.out.println("NO");
    }
}
