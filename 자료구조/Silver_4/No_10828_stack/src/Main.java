import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n, a;
        String str;

        Stack<Integer> stack = new Stack<>();

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

            if(str.equals("push"))
            {
                a = Integer.parseInt(st.nextToken());
                stack.push(a);
            }
            else if(str.equals("pop"))
            {
                if(stack.isEmpty())
                {
                    sb.append("-1\n");
                }
                else
                {
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if(str.equals("size"))
            {
                sb.append(stack.size()).append("\n");
            }
            else if(str.equals("empty"))
            {
                if(stack.isEmpty())
                {
                    sb.append("1\n");
                }
                else
                {
                    sb.append("0\n");
                }
            }
            else if(str.equals("top"))
            {
                if(stack.isEmpty())
                {
                    sb.append("-1\n");
                }
                else
                {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}