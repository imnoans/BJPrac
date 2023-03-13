import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main
{
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int a, b, preB, count = 1;


        n = Integer.parseInt(br.readLine());

        int[][] temp = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            temp[i][0] = a;
            temp[i][1] = b;
        }

        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        preB = temp[0][1];

        for (int i = 1; i < n; i++)
        {
            if (preB <= temp[i][0])
            {
                preB = temp[i][1];
                count++;
            }
        }

        bw.write("" + count);
        bw.close();
    }
}
