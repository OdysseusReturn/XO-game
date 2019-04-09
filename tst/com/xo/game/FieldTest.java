package com.xo.game;

import com.xo.game.Model.Exceptions.AlreadyOccupiedException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;
import com.xo.game.Model.Exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigure() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

//    @Test
//    public void setFigureWhenAlreadyOccupied() throws Exception {
//        final Field field = new Field();
//        final Point inputPoint = new Point(0,0);
//        final Figure inputFigure = Figure.O;
//
//        field.setFigure(inputPoint, inputFigure);
//
//        try {
//            field.setFigure(inputPoint, inputFigure);
//            fail();
//        } catch (final AlreadyOccupiedException e){}
//    }

    @Test
    public void GetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);

    }

    @Test
    public void GetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void GetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void GetFigureWhenXIsMoreThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize()+1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void GetFigureWhenYIsMoreThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
    @Test
    public void GetFigureWhenXYIsMoreThenZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize()+1,field.getSize()+1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }
}