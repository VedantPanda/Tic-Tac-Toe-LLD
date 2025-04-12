package main.players;

import main.consts.Symbol;
import main.strategy.player.PlayerStrategy;

public class Player {

    private final Symbol symbol;

    private final PlayerStrategy playerStrategy;

    private final String name;

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public String getName() {
        return name;
    }

    public Player(Symbol symbol, PlayerStrategy playerStrategy, String name) {
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
        this.name = name;
    }

}
