import java.util.Scanner;

public class Main
{
    static long[] valueSum;
    static int[] value;
    static int[] child;
    
    static long sumVertex(int i)
    {
        if(valueSum[i]!=-1) return valueSum[i];
        
        valueSum[i]=sumVertex(child[i])+value[i];
        return valueSum[i];
    }
    
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int q=input.nextInt();
        
        valueSum=new long[n+1];
        value=new int[n+1];
        child=new int[n+1];
        
        for(int i=1;i<=n;++i)
        {
            value[i]=input.nextInt();
            child[i]=input.nextInt();
        }
        
        for(int i=1;i<=n;++i) valueSum[i]=-1;
        
        for(int i=1;i<=n;++i) sumVertex(i);
        
        for(int loop=0;loop<q;++loop)
        {
            int j=input.nextInt();
            System.out.println(valueSum[j]);
        }
    }
}
