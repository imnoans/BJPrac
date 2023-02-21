import java.io.*;

public class Main
{
    static Integer[] done;

    static int count = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        done = new Integer[n + 1];

        tiling(n);

        bw.write("" + done[n]);
        bw.close();
    }

    public static void tiling(int v)
    {
        if(v < 0)
        {
            return;
        }
        if(v == 0)
        {
            count++;
            return;
        }

        if(done[v] != null)
        {
            count += done[v];
            return;
        }

        tiling(v - 1);
        tiling(v - 2);

        done[v] = count %= 10007;
    }
}