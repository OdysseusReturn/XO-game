package com.xo.game.Controller;

import com.xo.game.Model.Exceptions.InvalidPointException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException{
        Figure winner = null;
        try {
            //rows check
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), new Point(i, 1), new Point(i, 2))) {
                    winner = field.getFigure(new Point(i, 0));
                    return winner;
                }
            }
            //columns check
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), new Point(1, i), new Point(2, i))) {
                    winner = field.getFigure(new Point(0, i));
                    return winner;
                }
            }
            //diagonal1 check
            if (check(field, new Point(0, 0), new Point(1, 1), new Point(2, 2))) {
                winner = field.getFigure(new Point(0, 0));
                return winner;
            }
            //diagonal2 check
            if (check(field, new Point(0, 2), new Point(1, 1), new Point(2, 0))) {
                winner = field.getFigure(new Point(1, 1));
                return winner;
            }

        }catch (InvalidPointException e){
            e.printStackTrace();
        }
        return winner;

    }

    private boolean check(final Field field, final Point p1, final Point p2, final Point p3){
        try {
            if (field.getFigure(p1) == null){
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2) && field.getFigure(p1) == field.getFigure(p3)){
                return false;
            }
        }catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }



}
