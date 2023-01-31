import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int a, b, sum = 0, count = 0;

        ArrayList<Integer> dwarf = new ArrayList<>();

        for(int i = 0; i < 9; i++)
        {
            a = Integer.parseInt(br.readLine());
            dwarf.add(a);
            count += a;
        }

        Collections.sort(dwarf);
        count -= 100;

        for(int i = 0; i < 8; i++)
        {
            a = dwarf.get(i);
            for(int j = i + 1; j < 9; j++)
            {
                b = dwarf.get(j);
                sum = a + b;

                if(sum == count)
                {
                    dwarf.remove(j);
                    dwarf.remove(i);
                    break;
                }

            }
            if(sum == count)
            {
                break;
            }

        }

        for(int i : dwarf)
        {
            sb.append(i + "\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}