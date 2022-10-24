package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author zotov_l88
 */
public class ComputerMove {

    public void make(final GameTable gameTable) {
        final Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            final Cell cell = new Cell(row, col);
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, '0');
                return;
            }
        }
    }
}
