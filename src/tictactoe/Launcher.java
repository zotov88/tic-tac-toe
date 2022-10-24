package tictactoe;

import tictactoe.component.*;
import tictactoe.component.keypad.TerminalPadNumberConverter;

/**
 * @author zotov_l88
 */
public class Launcher {
    public static void main(String[] args) {
        final CellNumberConverter cellNumberConverter = new TerminalPadNumberConverter();
        final Game game = new Game(new DataPrinter(cellNumberConverter),
                new ComputerMove(),
                new UserMove(cellNumberConverter),
                new WinnerVerifier(),
                new CellVerifier());
        game.play();
    }
}
