import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num, result = 0;

        do {
            num = sc.nextInt();
        }while(num < 1 || num > 10000);

        for(int i = num; i >= 1; i--)
        {
            result += i;
        }

        System.out.println(result);
    }
}