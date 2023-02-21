import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int n, start, count;
        boolean skip;
        int[] arr = new int[11];
        ArrayList<Integer> memory = new ArrayList<>();
        arr[4] = 7;
        memory.add(4);

        Queue<Integer> cal = new LinkedList<>();

        for (int i = 0; i < t; i++)
        {
            count = 0;
            skip = false;
            start = Integer.parseInt(br.readLine());
            cal.add(start);
            while(!cal.isEmpty())
            {
                n = cal.poll();
                if(n == 0)
                {
                    count++;
                    continue;
                }

                for(int j : memory)
                {
                    if(n == j)
                    {
                        count += arr[j];
                        skip = true;
                        break;
                    }
                }

                if(skip)
                {
                    skip = false;
                    continue;
                }

                if(n - 3 >= 0)
                {
                    cal.add(n - 3);
                }
                if(n - 2 >= 0)
                {
                    cal.add(n - 2);
                }
                if(n - 1 >= 0)
                {
                    cal.add(n - 1);
                }
            }
            arr[start] = count;
            memory.add(start);
            sb.append(count + "\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}