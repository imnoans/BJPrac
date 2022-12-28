import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dice = new int[3];
        int result = 0;
        int max;

        for (int i = 0; i < dice.length; i++)
        {
            do
            {
                dice[i] = sc.nextInt();
            }while(dice[i] < 1 || dice[i] > 6);
        }

        max = dice[0];
        if(dice[0] == dice[1] && dice[1] == dice[2])
        {
            result = 10000 + dice[0] * 1000;
        }
        else if(dice[0] == dice [1])
        {
            result = 1000 + dice[0] * 100;
        }
        else if(dice[1] == dice[2])
        {
            result = 1000 + dice[1] * 100;
        }
        else if(dice[0] == dice[2])
        {
            result = 1000 + dice[0] * 100;
        }
        else
        {
            for(int i = 0; i < dice.length; i++)
            {
                if(max < dice[i])
                {
                    max = dice[i];
                }
            }
            result = max * 100;
        }

        System.out.println(result);
    }
}