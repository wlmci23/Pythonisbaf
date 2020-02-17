import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt(),m=input.nextInt();
		
		long[] sumArray=new long[n+1];
		for(int i=1;i<=n;++i)
		{
			sumArray[i]=input.nextInt()+sumArray[i-1];
		}
		
		for(int loop=0;loop<m;++loop)
		{
			input.next();
			int start=input.nextInt(),length=input.nextInt();
			System.out.println(sumArray[start+length-1]-sumArray[start-1]);
		}
	}
}
