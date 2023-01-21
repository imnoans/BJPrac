import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static int res = -1;

    public static ArrayList<Integer>[] arr;

    public static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, start, end, m, x, y, count = 0;

        n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++)
        {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer spc = new StringTokenizer(br.readLine());
        start = Integer.parseInt(spc.nextToken());
        end = Integer.parseInt(spc.nextToken());

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++)
        {
            StringTokenizer sxy = new StringTokenizer(br.readLine());
            x = Integer.parseInt(sxy.nextToken());
            y = Integer.parseInt(sxy.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        dfs(start, end, count);

        bw.write("" + res);
        bw.flush();
        bw.close();
    }

    public static void dfs(int v, int end, int count)
    {
        if(res != -1)
        {
            return;
        }
        if(v == end)
        {
            res = count;
            return;
        }
        visited[v] = true;
        for(int i : arr[v])
        {
            if(!visited[i])
            {
                dfs(i, end, count + 1);
            }
        }
    }

}