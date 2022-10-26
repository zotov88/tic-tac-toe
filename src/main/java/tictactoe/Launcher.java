package tictactoe;

import tictactoe.component.*;
import tictactoe.component.keypad.PcPadNumberConverter;

/**
 * @author zotov_l88
 */
public final class Launcher {
    public static void main(String[] args) {
        final CellNumberConverter cellNumberConverter = new PcPadNumberConverter();
        final Game game = new Game(new DataPrinter(cellNumberConverter),
                new ComputerMove(),
                new UserMove(cellNumberConverter),
                new WinnerVerifier(),
                new CellVerifier());
        game.play();
    }
}
