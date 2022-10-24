package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author zotov_l88
 */
public class DrawVerifier {

    public boolean isDraw(GameTable gameTable) {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameTable.isEmpty(new Cell(i, j))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
