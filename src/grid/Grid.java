package grid;
import java.util.HashSet;

public class Grid {
    private final Cell[] grid = new Cell[81];

    /*
    peut-etre des tableaux de cell pour ligne, colonne et carres
     */

    // test
    private final Cell[][] lines = new Cell[9][9];
    private final Cell[][] columns = new Cell[9][9];
    private final Cell[][] squares = new Cell[9][9];

    public Grid(int[] grid)
    {
        // le tableau principal
        for (int i = 0; i < 81; i++) this.grid[i] = new Cell(grid[i], i);
        // obtenir les lignes
        for (int j = 0; j < 81; j++) this.lines[j/9][j%9] = this.grid[j];
        for (int j = 0; j < 81; j++) this.columns[j%9][j/9] = this.grid[j];
        for (int j = 0; j < 81; j++)
        {
            squares[this.grid[j].getS_pos()][ (this.grid[j].getX_pos()%3)*3 + this.grid[j].getY_pos()%3] = this.grid[j];
        }
    }

    public void print_square()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(squares[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
//
//    public void print_columns()
//    {
//        for (int i = 0; i < 9; i++)
//        {
//            for (int j = 0; j < 9; j++)
//            {
//                System.out.print(columns[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    // juste une fonction de test
    public void print_square_pos(int i) { System.out.println(grid[i].getS_pos());}

    // fonction pour convertir des coordonnes 2D en une coordonnee 1D
    // (pratique pour naviguer dans une matrice linearisee)
    private int Change2DIndexTo1D(int i, int j) { return i*9 + j; }

    public void updatePossibleValues()
    {
        for (int i = 0; i < 81; i++)
        {
            if (grid[i].getValue() == -1) {
                grid[i].resetPossibleValues();
                for (int j = 0; j < 9; j++) grid[i].removePossibleValue(lines[grid[i].getY_pos()][j].getValue());
                for (int j = 0; j < 9; j++) grid[i].removePossibleValue(columns[grid[i].getX_pos()][j].getValue());
            }
        }
    }

    public HashSet<Integer> get_possible_values(int i) { return grid[i].getPossibleValues(); }

    // fonction de print pour afficher toute la grille
    public void print()
    {
        System.out.println("GRILLE ACTUELLE");

        for (int i = 0; i < 9; i++)
        {
            if (i%3 == 0) System.out.println(" =========================");

            for (int j = 0; j < 9; j++)
            {
                if (j%3 == 0) System.out.print(" !");

                if (grid[Change2DIndexTo1D(i,j)].getValue() == -1)
                    System.out.print("  ");
                else
                    System.out.print(" " + grid[Change2DIndexTo1D(i,j)].getValue());
            }
            System.out.print(" !\n");
        }
        System.out.println(" =========================");
    }
}
