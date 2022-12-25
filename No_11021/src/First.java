import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t, a, b;
        do {
            t = sc.nextInt();
        }while(t < 0);

        for(int i = 1; i <= t; i++)
        {
            do {
                a = sc.nextInt();
            }while(a <= 0);

            do{
                b = sc.nextInt();
            }while(b >= 10);

            System.out.println("Case #" + i + ": " + (a + b));
        }
    }
}