import java.io.*;

public class First
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] mush = new int[10];
        int pre, post, count = 1;
        for(int i = 0; i < mush.length; i++)
        {
            do{
                mush[i] = Integer.parseInt(bf.readLine());
            }while(mush[i] < 1 || mush[i] > 100);
        }

        post = mush[0];

        do{
            pre = post;
            post = pre + mush[count];
            count++;
            if(count == 10)
            {
                if(Math.abs(pre - 100) > Math.abs(post - 100))
                {
                    pre = post;
                }

                break;

            }
        }while(Math.abs(pre - 100) > Math.abs(post - 100));

        if(Math.abs(pre - 100) == Math.abs(post - 100))
        {
            pre = post;
        }

        bw.write("" + pre);

        bw.flush();
        bw.close();
    }
}