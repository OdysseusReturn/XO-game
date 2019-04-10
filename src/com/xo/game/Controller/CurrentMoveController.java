package com.xo.game.Controller;

import com.xo.game.Model.Exceptions.InvalidPointException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field){
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++){
            countFigure += countFiguresInTheRow(field, x);
        }
        if (countFigure == field.getSize() * field.getSize()){
            return null;
        }

        if (countFigure % 2 == 0){
            return Figure.X;
        }

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row){
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++){
            try {
                if(field.getFigure(new Point(x, row)) != null){
                    countFigure++;
                }
            } catch (InvalidPointException e){
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
