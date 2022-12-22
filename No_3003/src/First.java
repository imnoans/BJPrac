import java.util.Scanner;

public class First
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ori_Chess[] = {1, 1, 2, 2, 2, 8};
        int old_Chess[] = new int[6];

        for(int i = 0; i < 6; i++)
        {

            do{
                old_Chess[i] = sc.nextInt();
            }while(old_Chess[i] < 0 || old_Chess[i] > 10);

            ori_Chess[i] -= old_Chess[i];
            System.out.print(ori_Chess[i] + " ");
        }
    }
}