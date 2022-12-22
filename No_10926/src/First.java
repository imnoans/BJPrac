import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        String new_ID;

        do
        {
            new_ID = (sc.next()).toLowerCase();
        }while ((new_ID.length() > 50));
        System.out.println(new_ID + "??!");


    }
}