package com.example.sambennett.gopaintyourself;

import android.graphics.Color;

/**
 * Created by sambennett on 3/21/15.
 */
public class Square {
    private int diameter;
    private Color color;

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square(int diameter, Color color) {
        this.diameter = diameter;

        this.color = color;
    }
}
