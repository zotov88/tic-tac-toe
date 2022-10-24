package tictactoe.component;

import tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author zotov_l88
 */
public class Game {

    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;

    public Game(DataPrinter dataPrinter,
                ComputerMove computerMove,
                UserMove userMove,
                WinnerVerifier winnerVerifier,
                CellVerifier cellVerifier) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }

    public void play() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        dataPrinter.printMappingTable();
        final GameTable gameTable = new GameTable();
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }
        while (true) {
            userMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isUserWin(gameTable)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (cellVerifier.isAllCellsField(gameTable)) {
                System.out.println("SORRY DRAW!");
                break;
            }
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
            if (winnerVerifier.isComputerWin(gameTable)) {
                System.out.println("YOU LOOSE!");
                break;
            }
            if (cellVerifier.isAllCellsField(gameTable)) {
                System.out.println("SORRY DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER");
    }
}
