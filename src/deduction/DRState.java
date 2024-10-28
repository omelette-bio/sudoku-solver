package deduction;

// classe utilitaire qui nous permet de tourner entre toutes les DR
public class DRState
{
    // si on ajoute une DR, on a juste a l'ajouter a la liste
    private static final DeductionRule[] sequence = { DR1.getInstance(), DR2.getInstance(), DR3.getInstance() };
    private static int cur_i = 0;

    private DRState() {}

    public static DeductionRule next()
    {
        DeductionRule cur = sequence[cur_i];
        cur_i = (cur_i+1)%sequence.length;
        return cur;
    }

    public static int getCurIndex()
    {
        return cur_i;
    }
}
