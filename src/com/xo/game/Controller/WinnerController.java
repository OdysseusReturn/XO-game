package com.xo.game.Controller;

import com.xo.game.Model.Exceptions.InvalidPointException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field){

        try {
            for (int i = 0; i < field.getSize(); i++) { //check lines
                if (check(field, new Point(i, 0), p-> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(0, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) { //check columns
                if (check(field, new Point(i, 0), p-> new Point(p.x +1, p.y ))) {i
                    return field.getFigure(new Point(0, 0));
                }
            }

            if (check(field, new Point(0, 0), p-> new Point(p.x +1, p.y + 1))) { //check diagonal 1
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(0, 0), p-> new Point(p.x+1, p.y -1))) { //check diagonal 2
                return field.getFigure(new Point(1, 1));
            }


        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            final Figure f = field.getFigure(currentPoint);
        } catch (final InvalidPointException e){
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);

        try {
            if (field.getFigure(p1) == null) {
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p1) == field.getFigure(p3)) {
                return true;
        }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private interface IPointGenerator{

        public Point next(final Point point);

    }

}
