import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	static long to_unique(String str)
	{
		int[] id=new int[200];
		int i=1;
		long res=0;

		for(int j=0;j<str.length();++j)
		{
		    if(id[str.charAt(j)]==0)
		    {
		        id[str.charAt(j)]=i;
		        ++i;
		    }
		    res*=100;
		    res+=id[str.charAt(j)];
		}

		return res;
	}

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		input.nextLine();
		
		long[] codes=new long[n];
		for(int i=0;i<n;++i)
		{
		    String s=input.nextLine();
		    codes[i]=to_unique(s);
		}
		
		Arrays.sort(codes);
		
		long current_type=0, num_in_type=0, total=0;

		for(int i=0;i<n;++i)
		{
		    if(codes[i]!=current_type)
		    {
		        total+=num_in_type*(num_in_type-1)/2;
		        num_in_type=0;
		        current_type=codes[i];
		    }

		    ++num_in_type;
		}
		total+=num_in_type*(num_in_type-1)/2;

		System.out.println(total);
	}
}
