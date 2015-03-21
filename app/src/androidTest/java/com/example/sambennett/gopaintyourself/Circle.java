package com.example.sambennett.gopaintyourself;

import android.graphics.Color;

/**
 * Created by sambennett on 3/21/15.
 */
public class Circle {
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private int radius;
    private Color color;

    public Circle(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }
}
