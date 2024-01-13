package org.nikitakosh.transformations;

import org.nikitakosh.models.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.x() * point.x() + point.y() * point.y();
        return new Point(point.x() / r, point.y() / r);
    }
}
