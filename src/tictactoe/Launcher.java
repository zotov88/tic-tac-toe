package tictactoe;

import tictactoe.component.*;

/**
 * @author zotov_l88
 */
public class Launcher {
    public static void main(String[] args) {
        final Game game = new Game(new DataPrinter(),
                new ComputerMove(),
                new UserMove(),
                new WinnerVerifier(),
                new CellVerifier());
        game.play();
    }
}
