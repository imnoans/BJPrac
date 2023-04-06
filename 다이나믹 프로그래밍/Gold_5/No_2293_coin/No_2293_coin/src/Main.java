import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] results = new int[n + 1];
        int[] S = new int[m];


        for (int i = 0; i < m; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        results[0] = 1;

        int result = coin(n, m, results, S);

        bw.write("" + result);
        bw.close();

    }

    static int coin(int n, int m, int[] results, int[] S)
    {
        for(int i = 0; i < m; i++)
        {
            for(int j = S[i]; j <= n; j++)
            {
                results[j] += results[j - S[i]];
            }
        }
        return results[n];
    }

}