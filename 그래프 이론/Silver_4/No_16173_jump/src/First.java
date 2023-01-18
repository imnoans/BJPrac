import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location
{
    public int row;
    public int col;
    public int power;

    public Location(int row, int col, int power)
    {
        this.row = row;
        this.col = col;
        this.power = power;
    }
}
public class First {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int colum[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];
        Queue<Location> canWin = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            StringTokenizer scol = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                colum[i][j] = Integer.parseInt(scol.nextToken());
            }
        }

        canWin.add(new Location(0, 0, colum[0][0]));

        while(!canWin.isEmpty())
        {
            Location go = canWin.poll();

            if(visited[go.row][go.col])
            {
                continue;
            }

            visited[go.row][go.col] = true;

            if(go.power == -1)
            {
                bw.write("HaruHaru");
                break;
            }
            if(n > go.row + go.power)
            {
                canWin.add(new Location(go.row + go.power, go.col, colum[go.row + go.power][go.col]));
            }

            if(n > go.col + go.power)
            {
                canWin.add(new Location(go.row, go.col + go.power, colum[go.row][go.col + go.power]));
            }
        }

        if(!visited[n - 1][n - 1])
        {
            bw.write("Hing");
        }

        bw.flush();
        bw.close();
    }
}
