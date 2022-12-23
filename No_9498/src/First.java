import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int score;
        do {
            score = sc.nextInt();
        }while(score > 100 || score <0);

        if(score >= 90)
        {
            System.out.println("A");
        }
        else if(score >= 80)
        {
            System.out.println("B");
        }
        else if(score >= 70)
        {
            System.out.println("C");
        }
        else if(score >= 60)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
    }
}