package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author zotov_l88
 */
public class DataPrinter {

    public void printMappingTable() {
        System.out.println("_____________");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("_____________");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("_____________");
        System.out.println("| 1 | 2 | 3 |");
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
