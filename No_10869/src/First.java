import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        int a, b, result = 0;

        Scanner sc = new Scanner(System.in);
        do
        {
            a = sc.nextInt();
            b = sc.nextInt();
        } while(a<1 || b>10000);

        System.out.println(a + b);

        System.out.println(a - b);

        System.out.println(a * b);

        System.out.println(a / b);

        System.out.println(a % b);
        }
}