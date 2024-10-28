import java.util.Scanner;

public class ReadInput {
    Scanner input_number;
    Scanner input_x;
    Scanner input_y;

    public int[] PlayerInput()
    {
        int nb;
        int [] res;
        res = new int[3];

        while(true)
        {
            System.out.println("Entrer une valeur entre 1 et 9 : ");
            input_number = new Scanner(System.in);
            nb = input_number.nextInt();
            if (nb > 9 || nb < 1)
                System.out.println("la valeur est hors des bornes demandées...");
            else
            {
                res[0] = nb;
                break;
            }
        }
        while(true)
        {
            System.out.println("Entrer une valeur entre 0 et 8 pour la position x : ");
            input_x = new Scanner(System.in);
            nb = input_x.nextInt();
            if (nb > 8 || nb < 0)
                System.out.println("la valeur est hors des bornes demandées...");
            else
            {
                res[1] = nb;
                break;
            }
        }
        while(true)
        {
            System.out.println("Entrer une valeur entre 0 et 8 pour la position y : ");
            input_y = new Scanner(System.in);
            nb = input_y.nextInt();
            if (nb > 8 || nb < 0)
                System.out.println("la valeur est hors des bornes demandées...");
            else
            {
                res[2] = nb;
                break;
            }
        }

        return res;
    }
}
