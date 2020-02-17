import java.lang.Math;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		
		int minCost=0,threes=0,fours=0;
		for(int loop=0;loop<n;++loop)
		{
			double dollars=input.nextDouble();
			int cents=(int)Math.round(dollars*100);
			minCost+=cents/5*5;
			cents%=5;
			if(cents==3) ++threes;
			else if(cents==4) ++fours;
		}
		
		if(threes<=fours)
		{
			minCost+=threes*5;
			fours-=threes;
			threes=0;
		}
		else
		{
			minCost+=fours*5;
			threes-=fours;
			fours=0;
		}
		
		if(threes>0)
		{
			minCost+=(threes/2)*5;
			minCost+=(threes%2)*5;
		}
		else if(fours>0)
		{
			minCost+=(fours/3)*10;
			minCost+=(fours%3)*5;
		}
		
		System.out.printf("%d.%02d\n",minCost/100,minCost%100);
	}
}
