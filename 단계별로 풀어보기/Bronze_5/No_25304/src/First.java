import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, n, a, b, total = 0;

        do{
            x = sc.nextInt();
        }while(x < 1 || x > 1000000000);

        do{
            n = sc.nextInt();
        }while(n < 1 || n > 100);

        for(int i = 0; i < n; i++)
        {
            do{
                a = sc.nextInt();
            }while(a < 1 || a > 1000000);

            do{
                b = sc.nextInt();
            }while(b < 1 || b > 10);

            total = total + (a * b);
        }

        if(total == x)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }
}