import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;

        n = Integer.parseInt(br.readLine());

        for(int i =0; i < n; i++)
        {
            int t;
            t = Integer.parseInt(br.readLine());
            int[] x = new int[t];

            StringTokenizer sx = new StringTokenizer(br.readLine());
            for(int j = 0; j < t; j++)
            {
                x[j] = Integer.parseInt(sx.nextToken());
            }

            int max = x[0];
            for(int j = 0; j < t; j++)
            {
                int sum = 0;
                for(int k = j; k < t; k++)
                {
                    sum = sum + x[k];
                    if(sum > max)
                    {
                        max = sum;
                    }
                }
            }
            bw.write("" + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}