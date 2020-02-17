import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void dfs(int u,ArrayList<ArrayList<Integer>> adj,boolean[] visited)
	{
		visited[u]=true;
		ArrayList<Integer> adju=adj.get(u);
		for(int i=0;i<adju.size();++i)
		{
			if(!visited[adju.get(i)]) dfs(adju.get(i),adj,visited);
		}
	}
	
    public static ArrayList<ArrayList<Integer>> formAdj(int[] cards,int n)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n;++i)
        {
        	ArrayList<Integer> iadj=new ArrayList<Integer>();
            for(int j=0;j<n;++j)
            {
                if(i==j) continue;
                if(cards[i]%cards[j]==0||cards[j]%cards[i]==0)
                {
                    iadj.add(j);
                }
            }
            adj.add(iadj);
        }
        return adj;
    }

    public static boolean isConnected(ArrayList<ArrayList<Integer>> adj,int n)
    {
        boolean[] visited=new boolean[n];
        dfs(0,adj,visited);
        for(int i=0;i<n;++i)
        {
        	if(!visited[i]) return false;
        }
        return true;
    }
    
    public static boolean validOddVertices(ArrayList<ArrayList<Integer>> adj,int n)
    {
    	int odd=0;
    	for(int i=0;i<n;++i)
    	{
    		if(adj.get(i).size()%2==1) ++odd;
    	}
    	return odd==0||odd==2;
    }
    
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int t=input.nextInt();

        for(int loop=0;loop<t;++loop)
        {
            int n=input.nextInt(),k=input.nextInt();
            int[] cards=new int[n];
            for(int i=0;i<n;++i)
            {
                cards[i]=input.nextInt();
            }

            ArrayList<ArrayList<Integer>> adj=formAdj(cards,n);
            
            if(isConnected(adj,n)&&validOddVertices(adj,n)) System.out.println("Keep");
            else System.out.println("Discard");
        }
    }
}
