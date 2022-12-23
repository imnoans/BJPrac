import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int hour, min, need, total;

        do {
            hour = sc.nextInt();
        }while(hour > 23 || hour < 0);

        do {
            min = sc.nextInt();
        }while(min > 59 || min < 0);

        do {
            need = sc.nextInt();
        }while(need > 1000 || need < 0);

        total = hour * 60 + min + need;
        total = total % (24 * 60);
        hour = total / 60;
        min = total % 60;

        System.out.println(hour + " " + min);
    }
}