import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m, k, i, j, x, y, sum = 0;

        StringTokenizer nm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(nm.nextToken());
        m = Integer.parseInt(nm.nextToken());

        int[][] arr = new int[n][m];

        for(int q = 0; q < n; q++)
        {
            StringTokenizer inArr = new StringTokenizer(br.readLine());
            for(int w = 0; w < m; w++)
            {
                arr[q][w] = Integer.parseInt(inArr.nextToken());
            }
        }

        k = Integer.parseInt(br.readLine());

        for(int e = 0; e < k; e++)
        {
            sum = 0;
            StringTokenizer inIJXY = new StringTokenizer(br.readLine());
            i = Integer.parseInt(inIJXY.nextToken());
            j = Integer.parseInt(inIJXY.nextToken());
            x = Integer.parseInt(inIJXY.nextToken());
            y = Integer.parseInt(inIJXY.nextToken());
            for(int r = i - 1; r <= x - 1; r++)
            {
                for(int t = j - 1; t <= y - 1; t++)
                {
                    sum = sum + arr[r][t];
                }
            }
            bw.write("" + sum + "\n");
        }
        bw.flush();
        bw.close();


    }
}