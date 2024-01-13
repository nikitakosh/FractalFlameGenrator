package org.nikitakosh.transformations;

import org.nikitakosh.models.Point;

public class LinearTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(point.x(), point.y());
    }
}
