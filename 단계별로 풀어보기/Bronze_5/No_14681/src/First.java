import java.util.Scanner;

public class First {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, y;
        do {
            x = sc.nextInt();
        }while(x > 1000 || x < - 1000 || x == 0);

        do {
            y = sc.nextInt();
        }while(y > 1000 || y < - 1000 || y == 0);

        if(x * y > 0)
        {
            if(x < 0)
            {
                System.out.println("3");
            }
            else
            {
                System.out.println("1");
            }
        }
        else
        {
            if(x < 0)
            {
                System.out.println("2");
            }
            else
            {
                System.out.println("4");
            }
        }
    }
}