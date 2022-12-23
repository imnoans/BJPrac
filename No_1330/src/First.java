import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a, b;

        do {
            a = sc.nextInt();
            b = sc.nextInt();
        }while((a < -10000 || a > 10000) || (b < -10000 || b > 10000));

        if(a < b)
        {
            System.out.println("<");
        }
        else if(a > b)
        {
            System.out.println(">");
        }
        else
        {
            System.out.println("==");
        }

    }
}