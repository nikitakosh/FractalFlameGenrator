package org.nikitakosh.renderers;

import org.nikitakosh.image.FractalImage;
import org.nikitakosh.models.Rect;
import org.nikitakosh.transformations.Transformation;

import java.util.List;

@FunctionalInterface
public interface Renderer {
    FractalImage render(FractalImage canvas, Rect world,
                        List<Transformation> variations,
                        int samples, int iterPerSample,
                        int countAffine, int symmetry);
}
