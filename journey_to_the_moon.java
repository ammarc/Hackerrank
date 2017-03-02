/* Code by Ammar Ahmed */
import java.io.*;
import java.util.*;
import java.math.*;


public class journey_to_the_moon
{
    public static int count = 0;

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
           Your class should be named Solution. */

        // Let us take in the input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] adj = new int[n][];
        int a, b;
        BigInteger all_comb = new BigInteger(((BigInteger.valueOf(((Integer)(n)).intValue()).multiply(BigInteger.valueOf(((Integer)((n - 1))).intValue()))).divide(BigInteger.valueOf(((Integer)2).intValue()))).toString());


        // Initialize the adj array
        for (int i = 0; i < p; i++)
        {
            a = in.nextInt();
            b = in.nextInt();

            if(adj[a] == null)
            {
                adj[a] = new int[n];
                for (int j = 0; j < n; j++)
                {
                    adj[a][j] = 0;
                }
            }

            if(adj[b] == null)
            {
                adj[b] = new int[n];
                for (int j = 0; j < n; j++)
                {
                    adj[b][j] = 0;
                }
            }

            // fill up the adj matrix
            if (adj[a][b] == 0)
            {
                adj[a][b] = 1;
            }

            if (adj[b][a] == 0)
            {
                adj[b][a] = 1;
            }
        }

        ArrayList<Integer> country = dfs(adj, 0, n);

        if (country.size() > 1)
        {
            for (int i : country)
            {
                if(i > 1)
                {
                    all_comb = all_comb.subtract(combination(i, 2));
                }
            }
        }

        System.out.println(country.size() > 1 ? all_comb : 0);
    }

    public static ArrayList<Integer> dfs(int[][] adj, int node, int n)
    {
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        ArrayList<Integer> country = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
        {
            count = 0;
            if (visited[i] == 0)
            {
                visited[i] = 1;
                count++;
                if(adj[i] != null)
                    explore(adj, i, n, visited);
                country.add(count);
            }
        }

        return country;
    }

    public static void explore(int[][] adj, int i, int n, int[] visited)
    {
        for (int j = 0; j < n; j++)
        {
            if (adj[i] != null && adj[i][j] == 1 && visited[j] == 0)
            {
                visited[j] = 1;
                count++;
                explore (adj, j, n, visited);
            }
        }
    }

    public static BigInteger combination(int n, int k)
    {
        if(n == 2 && k == 2)
            return new BigInteger("1");
        if( k == 2)
            return new BigInteger((BigInteger.valueOf(((Integer)(n*(n-1)/2)).intValue())).toString());
        // System.out.println(n + " " + k);
        // System.out.println(n + "        " + k + "   " + permutation(n) + "   " + permutation(n - k));
        return permutation(n).divide((permutation(k).multiply(permutation(n - k))));
    }

    public static BigInteger permutation(int i)
    {
        if (i <= 1)
        {
            return new BigInteger("1");
        }
        BigInteger fact = new BigInteger(((BigInteger.valueOf(((Integer)i).intValue())).multiply(permutation(i - 1))).toString());
        return fact;
    }
}
