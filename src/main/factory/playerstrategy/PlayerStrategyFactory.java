package main.factory.playerstrategy;

import main.strategy.player.PlayerStrategy;
import main.strategy.player.impl.HumanPlayerStrategy;

public class PlayerStrategyFactory {

    public static PlayerStrategy getPlayerStrategy(String strategy){
        if("Human".equalsIgnoreCase(strategy)){
            return new HumanPlayerStrategy();
        }
        return null;
    }

}
