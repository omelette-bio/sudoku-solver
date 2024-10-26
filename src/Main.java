import deduction.DRState;
import deduction.DeductionRule;
import grid.Grid;

class Main {
    public static void main(String[] args) {
        int[] grid = Parseur.Parse(args[0]);

        Grid grid0 = new Grid(grid);
        grid0.print();
        DRState.getInstance();

        for (int i = 0; i < 10; i++)
        {
            DRState.next().run(grid0);
            if (grid0.checkComplete()) break;
        }

        grid0.print();
    }
}