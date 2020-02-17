import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int q=input.nextInt();
        if(q==0)
        {
            System.out.println(1);
            return;
        }
        
        int n=0;
	    int zeros=0;
	    
	    while(zeros<q)
	    {
		    n+=5;
		    int tmp=n;
		    while(tmp%5==0)
		    {
			    tmp/=5;
			    ++zeros;
		    }
	    }
	    if(zeros==q) System.out.println(n);
	    else System.out.println("No solution");
    }
}
