package main.strategy.player;

import main.Position;
import main.board.Board;

public interface PlayerStrategy {
    Position makeMove(Board board);
}
