package org.nikitakosh.transformations;

import org.nikitakosh.models.Point;

public class SinusoidalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }

}
