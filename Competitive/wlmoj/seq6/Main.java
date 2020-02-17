import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		Set<Integer> unique=new HashSet<Integer>();
		
		for(int loop=0;loop<n;++loop)
		{
			if(!unique.add(input.nextInt()))
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}
