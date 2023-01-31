import java.io.*;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0, count = 0, num = 665;

        n = Integer.parseInt(br.readLine());

        while(count < n)
        {
            num++;
            if(String.valueOf(num).contains("666"))
            {
                count++;
            }
        }

        bw.write(String.valueOf(num));
        bw.close();
    }
}