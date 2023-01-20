import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int a, b;

        n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        for(int i = 1; i < n + 1; i++)
        {
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++)
        {
            StringTokenizer sab = new StringTokenizer(br.readLine());
            a = Integer.parseInt(sab.nextToken());
            b = Integer.parseInt(sab.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1, arr, visited, parent);

        for(int i = 2; i < n + 1; i++)
        {
            bw.write("" + parent[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static void dfs(int v, ArrayList<Integer>[] arr, boolean[] visited, int[] parent)
    {
        visited[v] = true;
        for(int i : arr[v])
        {
            if(!visited[i])
            {
                parent[i] = v;
                dfs(i, arr, visited, parent);
            }
        }
    }
}