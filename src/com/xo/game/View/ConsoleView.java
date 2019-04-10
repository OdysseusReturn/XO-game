package com.xo.game.View;

import com.xo.game.Controller.CurrentMoveController;
import com.xo.game.Controller.MoveController;
import com.xo.game.Controller.WinnerController;
import com.xo.game.Model.Exceptions.AlreadyOccupiedException;
import com.xo.game.Model.Exceptions.InvalidPointException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;
import com.xo.game.Model.Game;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();


    public void show(final Game game){
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++){
            if (x != 0) {
                printSeparator();
            }
                printLine(field, x);
        }
    }


    public boolean move(final Game game){
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null){
            System.out.format("Winner is: %s", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null){
            if (winner == null){
                System.out.println("No winner");
                return false;
            } else {
                System.out.format("Winner is: %s", winner);
                return false;
            }
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
            System.out.println("Point is invalid");
        }
        return true;
    }


    private Point askPoint(){
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final  String cordinateName){
        System.out.format("Please input %s:", cordinateName);
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
    }


    private void printLine(final Field field, final int x) {
        for (int y = 0; y < field.getSize(); y++){
            if (y != 0){
                System.out.print("|");
                System.out.print(" ");
            }
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");

        }
        System.out.println();
    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~");
    }


}
