import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int fir, sec, one, ten, hun, res;
        do {
            fir = sc.nextInt();
        }while((fir / 100) >= 10);

        do {
            sec = sc.nextInt();
        }while((sec / 100) >= 10);

        one = fir * (sec % 10);
        ten = fir * ((sec % 100) / 10);
        hun = fir * ((sec % 1000) / 100 );
        res = fir * sec;

        System.out.println(one);
        System.out.println(ten);
        System.out.println(hun);
        System.out.println(res);
    }
}