package com.xo.game.Model;


import com.xo.game.Model.Exceptions.InvalidPointException;

import java.awt.*;

public class Field {
    private final int fieldSize;
    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public int getSize(){
        return  fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point){
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate){
        return coordinate >= MIN_COORDINATE && coordinate < field.length;
    }


}
