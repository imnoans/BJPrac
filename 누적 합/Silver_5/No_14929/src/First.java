import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;

        n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] sum = new int[n + 1];
        long total = 0;

        sum[0] = 0;
        StringTokenizer sx = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            x[i - 1] = Integer.parseInt(sx.nextToken());
            sum[i] = sum[i - 1] + x[i - 1];
        }

        for (int i = 1; i <= n; i++)
        {
            total = total + x[i] * sum[i];
        }


        bw.write("" + total + "\n");

        bw.flush();
        bw.close();
    }
}