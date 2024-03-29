package org.nikitakosh.renderers;

import org.nikitakosh.image.FractalImage;
import org.nikitakosh.models.Color;
import org.nikitakosh.models.Pixel;
import org.nikitakosh.models.Point;
import org.nikitakosh.models.Rect;
import org.nikitakosh.transformations.AffineTransformation;
import org.nikitakosh.transformations.Transformation;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ThreadRenderer implements Renderer {

    public static final int STEP_FOR_NORMALIZATION = 20;

    public void oneSampleIterate(Point point, List<Transformation> variations,
                                 int iterPerSample, Rect world,
                                 FractalImage image, int countAffine, int symmetry) {
        List<AffineTransformation> affineTransformations = AffineTransformation.generate(countAffine);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Point currPoint = point;
        for (int step = -STEP_FOR_NORMALIZATION; step < iterPerSample; ++step) {
            AffineTransformation affineTransformation = affineTransformations.get(random.nextInt(countAffine));
            Transformation transformation = variations.get(random.nextInt(variations.size()));
            currPoint = affineTransformation.apply(currPoint);
            currPoint = transformation.apply(currPoint);
            if (step >= 0) {
                symmetryIterations(currPoint, world, image, symmetry, affineTransformation.getColor());
            }
        }
    }

    private void symmetryIterations(Point point, Rect world, FractalImage image, int symmetry, Color color) {
        double theta2 = 0.0;
        Point currPoint = point;
        for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
            currPoint = currPoint.rotate(world, theta2);
            if (!world.contains(point)) {
                continue;
            }
            Pixel pixel = currPoint.getPixelFromWorldToImage(world, image);
            if (pixel == null) {
                continue;
            }
            synchronized (pixel) {
                pixel.saturate(color);
            }
        }
    }


}
