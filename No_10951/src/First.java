import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int a, b;

        while((line = br.readLine()) != null && !line.isEmpty())
        {
            StringTokenizer st = new StringTokenizer(line);
            a = Integer.parseInt(st.nextToken());
            if(a <= 0)
            {
                continue;
            }

            b = Integer.parseInt(st.nextToken());
            if(b >= 10)
            {
                continue;
            }
            System.out.println(a + b);
        }
    }
}