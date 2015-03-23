package com.example.sambennett.gopaintyourself;

import android.graphics.Color;
import android.graphics.Path;

/**
 * Created by sambennett on 3/21/15.
 */
public class Line {
    private Path path;
    private int stroke;
    private Color color;

    public Path getPath() {
        return path;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Line(int stroke, Color color) {
        this.path = new Path();
        this.stroke = stroke;
        this.color = color;
    }


}
