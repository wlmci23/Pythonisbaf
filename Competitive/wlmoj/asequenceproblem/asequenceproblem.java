import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class asequenceproblem
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		List<Integer> inputList=new ArrayList<Integer>();
		
		for(int loop=0;loop<n;++loop)
		{
			inputList.add(input.nextInt());
		}
		
		Collections.sort(inputList);
		
		int minDifference=0x3f3f3f3f;
		
		for(int i=1;i<n;++i)
		{
			if(inputList.get(i)-inputList.get(i-1)<minDifference) minDifference=inputList.get(i)-inputList.get(i-1);
		}
		System.out.println(minDifference);
	}
}
