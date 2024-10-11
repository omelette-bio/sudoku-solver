import deduction.DR1;
import deduction.DeductionRule;
import grid.*;

class Main {
    public static void main(String[] args) {
        int[] grid = Parseur.Parse(args[0]);

        Grid grid0 = new Grid(grid);
        grid0.print();

        DeductionRule d = new DR1();
        for (int i = 0; i < 3; i++)
        {
            d.run(grid0);
            grid0.print();
        }



//        Grid grid1 = new Grid(
//                new int[] {3,4,2,-1,8,-1,-1,-1,-1,5,-1,-1,9,-1,-1,-1,2,-1,-1,9,-1,-1,-1,4,3,8,-1,-1,2,-1,3,-1,5,1,-1,-1,-1,5,-1,7,-1,6,-1,4,-1,-1,7,-1,-1,9,1,6,5,2,6,-1,-1,-1,7,9,2,3,1,7,-1,-1,-1,6,-1,8,-1,-1,2,-1,-1,5,3,-1,4,-1,-1}
//        );
//        for (int i = 0; i < 5; i++)
//        {
//            grid1.updatePossibleValues();
//            d.run(grid1);
//            grid1.print();
//        }
    }
}