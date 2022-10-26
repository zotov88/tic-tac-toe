package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author zotov_l88
 */
public class ComputerMove {

    private final static char SIGN_COMP = '0';
    private final static char SIGN_USER = 'X';
    private final static char SIGN_EMPTY = ' ';
    private final Cell middleCell = new Cell(1, 1);

    public void make(GameTable gameTable) {
        Cell cell = null;
        if (gameTable.isEmpty(middleCell)) {
            cell = middleCell;
        }
        if (cell == null) {
            cell = getCell(gameTable);
        }
        gameTable.setSign(cell, SIGN_COMP);
    }

    private Cell getCell(GameTable gameTable) {
        Cell cell;
        cell = getWinCell(gameTable);
        if (cell == null) {
            cell = getBlockCell(gameTable);
        }
        if (cell == null) {
            Random random = new Random();
            while (true) {
                Cell randomCell = new Cell(random.nextInt(3), random.nextInt(3));
                if (gameTable.isEmpty(randomCell)) {
                    cell = randomCell;
                    break;
                }
            }
        }
        return cell;
    }

    private Cell getWinCell(GameTable gameTable) {
        Cell cell = checkRows(gameTable, SIGN_COMP);
        if (cell == null) {
            cell = checkCols(gameTable, SIGN_COMP);
            if (cell == null) {
                cell = checkMainDiagonalWinOrBlock(gameTable, SIGN_COMP);
                if (cell == null) {
                    cell = checkSecondDiagonalWinOrBlock(gameTable, SIGN_COMP);
                }
            }
        }
        return cell;
    }

    private Cell getBlockCell(GameTable gameTable) {
        Cell cell = checkRows(gameTable, SIGN_USER);
        if (cell == null) {
            cell = checkCols(gameTable, SIGN_USER);
            if (cell == null) {
                cell = checkMainDiagonalWinOrBlock(gameTable, SIGN_USER);
                if (cell == null) {
                    cell = checkSecondDiagonalWinOrBlock(gameTable, SIGN_USER);
                }
            }
        }
        return cell;
    }

    private Cell checkRows(GameTable gameTable, char sign) {
        Cell cell = null;
        for (int i = 0; i < 3; i++) {
            cell = checkRow(gameTable, i, sign);
            if (cell != null) {
                break;
            }
        }
        return cell;
    }

    private Cell checkCols(GameTable gameTable, char sign) {
        Cell cell = null;
        for (int i = 0; i < 3; i++) {
            cell = checkCol(gameTable, i, sign);
            if (cell != null) {
                break;
            }
        }
        return cell;
    }

    private Cell checkMainDiagonalWinOrBlock(GameTable gameTable, char sign) {
        Cell result = null;
        int countOfEmptyCell = 0, countOfTarget = 0;
        int row = 0, col = 0;
        Cell[] cells = {new Cell(0, 0), new Cell(1, 1), new Cell(2, 2)};
        for (Cell cell : cells) {
            if (gameTable.getSign(cell) == sign) {
                countOfTarget++;
            }
            if (gameTable.getSign(cell) == SIGN_EMPTY) {
                countOfEmptyCell++;
                row = cell.getRow();
                col = cell.getCol();
            }
        }
        if (countOfTarget == 2 && countOfEmptyCell == 1) {
            result = new Cell(row, col);
        }
        return result;
    }

    private Cell checkSecondDiagonalWinOrBlock(GameTable gameTable, char sign) {
        Cell result = null;
        int countOfEmptyCell = 0, countOfTarget = 0;
        int row = 0, col = 0;
        Cell[] cells = {new Cell(0, 2), new Cell(1, 1), new Cell(2, 0)};
        for (Cell cell : cells) {
            if (gameTable.getSign(cell) == sign) {
                countOfTarget++;
            }
            if (gameTable.getSign(cell) == SIGN_EMPTY) {
                countOfEmptyCell++;
                row = cell.getRow();
                col = cell.getCol();
            }
        }
        if (countOfTarget == 2 && countOfEmptyCell == 1) {
            result = new Cell(row, col);
        }
        return result;
    }

    private Cell checkRow(GameTable gameTable, int indexOfRow, char sign) {
        Cell cell = null;
        int countOfEmptyCell = 0, countOfTarget = 0;
        int row = 0, col = 0;
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(indexOfRow, i)) == sign) {
                countOfTarget++;
            }
            if (gameTable.getSign(new Cell(indexOfRow, i)) == SIGN_EMPTY) {
                countOfEmptyCell++;
                row = indexOfRow;
                col = i;
            }
            if (countOfTarget == 2 && countOfEmptyCell == 1) {
                cell = new Cell(row, col);
            }
        }
        return cell;
    }

    private Cell checkCol(GameTable gameTable, int indexOfCol, char sign) {
        Cell cell = null;
        int countOfEmptyCell = 0, countOfTarget = 0;
        int row = 0, col = 0;
        for (int i = 0; i < 3; i++) {
            if (gameTable.getSign(new Cell(i, indexOfCol)) == sign) {
                countOfTarget++;
            }
            if (gameTable.getSign(new Cell(i, indexOfCol)) == SIGN_EMPTY) {
                countOfEmptyCell++;
                row = i;
                col = indexOfCol;
            }
            if (countOfTarget == 2 && countOfEmptyCell == 1) {
                cell = new Cell(row, col);
            }
        }
        return cell;
    }
}
