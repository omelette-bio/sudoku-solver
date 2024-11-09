import deduction.DRState;
import deduction.DeductionRule;
import grid.Grid;

class Main {
    public static void main(String[] args) {
        int[] grid = Parseur.Parse(args[0]);
        int echecs = 0;

        Grid grid0 = new Grid(grid);

        DeductionRule dr = DRState.next();

        grid0.print();


        while (!grid0.checkComplete())
        {
            boolean res = dr.run(grid0);

            if (!res)
            {
                echecs++;
                if (echecs > 1 && DRState.getCurIndex() == 2)
                {
                    grid0.getInput();
                    echecs = 0;
                }
                dr = DRState.next();
            }
            else echecs = 0;
        }

        grid0.print();
    }
}
