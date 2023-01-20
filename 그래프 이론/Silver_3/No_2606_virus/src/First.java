import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num, edge, a, b, count = 0;

        num = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[num + 1][num + 1];
        boolean[] visited = new boolean[num + 1];

        edge = Integer.parseInt(br.readLine());

        for(int i = 0; i < edge; i++)
        {
            StringTokenizer sab = new StringTokenizer(br.readLine());
            a = Integer.parseInt(sab.nextToken());
            b = Integer.parseInt(sab.nextToken());

            arr[a][b] = true;
            arr[b][a] = true;
        }

        Queue<Integer> bfs = new LinkedList<>();
        visited[1] = true;
        bfs.add(1);

        while (!bfs.isEmpty())
        {
            a = bfs.poll();
            for(int i = 1; i < num + 1; i++)
            {
                if(arr[a][i] && !visited[i])
                {
                    count++;
                    visited[i] = true;
                    bfs.add(i);
                }
            }
        }
        bw.write("" + count);
        bw.flush();
        bw.close();
    }
}