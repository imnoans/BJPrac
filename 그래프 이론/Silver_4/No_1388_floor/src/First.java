import java.io.*;
import java.util.StringTokenizer;

public class First {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, m, count = 0;

        StringTokenizer snm = new StringTokenizer(br.readLine());
        n = Integer.parseInt(snm.nextToken());
        m = Integer.parseInt(snm.nextToken());

        char[][] floor = new char[n + 1][m + 1];

        floor[0][0] = 'a';

        for (int i = 0; i < n; i++) {
            floor[i + 1][0] = '|';
            String st = br.readLine();
            for (int j = 0; j < m; j++) {
                floor[0][j + 1] = '-';
                floor[i + 1][j + 1] = st.charAt(j);
            }
        }

        for(int i = 1; i < n + 1; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(floor[i][j] == '|' && floor[i][j + 1] == '-')
                {
                    count++;
                }
            }
        }


        for(int i = 1; i < m + 1; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(floor[j][i] == '-' && floor[j + 1][i] == '|')
                {
                    count++;
                }
            }
        }


        bw.write("" + count);
        bw.flush();
        bw.close();
    }
}

