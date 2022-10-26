package tictactoe.component.keypad;

import tictactoe.CellNumberConverter;
import tictactoe.model.Cell;

/**
 * @author zotov_l88
 */
public class TerminalPadNumberConverter implements CellNumberConverter {

    private final char[][] mapping = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    @Override
    public Cell toCell(final char number) {
        for (int i = 0; i < mapping.length; i++) {
            for (int j = 0; j < mapping.length; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public char toNumber(final Cell cell) {
        return mapping[cell.getRow()][cell.getCol()];
    }
}
