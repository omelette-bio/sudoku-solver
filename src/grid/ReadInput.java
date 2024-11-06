package grid;
import java.util.Scanner;

public class ReadInput {

    public static int[] PlayerInput()
    {
        Scanner sc = new Scanner(System.in);
        int[] res = new int[3];
        boolean validInput = false;
        
        while (!validInput)
        {
            System.out.println("Entrez les donnees selon ce format : x,y,value (min 1, max 9):");
            String input = sc.nextLine();
            String[] values = input.split(",");

            if (values.length == 3)
            {
                for (int i=0; i<3; i++)
                {
                    res[i] = Integer.parseInt(values[i].trim());
                    if (res[i] >= 1 && res[i] <= 9) validInput = true;
                    else
                    {
                        System.out.printf("erreur, l'entree %s,%s,%s n'est pas valide\n", values[0], values[1], values[2]);
                        validInput = false; 
                        break;
                    }
                }
            }
        }
        return res;
    }
}
    //     int nb;
    //     int [] res;
    //     res = new int[3];

    //     while(true)
    //     {
    //         System.out.println("Entrer une valeur entre 1 et 9 : ");
    //         input_number = new Scanner(System.in);
    //         nb = input_number.nextInt();
    //         if (nb > 9 || nb < 1)
    //             System.out.println("la valeur est hors des bornes demandées...");
    //         else
    //         {
    //             res[0] = nb;
    //             break;
    //         }
    //     }
    //     while(true)
    //     {
    //         System.out.println("Entrer une valeur entre 0 et 8 pour la position x : ");
    //         input_x = new Scanner(System.in);
    //         nb = input_x.nextInt();
    //         if (nb > 8 || nb < 0)
    //             System.out.println("la valeur est hors des bornes demandées...");
    //         else
    //         {
    //             res[1] = nb;
    //             break;
    //         }
    //     }
    //     while(true)
    //     {
    //         System.out.println("Entrer une valeur entre 0 et 8 pour la position y : ");
    //         input_y = new Scanner(System.in);
    //         nb = input_y.nextInt();
    //         if (nb > 8 || nb < 0)
    //             System.out.println("la valeur est hors des bornes demandées...");
    //         else
    //         {
    //             res[2] = nb;
    //             break;
    //         }
    //     }

    //     return res;
    // }
