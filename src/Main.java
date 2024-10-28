import deduction.DRState;
import deduction.DeductionRule;
import grid.Grid;

class Main {
    public static void main(String[] args) {
        int[] grid = Parseur.Parse(args[0]);

        Grid grid0 = new Grid(grid);

        DeductionRule dr = DRState.next();

        grid0.print();


        while (!grid0.checkComplete())
        {
            boolean res = dr.run(grid0);
            if (!res)
            {
                if (DRState.getCurIndex() == 2) System.out.println("inputme");
                dr = DRState.next();
            }
        }

        grid0.print();
    }
}