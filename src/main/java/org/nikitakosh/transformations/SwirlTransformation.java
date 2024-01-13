package org.nikitakosh.transformations;

import org.nikitakosh.models.Point;

public class SwirlTransformation implements Transformation {
    public static final double DEGREE = 0.5;

    @Override
    public Point apply(Point point) {
        double r = Math.pow(point.x() * point.x() + point.y() * point.y(), DEGREE);
        return new Point(
                point.x() * Math.sin(r * r) - point.y() * Math.cos(r * r),
                point.x() * Math.cos(r * r) + point.y() * Math.sin(r * r)
        );
    }
}
