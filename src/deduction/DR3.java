package deduction;

import java.util.*;

import grid.Cell;
import grid.Grid;

public class DR3 extends DeductionRule {
    private static DR3 instance = null;

    private DR3() {
    }

    public static DR3 getInstance() {
        if (instance == null) instance = new DR3();
        return instance;
    }

    public boolean run(Grid grid)
    {
        System.out.println("Execution de la DR3...");
        boolean modified = false;
        for (int i=0; i<9; i++)
        {
            modified = modified | processSection(grid.getLines()[i], grid);
            modified = modified | processSection(grid.getCols()[i], grid);
            modified = modified | processSection(grid.getSquares()[i], grid);
        }
        grid.updatePossibleValues();
        grid.refreshStructure();
        return modified;
    }

    private boolean processSection(Cell[] section, Grid grid)
    {
        HashMap<Integer, Integer> map_qte = new HashMap<>(
            Map.of(1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0)
        );
        HashMap<Integer, Integer> map_index = new HashMap<>(
            Map.of(1, -1, 2, -1, 3, -1, 4, -1, 5, -1, 6, -1, 7, -1, 8, -1, 9, -1)
        );
        for (int j=0; j<9; j++)
        {
            if (section[j].getValue() == 0)
            {
                for (Integer value: section[j].getPossibleValues())
                {
                    map_qte.put(value, map_qte.get(value) + 1);
                    map_index.put(value, j);
                }
            }
        }
        for (int k=1; k<=9; k++)
        {
            if (map_qte.get(k) == 1)
            {
                section[map_index.get(k)].setValue(k);
                grid.updatePossibleValues();
            }
        }
        return false;

    }
}