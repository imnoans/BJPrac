import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        long total = 0;
        n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        long[] sum = new long[n + 1];

        sum[0] = 0;
        StringTokenizer sx = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
        {
            x[i - 1] = Integer.parseInt(sx.nextToken());
            sum[i] = sum[i - 1] + x[i - 1];
        }

        for(int i = 1; i < n; i++)
        {
            total = total + sum[i] * x[i];
        }

        bw.write("" + total + "\n");

        bw.flush();
        bw.close();
    }
}