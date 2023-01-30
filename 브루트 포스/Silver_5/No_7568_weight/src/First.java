import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int head = Integer.parseInt(br.readLine());
        ArrayList<Wh> heads = new ArrayList<>();
        Wh who;
        int[] ranked = new int[head];

        int w, h;
        for(int i = 0; i < head; i++)
        {
            StringTokenizer swh = new StringTokenizer(br.readLine());
            w = Integer.parseInt(swh.nextToken());
            h = Integer.parseInt(swh.nextToken());
            heads.add(new Wh(w, h));
        }


        for(int i = 0; i < head; i++)
        {
            who = heads.remove(0);
            for(Wh j : heads)
            {
                who.calRank(j);
                j.calRank(who);
            }
            ranked[i] = who.rank;
        }

        for(int i : ranked)
        {
            sb.append(i + " ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}

class Wh
{
    public int weight;

    public int height;

    public int rank;

    public Wh(int weight, int height)
    {
        this.weight = weight;
        this.height = height;
        this.rank = 1;
    }

    public void calRank(Wh other)
    {
        if(this.weight < other.weight && this.height < other.height)
        {
            this.rank++;
        }
    }
}