import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int q=input.nextInt();
		
		long[] originalArray=new long[n];
		for(int i=0;i<n;++i)
		{
			originalArray[i]=input.nextLong();
		}
		
		long[] diffArray=new long[n];
		diffArray[0]=originalArray[0];
		for(int i=1;i<n;++i)
		{
			diffArray[i]=originalArray[i]-originalArray[i-1];
		}
		
		for(int loop=0;loop<q;++loop)
		{
			int l=input.nextInt();
			int r=input.nextInt();
			long v=input.nextLong();
			
			diffArray[l-1]+=v;
			if(r<n) diffArray[r]-=v;
		}
		
		for(int i=1;i<n;++i)
		{
			diffArray[i]+=diffArray[i-1];
		}
		
		for(int i=0;i<n;++i)
		{
			System.out.printf("%d ",diffArray[i]);
		}
	}
}
