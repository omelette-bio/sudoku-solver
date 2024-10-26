package deduction;

public class DRState
{
    private static DRState instance = null;
    // si on ajoute une DR, on a juste a l'ajouter a la liste
    private static final DeductionRule[] sequence = { new DR1(), new DR2() };
    private static int cur_i = 0;

    private DRState()
    {

    }

    public static void getInstance()
    {
        if (instance == null) instance = new DRState();
    }

    public static DeductionRule next()
    {
        DeductionRule cur = sequence[cur_i];
        cur_i = (cur_i+1)%sequence.length;
        return cur;
    }
}
