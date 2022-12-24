import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num;
        do
        {
            num = sc.nextInt();
        }while(num > 9 || num < 1);

        for(int i = 1; i <= 9; i++)
        {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }
}