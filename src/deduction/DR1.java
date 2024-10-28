package deduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import grid.Cell;
import grid.Grid;

public class DR1 extends DeductionRule {
    private static DR1 instance = null;

    private DR1() {}

    public static DR1 getInstance()
    {
        if (instance == null) instance = new DR1();
        return instance;
    }

    @Override
    public boolean run(Grid grid)
    {
        boolean modified = false;
        System.out.println("Execution de la DR1...");

        for (int i = 0; i < 9; i++)
        {
            modified = modified | processGridSection(grid.getLines()[i]);
            modified = modified | processGridSection(grid.getCols()[i]);
            modified = modified | processGridSection(grid.getSquares()[i]);
        }

        grid.updatePossibleValues();
        grid.refreshStructure();

        return modified;
    }

    private boolean processGridSection(Cell[] section)
    {
        boolean modified = false;
        int empty_index = -1;
        boolean modify = false;
        HashSet<Integer> possible_values = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        for (int j = 0; j < 9; j++)
        {
            if (section[j].getValue() == 0)
            {
                if (empty_index != -1) modify = false;
                else
                {
                    empty_index = j;
                    modify = true;
                }
            }
            else possible_values.remove(section[j].getValue());
        }

        if (modify)
        {
            ArrayList<Integer> list = new ArrayList<>(possible_values);
            section[empty_index].setValue(list.getFirst());
            modified = true;
        }

        return modified;
    }
}
