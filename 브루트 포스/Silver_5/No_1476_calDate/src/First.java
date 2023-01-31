import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int e, s, m, a = 0, b = 0, c = 0, count = 0;
        StringTokenizer sesm = new StringTokenizer(br.readLine());
        e = Integer.parseInt(sesm.nextToken());
        s = Integer.parseInt(sesm.nextToken());
        m = Integer.parseInt(sesm.nextToken());

        while(true)
        {
            a++;
            if(a == 16)
            {
                a = 1;
            }

            b++;
            if(b == 29)
            {
                b = 1;
            }

            c++;
            if(c == 20)
            {
                c = 1;
            }

            count++;

            if(e == a && s == b && m == c)
            {
                break;
            }
        }

        bw.write("" + count);
        bw.close();

    }
}