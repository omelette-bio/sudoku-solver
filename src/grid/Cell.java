package grid;
import java.util.HashSet;

public class Cell
{
    private int value; // -1 si pas de valeur et 1 a 9 sinon

    // tableau permettant de determiner ce qui est possible sur cette cellule (vide si aucune valeur)
    HashSet<Integer> possible_values = new HashSet<>();

    private final int x_pos;
    private final int y_pos;
    private final int s_pos;
    private final int s_x_pos;

    public Cell(int value, int pos) {
        this.value = value;
        for(int i = 1; i <= 9; i++) possible_values.add(i);
        x_pos = pos/9;
        y_pos = pos%9;
        if ((x_pos >= 0) && (x_pos < 3)) {
            if ((y_pos >= 0) && (y_pos < 3)) s_pos = 0;
            else if ((y_pos >= 3) && (y_pos < 6)) s_pos = 1;
            else s_pos = 2;
        }
        else if ((x_pos >= 3) && (x_pos < 6)) {
            if ((y_pos >= 0) && (y_pos < 3)) s_pos = 3;
            else if ((y_pos >= 3) && (y_pos < 6)) s_pos = 4;
            else s_pos = 5;
        }
        else {
            if ((y_pos >= 0) && (y_pos < 3)) s_pos = 6;
            else if ((y_pos >= 3) && (y_pos < 6)) s_pos = 7;
            else s_pos = 8;
        }
        s_x_pos = (x_pos%3)*3 + y_pos%3;
    }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public int getX_pos() { return x_pos; }
    public int getY_pos() { return y_pos; }
    public int getS_pos() { return s_pos; }
    public int getS_x_pos() { return s_x_pos; }

    public HashSet<Integer> getPossibleValues() { return possible_values; }
    public void removePossibleValue(int value) { possible_values.remove(value); }
    public void resetPossibleValues() { for(int i = 1; i <= 9; i++) possible_values.add(i); }
}
