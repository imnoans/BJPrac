import java.io.*;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t, a, b;
        do {
            t = Integer.parseInt(bf.readLine());
        }while(t < 1 || t > 1000000);

        for(int i = 0; i < t; i++)
        {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            if(a > 1000 || a < 1)
            {
                i--;
                continue;
            }
            b = Integer.parseInt(st.nextToken());
            if(b > 1000 || b < 1)
            {
                i--;
                continue;
            }
            bw.write((a + b) + "\n");
        }
        bw.flush();
        bw.close();
    }
}