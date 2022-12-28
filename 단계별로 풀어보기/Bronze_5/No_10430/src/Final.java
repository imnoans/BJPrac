import java.util.Scanner;

public class Final {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        do{
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        }while((2 > a || 10000 < a) || (2 > b || 10000 < b) || (2 > c || 10000 < c));

        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b % c)) % c);
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b % c)) % c);

    }
}