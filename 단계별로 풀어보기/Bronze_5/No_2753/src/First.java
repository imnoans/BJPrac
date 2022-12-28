import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int year;

        do {
            year = sc.nextInt();
        }while(year < 1 || year > 4000);

        if(((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0 )
        {
            System.out.println("1");
        }
        else
        {
            System.out.println("0");
        }
    }

}