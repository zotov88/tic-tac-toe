package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameTable;

import java.util.Scanner;

/**
 * @author zotov_l88
 */
public class UserMove {

    private final char[][] mapping = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    public void make(GameTable gameTable) {
        while (true) {
            Cell cell = getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'X');
                break;
            } else {
                System.out.println("Cell is not empty");
            }
        }
    }

    private Cell getUserInput() {
        while (true) {
            System.out.println("Input number from 1 to 9:");
            final String line = new Scanner(System.in).nextLine();
            if (line.length() == 1) {
                final char number = line.charAt(0);
                if (number >= '1' && number <= '9') {
                    return getCell(number);
                }
            }
        }
    }

    private Cell getCell(char number) {
        for (int i = 0; i < mapping.length; i++) {
            for (int j = 0; j < mapping.length; j++) {
                if (mapping[i][j] == number) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }
}
