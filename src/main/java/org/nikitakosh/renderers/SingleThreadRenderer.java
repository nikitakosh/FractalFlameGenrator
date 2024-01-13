package org.nikitakosh.renderers;

import org.nikitakosh.image.FractalImage;
import org.nikitakosh.models.Point;
import org.nikitakosh.models.Rect;
import org.nikitakosh.transformations.Transformation;

import java.util.List;


public class SingleThreadRenderer extends ThreadRenderer {
    @Override
    public FractalImage render(FractalImage canvas, Rect world,
                               List<Transformation> variations,
                               int samples, int iterPerSample, int countAffine, int symmetry) {
        for (int num = 0; num < samples; ++num) {
            oneSampleIterate(Point.random(world), variations, iterPerSample, world, canvas, countAffine, symmetry);
        }
        return canvas;
    }


}
