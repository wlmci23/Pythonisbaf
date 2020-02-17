import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		int n,q;
		long val=0;
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		q=input.nextInt();
		
		int type,l,r,v;
		for(int loop=0;loop<q;++loop)
		{
			type=input.nextInt();
			if(type==1)
			{
				l=input.nextInt();
				r=input.nextInt();
				System.out.println((r-l+1)*val);
			}
			else if(type==2)
			{
				v=input.nextInt();
				val+=v;
			}
		}
	}
}
