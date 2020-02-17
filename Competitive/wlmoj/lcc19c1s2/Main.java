import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int nTwo=n*2;
		int[][] grid=new int[nTwo][nTwo];
		
		for(int i=0;i<nTwo;++i)
		{
			for(int j=0;j<nTwo;++j)
			{
				grid[i][j]=input.nextInt();
			}
		}
		
		int result=0;
		for(int layer=0;layer<n;++layer)
		{
			int min=0x3f3f3f3f;
			for(int j=layer;j<nTwo-layer;++j)
			{
				if(grid[layer][j]<min) min=grid[layer][j];
			}
			for(int j=layer;j<nTwo-layer;++j)
			{
				if(grid[nTwo-layer-1][j]<min) min=grid[nTwo-layer-1][j];
			}
			for(int i=layer;i<nTwo-layer;++i)
			{
				if(grid[i][layer]<min) min=grid[i][layer];
			}
			for(int i=layer;i<nTwo-layer;++i)
			{
				if(grid[i][nTwo-layer-1]<min) min=grid[i][nTwo-layer-1];
			}
			result+=min;
		}
		System.out.println(result);
	}
}
