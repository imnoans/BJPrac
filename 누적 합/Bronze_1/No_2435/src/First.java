import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, k, max;
        ArrayList<Integer> temper = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            temper.add(Integer.parseInt(st1.nextToken()));
        }

        max = -10000;

        for(int j = 0; j <= n - k; j++)
        {
            sum.add(0);
            for(int l = j; l < j + k; l++)
            {
                sum.set(j, sum.get(j) + temper.get(l));
            }
            if(sum.get(j) > max)
            {
                max = sum.get(j);
            }
        }

        bw.write("" + max);

        bw.flush();
        bw.close();


    }
}