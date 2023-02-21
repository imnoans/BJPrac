import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] nums;
    public static boolean[] visited;
    public static int n, m;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        nums = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0,0);

        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int v, int count)
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

        for(int i = v; i < n; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                arr[count] = nums[i];
                dfs(i,count + 1);
                visited[i] = false;
            }
        }
    }
}