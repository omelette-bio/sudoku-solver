package grid;

public class Grid {
    private final int[] grid; // contiendra des Cell

    public Grid(int[] grid) { this.grid = grid; }

    // fonction pour convertir des coordonnes 2D en une coordonnee 1D
    // (pratique pour naviguer dans une matrice linearisee)
    private int Change2DIndexTo1D(int i, int j) { return i*9 + j; }

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

                if (grid[Change2DIndexTo1D(i,j)] == -1)
                    System.out.print("  ");
                else
                    System.out.print(" " + grid[Change2DIndexTo1D(i,j)]);
            }
            System.out.print(" !\n");
        }
        System.out.println(" =========================");
    }
}
