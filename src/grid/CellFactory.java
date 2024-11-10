package grid;

public class CellFactory
{

    public static Cell emptyCell(int pos) { return new Cell(pos); }
    public static Cell valueCell(int value, int pos) { return new Cell(value, pos); }
}
