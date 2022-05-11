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

package tictactoe.component;

import tictactoe.model.Cell;
import tictactoe.model.GameField;

/**
 * @author zotov_l88
 */
public class WinnerDetermination {

    public boolean isUserWin(GameField gameField) {
        return isWinner(gameField, 'X');
    }

    public boolean isComputerWin(GameField gameField) {
        return isWinner(gameField, 'O');
    }

    private boolean isWinner(GameField gameField, char sign) {
        return isRowWin(gameField, sign) ||
                isColWin(gameField, sign) ||
                isFirstDiagonal(gameField, sign) ||
                isSecondDiagonal(gameField, sign);
    }

    private boolean isRowWin(GameField gameField, char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameField.getSign(new Cell(i, 0)) == gameField.getSign(new Cell(i, 1)) &&
                    gameField.getSign(new Cell(i, 1)) == gameField.getSign(new Cell(i, 2)) &&
                    gameField.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isColWin(GameField gameField, char sign) {
        for (int i = 0; i < 3; i++) {
            if (gameField.getSign(new Cell(0, i)) == gameField.getSign(new Cell(1, i)) &&
                    gameField.getSign(new Cell(1, i)) == gameField.getSign(new Cell(2, i)) &&
                    gameField.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isFirstDiagonal(GameField gameField, char sign) {
        return gameField.getSign(new Cell(0, 0)) == gameField.getSign(new Cell(1, 1)) &&
                gameField.getSign(new Cell(1, 1)) == gameField.getSign(new Cell(2, 2)) &&
                gameField.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isSecondDiagonal(GameField gameField, char sign) {
        return gameField.getSign(new Cell(0, 2)) == gameField.getSign(new Cell(1, 1)) &&
                gameField.getSign(new Cell(1, 1)) == gameField.getSign(new Cell(2, 0)) &&
                gameField.getSign(new Cell(2, 0)) == sign;
    }
}
