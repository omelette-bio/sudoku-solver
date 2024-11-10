package grid;
import java.util.Arrays;
import java.util.HashSet;

public class Grid {
    private final Cell[] grid = new Cell[81];

    // on cree trois tableaux, representant les lignes, les colonnes et les carres
    // cela nous permet de mieux circuler dans la grille
    private final Cell[][] lines = new Cell[9][9];
    private final Cell[][] columns = new Cell[9][9];
    private final Cell[][] squares = new Cell[9][9];

    public Grid(int[] input_grid)
    {
        // le tableau principal
        for (int i = 0; i < 81; i++)
        {
            if (input_grid[i] == 0) { this.grid[i] = CellFactory.emptyCell(i); }
            else { this.grid[i] = CellFactory.valueCell(input_grid[i], i); }
        }
        // obtenir les lignes
        for (int j = 0; j < 81; j++) this.lines[j/9][j%9] = this.grid[j];
        for (int j = 0; j < 81; j++) this.columns[j%9][j/9] = this.grid[j];
        for (int j = 0; j < 81; j++) this.squares[this.grid[j].getS_pos()][this.grid[j].getS_x_pos()] = this.grid[j];
        this.updatePossibleValues();
    }

    public Cell[][] getLines()
    {
        return lines;
    }

    public Cell[][] getCols()
    {
        return columns;
    }

    public Cell[][] getSquares()
    {
        return squares;
    }

    public Cell getCell(int i)
    {
        return grid[i];
    }

    // fonction pour convertir des coordonnes 2D en une coordonnee 1D
    // (pratique pour naviguer dans une matrice linearisee)
    private int Change2DIndexTo1D(int i, int j) { return i*9 + j; }

    public void updatePossibleValues()
    {
        for (int i = 0; i < 81; i++)
        {
            if (grid[i].getValue() == 0) {
                grid[i].resetPossibleValues();
                for (int j = 0; j < 9; j++) grid[i].removePossibleValue(lines[grid[i].getX_pos()][j].getValue());
                for (int j = 0; j < 9; j++) grid[i].removePossibleValue(columns[grid[i].getY_pos()][j].getValue());
                for (int j = 0; j < 9; j++) grid[i].removePossibleValue(squares[grid[i].getS_pos()][j].getValue());
            }
            else
            {
                grid[i].clearPossibleValues();
            }
        }
    }

    // fonction de print pour afficher toute la grille
    public void print()
    {
        System.out.println("GRILLE ACTUELLE");

        for (int i = 0; i < 9; i++)
        {
            if (i == 0) System.out.println("    1 2 3   4 5 6   7 8 9  ");
            if (i%3 == 0) System.out.println("  =========================");

            for (int j = 0; j < 9; j++)
            {
                if (j == 0) System.out.printf("%d !", i+1);
                else if (j%3 == 0) System.out.print(" !");

                if (grid[Change2DIndexTo1D(i,j)].getValue() == 0)
                    System.out.print("  ");
                else
                    System.out.print(" " + grid[Change2DIndexTo1D(i,j)].getValue());
            }
            System.out.print(" !\n");
        }
        System.out.println("  =========================");
    }

    private boolean checkSection(Cell[] section)
    {
        HashSet<Integer> possible_values = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int j=0; j<9; j++)
        {
            possible_values.remove(section[j].getValue());
        }
        return possible_values.isEmpty();
    }

    public boolean checkComplete()
    {
        boolean goodme = true;
        for (int i=0; i<9; i++)
        {
            goodme = goodme & checkSection(lines[i]);
            goodme = goodme & checkSection(columns[i]);
            goodme = goodme & checkSection(squares[i]);
            if (goodme == false) return false;
        }
        return true;
    }

    public void print_possible_values()
    {
        for (int i=0; i<81; i++)
        {
            System.out.print(grid[i].getPossibleValues());
            if (i%9 == 0) System.out.println();
        }
    }

    public void refreshStructure() {
        for (int j = 0; j < 81; j++) {
            this.lines[j / 9][j % 9] = this.grid[j];
            this.columns[j % 9][j / 9] = this.grid[j];
            this.squares[this.grid[j].getS_pos()][this.grid[j].getS_x_pos()] = this.grid[j];
        }
    }

    public void getInput()
    {
        int i,j,value;
        boolean modifiable = false;

        System.out.println("Le solver ne trouve plus de solution, veuillez entrer une case pour debloquer la situation.");

        while (!modifiable){

            int[] input = ReadInput.PlayerInput();

            i = input[0]-1;
            j = input[1]-1;
            value = input[2];

            Cell cell = grid[Change2DIndexTo1D(i, j)];
            if ( cell.getValue() == 0 && cell.getPossibleValues().contains(value) ) 
            {
                modifiable = true;
                grid[Change2DIndexTo1D(i, j)].setValue(value);
            }
            else
            {
                System.out.printf("erreur, l'entree [%d,%d] = %d est incompatible avec la grille\n", input[0], input[1], input[2]);
            }
        }
        updatePossibleValues();
    }
}