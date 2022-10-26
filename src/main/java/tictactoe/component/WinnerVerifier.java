package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

/**
 * @author zotov_l88
 */
public class WinnerVerifier {

    public boolean isUserWin(GameTable gameTable) {
        return isWinner(gameTable, 'X');
    }

    public boolean isComputerWin(GameTable gameTable) {
        return isWinner(gameTable, '0');
    }

    private boolean isWinner(GameTable gameTable, char sign) {
        return isWinnerByRows(gameTable, sign) ||
                isWinnerByCols(gameTable, sign) ||
                isWinnerByMainDiagonal(gameTable, sign) ||
                isWinnerBySecondDiagonal(gameTable, sign);
    }

    private boolean isWinnerBySecondDiagonal(GameTable gameTable, char sign) {
        return gameTable.getSign(new Cell(0, 2)) == sign &&
                gameTable.getSign(new Cell(1, 1)) == sign &&
                gameTable.getSign(new Cell(2, 0)) == sign;
    }

    private boolean isWinnerByMainDiagonal(GameTable gameTable, char sign) {
        return gameTable.getSign(new Cell(0, 0)) == sign &&
                gameTable.getSign(new Cell(1, 1)) == sign &&
                gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerByCols(GameTable gameTable, char sign) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(0, i)) == sign &&
                    gameTable.getSign(new Cell(1, i)) == sign &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean isWinnerByRows(GameTable gameTable, char sign) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == sign &&
                    gameTable.getSign(new Cell(i, 1)) == sign &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                result = true;
                break;
            }
        }
        return result;
    }
}
