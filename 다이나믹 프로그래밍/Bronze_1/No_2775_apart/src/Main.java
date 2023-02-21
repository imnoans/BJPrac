import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[][] tcase = new int[t][2];
        int[] max = new int[2];
        int count;
        for(int i = 0; i < t; i++)
        {
            tcase[i][0] = Integer.parseInt(br.readLine());
            tcase[i][1] = Integer.parseInt(br.readLine());
            max[0] = Math.max(max[0], tcase[i][0]);
            max[1] = Math.max(max[1], tcase[i][1]);
        }

        int[][] apart = new int[max[0] + 1][max[1] + 1]; // 층 / 호

        for(int i = 1; i < max[1] + 1; i++)
        {
            apart[0][i] = i;
        }

        for(int i = 1; i < max[0] + 1; i++)
        {
            count = 0;
            for(int j = 1; j < max[1] + 1; j++)
            {
                count += apart[i - 1][j];
                apart[i][j] = count;
            }
        }

        for(int i = 0; i < t; i++)
        {
            sb.append(apart[tcase[i][0]][tcase[i][1]]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}