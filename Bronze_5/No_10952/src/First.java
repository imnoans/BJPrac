import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a, b;

        while(true) {
            do{
                a = sc.nextInt();
            }while (a < 0);

            do{
                b = sc.nextInt();
            }while (b >= 10);

            if(a == 0 && b == 0)
            {
                break;
            }
            System.out.println(a + b);
        }
    }
}