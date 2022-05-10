/*
 * Copyright (c) 2022. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package tictactoe;

import java.util.Random;

/**
 * @autor zotov_l88
 */
public class Game {

    private final DataPrinter dataPrinter;
    private final ComputerMove computerMove;
    private final UserMove userMove;
    private final WinnerDetermination winnerDetermination;
    private final DrawDetermination drawDetermination;

    public Game(DataPrinter dataPrinter,
                ComputerMove computerMove,
                UserMove userMove,
                WinnerDetermination winnerDetermination,
                DrawDetermination drawDetermination) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerDetermination = winnerDetermination;
        this.drawDetermination = drawDetermination;
    }

    public void play() {
        System.out.println("You can use numbers from 1 to 9 for the game");
        final GameField gameField = new GameField();
        dataPrinter.printStartField();
        if (new Random().nextBoolean()) {
            computerMove.step(gameField);
            dataPrinter.printGameField(gameField);
        }
        while (true) {
            userMove.step(gameField);
            dataPrinter.printGameField(gameField);
            if (winnerDetermination.isUserWin(gameField)) {
                System.out.println("You win!\nGame Over");
                return;
            }
            if (drawDetermination.isDraw(gameField)) {
                System.out.println("It's draw!");
                break;
            }
            computerMove.step(gameField);
            dataPrinter.printGameField(gameField);
            if (winnerDetermination.isComputerWin(gameField)) {
                System.out.println("You loose!");
                break;
            }
            if (drawDetermination.isDraw(gameField)) {
                System.out.println("It's draw!");
                break;
            }
        }
        System.out.println("Game Over");
    }
}
