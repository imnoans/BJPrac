import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static boolean[][] chessBoard;
    public static int min = 64;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;

        StringTokenizer snm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snm.nextToken());
        m = Integer.parseInt(snm.nextToken());

        chessBoard = new boolean[n][m];

        for(int i = 0; i < n; i++)
        {
            String row = br.readLine();
            for(int j = 0; j < m; j++)
            {
                if(row.charAt(j) == 'W')
                {
                    chessBoard[i][j] = true;
                }
            }
        }

        find(0, 0);
        for(int i = 0; i < n - 7; i++)
        {
            for(int j = 0; j < m - 7; j++)
            {
                find(i, j);
            }
        }


        bw.write("" + min);
        bw.close();
    }

    public static void find(int x, int y)
    {
        int count = 0;
        boolean first = chessBoard[x][y];

        for(int i = 0; i < 8; i++)
        {
            first = !first;
            for(int j = 0; j < 8; j++)
            {
                first = !first;
                if(chessBoard[x + i][y + j] != first)
                {
                    count++;
                }
            }
        }

        count = Math.min(count, 64 - count);

        min = Math.min(count, min);
    }

}

