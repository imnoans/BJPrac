import java.io.*;

public class First
{
    public static boolean[] visited;
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited = new boolean[10001];

        for(int i = 1; i < 10001; i++)
        {
            if(visited[i])
            {
                continue;
            }
            find(i);
        }

        for(int i = 1; i < 10001; i++)
        {
            if(!visited[i])
            {
                sb.append(i).append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }

    public static void find(int v)
    {
        int value = v;
        int num = v;

        while (num >0) {
            value += num%10;
            num /= 10;
        }

        if(value > 10000 || visited[value])
        {
            return;
        }
        visited[value] = true;
        find(value);
    }
}