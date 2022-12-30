import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;

        StringTokenizer snm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snm.nextToken());
        m = Integer.parseInt(snm.nextToken());
        int[] x = new int[n];
        long max = 0, sum = 0;
        StringTokenizer sx = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            x[i] = Integer.parseInt(sx.nextToken());

            if (i >= m) {
                sum -= x[i - m];
            }
            sum += x[i];
            if(sum > max)
            {
                max = sum;
            }
        }
        bw.write("" + max + "\n");

        bw.flush();
        bw.close();
    }
}