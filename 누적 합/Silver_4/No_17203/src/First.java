import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, q;

        StringTokenizer snq = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snq.nextToken());
        q = Integer.parseInt(snq.nextToken());

        int[] a = new int[n];
        StringTokenizer sa = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            a[i] = Integer.parseInt(sa.nextToken());
        }

        for(int k = 0; k < q; k++)
        {
            int i, j, sum = 0;
            StringTokenizer sij = new StringTokenizer(br.readLine());
            i = Integer.parseInt(sij.nextToken());
            j = Integer.parseInt(sij.nextToken());

            for (int s = i; s < j; s++)
            {
                sum = sum + Math.abs(a[s] - a[s - 1]);
            }

            bw.write("" + sum + "\n");
            bw.flush();

        }

        bw.close();
    }
}