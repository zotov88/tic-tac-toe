package tictactoe.component;

import tictactoe.CellNumberConverter;
import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author zotov_l88
 */
public class DataPrinter {

    private final CellNumberConverter cellNumberConverter;

    public DataPrinter(CellNumberConverter cellNumberConverter) {
        this.cellNumberConverter = cellNumberConverter;
    }

    public void printMappingTable() {
        for (int i = 0; i < 3; i++) {
            System.out.println("_____________");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + cellNumberConverter.toNumber(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("_____________");
    }

    public void printGameTable(GameTable gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("_____________");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("_____________");
    }
}
