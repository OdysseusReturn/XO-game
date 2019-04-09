package com.xo.game.Controller;

import com.xo.game.Model.Exceptions.AlreadyOccupiedException;
import com.xo.game.Model.Exceptions.InvalidPointException;
import com.xo.game.Model.Field;
import com.xo.game.Model.Figure;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null){
            throw new AlreadyOccupiedException();
        }

    }

}
