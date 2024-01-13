package org.nikitakosh.imageProcessors;

import org.nikitakosh.image.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
