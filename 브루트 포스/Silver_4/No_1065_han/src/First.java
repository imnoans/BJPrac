import java.io.*;
import java.util.ArrayList;

public class First
{
    public static boolean[] pos;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int count = 0;
        pos = new boolean[size + 1];

        for(int i = 1; i <= size; i++)
        {
            find(i);
        }

        for(int i = 1; i <= size; i++)
        {
            if(!pos[i])
            {
                count++;
            }
        }

        bw.write("" + count);
        bw.close();

    }

    public static void find(int v)
    {
        int num = v;
        ArrayList<Integer> arr = new ArrayList<>();

        if(v < 10)
        {
            return;
        }

        while(num > 0)
        {
            arr.add(num % 10);
            num /= 10;
        }


        num = arr.get(1) - arr.get(0);
        for(int i = 1; i < arr.size() - 1; i++)
        {
            if(num != arr.get(i + 1) - arr.get(i))
            {
                pos[v] = true;
                return;
            }
        }

    }
}