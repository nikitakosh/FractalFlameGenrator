package org.nikitakosh.transformations;

import org.nikitakosh.models.Point;

public class HeartTransformation implements Transformation {

    public static final double DEGREE = 0.5;

    @Override
    public Point apply(Point point) {
        double r = Math.pow(point.x() * point.x() + point.y() * point.y(), DEGREE);
        double theta = Math.atan(point.x() / point.y());
        return new Point(
                r * Math.sin(theta * r),
                r * -Math.cos(theta * r)
        );
    }
}
