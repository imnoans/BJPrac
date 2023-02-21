import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int max = arr[0];
        int limit;

        for(int i = 1; i < n; i++)
        {
            limit = arr[i];
            max = Math.max(limit * (i + 1), max);
        }

        bw.write("" + max);
        bw.close();
    }
}