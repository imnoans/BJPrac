import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class First
{
    public static int n, m, v;
    public static byte[][] arr;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer snmv = new StringTokenizer(br.readLine());

        n = Integer.parseInt(snmv.nextToken());
        m = Integer.parseInt(snmv.nextToken());
        v = Integer.parseInt(snmv.nextToken());

        arr = new byte[n + 1][n + 1];

        for(int i = 0; i < m; i ++)
        {
            int a, b;
            StringTokenizer sab = new StringTokenizer(br.readLine());
            a = Integer.parseInt(sab.nextToken());
            b = Integer.parseInt(sab.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        boolean[] visited = new boolean[n + 1];
        DFS(v, visited);
        sb.append("\n");

        visited = new boolean[n + 1];
        BFS(visited);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void BFS(boolean[] visited)
    {
        Queue<Integer> bfs = new LinkedList<>();
        visited[v] = true;
        bfs.add(v);
        int num;

        while(!bfs.isEmpty())
        {
            num = bfs.poll();
            sb.append(num + " ");
            for(int i = 1; i < n + 1; i ++)
            {
                if(arr[num][i] == 1 && !visited[i])
                {
                    bfs.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void DFS(int v, boolean visited[])
    {
        sb.append(v + " ");
        visited[v] = true;
        for(int i = 1; i < n + 1; i ++)
        {
            if(arr[v][i] == 1 && !visited[i])
            {
                DFS(i, visited);
            }
        }
    }
}