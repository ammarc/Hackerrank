import java.io.*;
import java.util.*;

public class bfs_short_reach
{
	public static void main (String args[])
	{
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		
		for (int i = 0; i < q; i++)
		{
			int n = in.nextInt();
			int e = in.nextInt();
            int[] dist = new int[n + 1];
			Arrays.fill(dist, -1);

			ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();

			// Let us initialize our linked list
			for (int j = 0; j <= n; j++)
				adj.add(new LinkedList<Integer>());

			// Now let us fill the adjacency list
			for (int j = 0; j < e; j++)
			{
				int u = in.nextInt();
				int v = in.nextInt();
				
				adj.get(v).add(u);
				adj.get(u).add(v);
			}

			// Let us take in the trailing input for the starting node
			int s = in.nextInt();

			// Now that we have the input and the graph
			// we can perform BFS on it
			bfs(adj, s, dist);
            System.out.println();
		}
	}

	public static void bfs(ArrayList<LinkedList<Integer>> adj, int s, int[] dist)
	{
		LinkedList<Integer> q = new LinkedList<Integer>();
        
		q.add(s);
	
        
        dist[s] = 0;

		while (q.isEmpty() !=  true)
		{
			int current = q.remove();
         
			for (int i : adj.get(current))
			{
                
				if (dist[i] == -1)
				{
					dist[i] = dist[current] + 6;
					q.add(i);
                }
                   
				
				// Let us now check if the distance is smaller
				//dist[i] = dist[i] < dist[i] + 6 ? dist[i] + 6 : dist[i];
			}
		}
       
        
        for (int j = 1; j < dist.length; j++)
            if(j != s)
				System.out.printf("%d ", dist[j]);
	}
}
