package deduction;

import grid.Grid;

import java.util.ArrayList;

public class DR2 extends DeductionRule{
    private static DR2 instance = null;

    private DR2() {}

    public static DR2 getInstance()
    {
        if (instance == null) instance = new DR2();
        return instance;
    }

    @Override
    public void run(Grid grid)
    {
        System.out.println("Execution de la DR2...");
        for (int i = 0; i < 81; i++)
        {
            ArrayList<Integer> list = new ArrayList<>(grid.getCell(i).getPossibleValues());
            if (list.size() == 1) grid.getCell(i).setValue(list.getFirst());

            grid.updatePossibleValues();
        }
    }
}
