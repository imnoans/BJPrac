import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t, m, n, k;

        t = Integer.parseInt(br.readLine());

        for(int q = 0; q < t; q++)
        {
            StringTokenizer snmk = new StringTokenizer(br.readLine());
            int a, b, count = 0;

            m = Integer.parseInt(snmk.nextToken());
            n = Integer.parseInt(snmk.nextToken());
            k = Integer.parseInt(snmk.nextToken());

            byte[][] arr = new byte[m][n];

            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < k; i++)
            {
                StringTokenizer sab = new StringTokenizer(br.readLine());
                a = Integer.parseInt(sab.nextToken());
                b = Integer.parseInt(sab.nextToken());

                arr[a][b] = 1;
            }

            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(!visited[i][j] && arr[i][j] == 1)
                    {
                        count++;
                        find(i, j, arr, visited);
                    }
                }
            }

            bw.write("" + count + "\n");

        }

        bw.flush();
        bw.close();
    }

    static public void find(int i, int j, byte[][] arr, boolean[][] visited)
    {
        visited[i][j] = true;
        if(i + 1 < arr.length && arr[i + 1][j] == 1 && !visited[i + 1][j])
        {
            find(i + 1, j, arr, visited);
        }
        if(j + 1 < arr[i].length && arr[i][j + 1] == 1 && !visited[i][j + 1])
        {
            find(i, j + 1, arr, visited);
        }
        if(i - 1 >= 0 && arr[i - 1][j] == 1 && !visited[i - 1][j])
        {
            find(i - 1, j, arr, visited);
        }
        if(j - 1 >= 0 && arr[i][j - 1] == 1 && !visited[i][j - 1])
        {
            find(i, j - 1, arr, visited);
        }
    }
}