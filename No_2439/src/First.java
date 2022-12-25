import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            n = sc.nextInt();
        }while(n < 1 || n > 100);

        for(int i = 1; i <= n; i++)
        {
            for(int j = i; j < n; j ++)
            {
                System.out.print(" ");
            }
            for(int k = n - i; k < n; k ++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}