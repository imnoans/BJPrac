import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int five, three, remain;
        boolean pos = false;
        n = Integer.parseInt(br.readLine());
        five = n / 5;
        three = 0;
        remain = n % 5;
        while(five >= 0)
        {
            if(remain % 3 == 0)
            {
                three = remain / 3;
                pos = true;
                break;
            }
            five--;
            remain += 5;
        }

        if(pos)
        {
            bw.write("" + (five + three));
        }
        else
        {
            bw.write("-1");
        }
        bw.close();
    }
}