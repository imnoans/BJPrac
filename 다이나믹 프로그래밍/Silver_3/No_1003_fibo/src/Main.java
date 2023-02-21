import java.io.*;

public class Main
{
    static Integer[][] memory;

    static int[] count;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int max = 0;
        int[] n = new int[t];
        count = new int[2];

        for(int i = 0; i < t; i++)
        {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, n[i]);
        }

        memory = new Integer[max + 2][2];


        memory[0][0] = 1;
        memory[0][1] = 0;
        memory[1][0] = 0;
        memory[1][1] = 1;

        for(int i : n)
        {
            count[0] = 0;
            count[1] = 0;
            fibonacci(i);
            sb.append(count[0]).append(" ").append(count[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static void fibonacci(int n)
    {

        if(memory[n][0] != null || memory[n][1] != null)
        {
            count[0] += memory[n][0];
            count[1] += memory[n][1];
            return;
        }
        if (n == 0)
        {
            count[0]++;
        }
        else if (n == 1)
        {
            count[1]++;
        }
        else
        {
            fibonacci(n - 1);
            fibonacci(n - 2);
        }

        memory[n][0] = count[0];
        memory[n][1] = count[1];
    }
}