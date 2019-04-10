package com.xo.game;

import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;
import com.xo.game.Model.Game;
import com.xo.game.Model.Player;
import com.xo.game.View.ConsoleView;

public class XOClient {
    public static void main(String[] args) {
        final String name1 = "Dima";
        final String name2 = "AlsoDima";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name1, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)){
            consoleView.show(gameXO);

        }
    }
}
