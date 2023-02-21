import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int n, m;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0);

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int count)
    {
        if(count == m)
        {
            for(int i = 0; i < m; i++)
            {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++)
        {
            arr[count] = i + 1;
            dfs(count + 1);
        }
    }
}