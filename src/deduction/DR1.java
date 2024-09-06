package deduction;

import grid.Grid;

import java.util.ArrayList;

public class DR1 extends DeductionRule{
    @Override
    public void run(Grid grid)
    {
        for (int i = 0; i < 81; i++)
        {
            ArrayList<Integer> list = new ArrayList<>(grid.getCell(i).getPossibleValues());
            //System.out.println(list.size() + ":" + list);
            if (list.size() == 1) grid.getCell(i).setValue(list.getFirst());
        }
    }

}
