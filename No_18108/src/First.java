import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int year;
        do {
            year = sc.nextInt();
        }while(year < 1000 || 3000 < year);

        System.out.println(year - 543);
    }
}