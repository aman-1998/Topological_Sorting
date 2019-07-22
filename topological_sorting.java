import java.util.*;
import java.lang.*;

class topo
{
	int[][] G=new int[20][20];
	int[] indegree=new int[20];
	int[] queue=new int[20];
	void topological_sort(int n)
	{
		int u,i,f=0,r=-1;
		for(i=1;i<=n;i++)
		{
			if(indegree[i]==0)
			{
				r++;
				queue[r]=i;
			}
		}
		
		while(f<=r)
		{
			u=queue[f];
			f++;
			System.out.print(u+" ");
			for(i=1;i<=n;i++)
			{
				if(G[u][i]==1)
				{
					indegree[i]--;
					if(indegree[i]==0)
					{
						r++;
						queue[r]=i;
					}
				}
			}
		}
	}
	public static void main(String args[])
	{
		int i,j,choice;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of vertices: ");
		int n=in.nextInt();
		topo x=new topo();
		for(i=1;i<=n;i++)
			x.indegree[i]=0;
		/*
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print("Enter G["+i+"]["+j+"] : ");
				x.G[i][j]=in.nextInt();
				if(x.G[i][j]==1)
					x.indegree[j]++;
				if(x.G[i][j]!=0 && x.G[i][j]!=1)
				{
					System.out.println("Invalid Input");
					j--;
				}
			}
		}*/
		do
		{
			System.out.print("Enter starting and ending vertices: ");
			i=in.nextInt();
			j=in.nextInt();
			x.G[i][j]=1;
			x.indegree[j]++;
			System.out.print("Enter \'1\' to continue and any other key to quit: ");
			choice=in.nextInt();
		}
		while(choice==1);
		System.out.print("\nAdjacency Matrix: ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
				System.out.print(x.G[i][j]+" ");
			System.out.println();
		}
		System.out.print("\nTopological Sorting: ");
		x.topological_sort(n);
	}
}