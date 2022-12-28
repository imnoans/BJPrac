import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count, a, b;

        count = sc.nextInt();

        for(int i = 0; i < count; i++)
        {
            do {
                a = sc.nextInt();
            }while(a <= 0);

            do {
                b = sc.nextInt();
            }while(b >= 10);
            System.out.println(a + b);
        }
    }
}