import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int plusNumbers = 0;
        int minusNumbers = 0;
        StringBuilder sb = new StringBuilder();

        boolean isMinus = false;

        String target = br.readLine();

        for(char c : target.toCharArray())
        {
            if(!isMinus)
            {
                if(Character.isDigit(c))
                {
                    sb.append(c);
                }
                else if(c == '+')
                {
                    plusNumbers += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
                else
                {
                    plusNumbers += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    isMinus = true;
                }
            }
            else
            {
                if(Character.isDigit(c))
                {
                    sb.append(c);
                }
                else
                {
                    minusNumbers += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if(isMinus)
        {
            minusNumbers += Integer.parseInt(sb.toString());
        }
        else
        {
            plusNumbers += Integer.parseInt(sb.toString());
        }
        bw.write("" + (plusNumbers - minusNumbers));
        bw.close();
    }
}