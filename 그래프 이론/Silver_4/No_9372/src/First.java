import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        int t, n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++)
        {
            StringTokenizer snm = new StringTokenizer(br.readLine());
            n = Integer.parseInt(snm.nextToken());
            m = Integer.parseInt(snm.nextToken());

            byte arr[][] = new byte[n + 1][n + 1];
            int a, b;
            for(int j = 0; j < m; j++)
            {
                StringTokenizer sab = new StringTokenizer(br.readLine());
                a = Integer.parseInt(sab.nextToken());
                b = Integer.parseInt(sab.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            bw.write(n - 1 + "\n");
        }
        bw.flush();
        bw.close();
    }
}