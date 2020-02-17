import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		List<Integer> input0=new ArrayList<Integer>();
		List<Integer> input1=new ArrayList<Integer>();
		List<Integer> input2=new ArrayList<Integer>();
		
		for(int i=0;i<n;++i)
		{
			int k=input.nextInt();
			if(i%3==0) input0.add(k);
			else if(i%3==1) input1.add(k);
			else input2.add(k);
		}
		
		Collections.sort(input0);
		Collections.sort(input1);
		Collections.sort(input2);
		
		for(int i=0;i<n;++i)
		{
			int k;
			if(i%3==0) k=input0.get(i/3);
			else if(i%3==1) k=input1.get(i/3);
			else k=input2.get(i/3);
			
			System.out.printf("%d ",k);
		}
		System.out.println();
	}
}
