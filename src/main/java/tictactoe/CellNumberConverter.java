package tictactoe;

import tictactoe.model.Cell;

/**
 * @author zotov_l88
 */
public interface CellNumberConverter {

    Cell toCell(char number);

    char toNumber(Cell cell);
}
