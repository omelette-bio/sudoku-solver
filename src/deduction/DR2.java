package deduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import grid.Grid;

public class DR2 extends DeductionRule {
    @Override
    public void run(Grid grid)
    {
        for (int i = 0; i < 9; i++)
        {
            int empty_index = -1;
            boolean modify = false;
            HashSet<Integer> possible_values = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            
            for (int j = 0; j < 9; j++)
            {
                if (grid.getLines()[i][j].getValue() == 0)
                {
                    if (empty_index != -1) modify = false;
                    else 
                    {
                        empty_index = j;
                        modify = true;
                    }
                }
                else possible_values.remove(grid.getLines()[i][j].getValue());
            }

            if (modify) 
            {
                ArrayList<Integer> list = new ArrayList<>(possible_values);
                grid.getLines()[i][empty_index].setValue(list.getFirst());
            }
    
        }    
    }
}
