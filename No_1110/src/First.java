import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int first, num, a, b, sum, mod, count = 0;
        do{
            first = sc.nextInt();
        }while(first < 0 || first > 99);

        num = first;
        do
        {
            if(num < 10)
            {
                a = 0;
                b = num;
            }
            else
            {
                a = num /10;
                b = num % 10;
            }
            sum = a + b;

            mod = (b * 10) + (sum % 10);
            num = mod;
            count++;
        }while(first != mod);

        System.out.println(count);
    }
}