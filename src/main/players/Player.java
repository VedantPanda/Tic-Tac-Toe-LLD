package main.players;

import main.consts.Symbol;

public class Player {

    private final Symbol symbol;

    private final String name;

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Player(Symbol symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

}
