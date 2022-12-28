import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
       do
       {
           a = sc.nextInt();
           b = sc.nextInt();
       } while(a<0 || b>10);

        a += b;
        System.out.println(a);
    }
}