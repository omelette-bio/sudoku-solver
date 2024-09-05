package grid;

public class Cell
{
    int value; // -1 si pas de valeur et 1 a 9 sinon

    // tableau permettant de determiner ce qui est possible sur cette cellule (vide si aucune valeur)
    int[] possible_values;

    public Cell(int value) { this.value = value; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}
