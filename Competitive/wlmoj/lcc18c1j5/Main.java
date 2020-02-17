import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

class Coord
{
	int i,j;
	Coord(int _x,int _y)
	{
		i=_x;
		j=_y;
	}
	
	static boolean inBounds(Coord c,int n)
	{
		if(c.i>=0&&c.j>=0&&c.i<n&&c.j<n) return true;
		else return false;
	}
	
	boolean equals(Coord other)
	{
		return i==other.i&&j==other.j;
	}
}

class Maze
{
	private char[][] mazeGrid;
	private int mazeLength;
	private Coord start,end;
	
	Maze(int n)
	{
		mazeGrid=new char[n][n];
		mazeLength=n;
	}
	
	void getInput(Scanner input)
	{
		for(int i=0;i<mazeLength;++i)
		{
			String row=input.nextLine();
			for(int j=0;j<mazeLength;++j)
			{
				mazeGrid[i][j]=row.charAt(j);
				if(mazeGrid[i][j]=='S') start=new Coord(i,j);
				else if(mazeGrid[i][j]=='E') end=new Coord(i,j);
			}
		}
	}
	
	int solve()
	{
		final int INF=0x3f3f3f3f;
		
		int[][] mazeDistances=new int[mazeLength][mazeLength];
		for(int i=0;i<mazeLength;++i)
		{
			for(int j=0;j<mazeLength;++j)
			{
				mazeDistances[i][j]=INF;
			}
		}
		mazeDistances[start.i][start.j]=0;
		
		Queue<Coord> bfsQueue=new ArrayDeque<Coord>();
		bfsQueue.add(start);
		
		while(!bfsQueue.isEmpty())
		{
			Coord u=bfsQueue.remove();
			
			Coord v=new Coord(u.i,u.j+1);
			if(Coord.inBounds(v,mazeLength)&&mazeGrid[v.i][v.j]!='#'&&mazeDistances[v.i][v.j]==INF)
			{
				bfsQueue.add(v);
				mazeDistances[v.i][v.j]=mazeDistances[u.i][u.j]+1;
				if(v.equals(end)) break;
			}
			v=new Coord(u.i,u.j-1);
			if(Coord.inBounds(v,mazeLength)&&mazeGrid[v.i][v.j]!='#'&&mazeDistances[v.i][v.j]==INF)
			{
				bfsQueue.add(v);
				mazeDistances[v.i][v.j]=mazeDistances[u.i][u.j]+1;
				if(v.equals(end)) break;
			}
			v=new Coord(u.i+1,u.j);
			if(Coord.inBounds(v,mazeLength)&&mazeGrid[v.i][v.j]!='#'&&mazeDistances[v.i][v.j]==INF)
			{
				bfsQueue.add(v);
				mazeDistances[v.i][v.j]=mazeDistances[u.i][u.j]+1;
				if(v.equals(end)) break;
			}
			v=new Coord(u.i-1,u.j);
			if(Coord.inBounds(v,mazeLength)&&mazeGrid[v.i][v.j]!='#'&&mazeDistances[v.i][v.j]==INF)
			{
				bfsQueue.add(v);
				mazeDistances[v.i][v.j]=mazeDistances[u.i][u.j]+1;
				if(v.equals(end)) break;
			}
		}
		return mazeDistances[end.i][end.j];
	}
}

public class Main
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		input.nextLine();
		Maze maze=new Maze(n);
		maze.getInput(input);
		int res=maze.solve();
		if(res==0x3f3f3f3f) System.out.println("There is no path, Andy!");
		else System.out.println(res);
	}
}
