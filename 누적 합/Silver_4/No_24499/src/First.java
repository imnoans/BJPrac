import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, k;
        int sum = 0, max = 0;

        StringTokenizer snk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snk.nextToken());
        k = Integer.parseInt(snk.nextToken());

        int[] a = new int[n];
        StringTokenizer sa = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(sa.nextToken());
        }

        for(int i = 0; i < n + k - 1; i++)
        {
            if(i < k)
            {
                sum += a[i];
            }
            else if(i < n)
            {
                sum += a[i];
                sum -= a[i - k];
            }
            else {
                sum -= a[i - k];
                sum += a[i - n];
            }

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