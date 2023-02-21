import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int count = 0;

        Queue<Integer> cal = new LinkedList<>();
        int[] arr = new int[x + 1];
        cal.add(x);
        while(true)
        {
            x = cal.poll();
            if(x == 1)
            {
                break;
            }
            count = arr[x] + 1;

            if(x < 1)
            {
                continue;
            }
            if(x % 3 == 0 && arr[x / 3] == 0)
            {
                cal.add(x / 3);
                arr[x / 3] = count;
            }
            if(x % 2 == 0 && arr[x / 2] == 0)
            {
                cal.add(x / 2);
                arr[x / 2] = count;
            }
            if(arr[x - 1] == 0)
            {
                cal.add(x - 1);
                arr[x - 1] = count;
            }
        }

        bw.write("" + arr[1]);
        bw.close();
    }
}