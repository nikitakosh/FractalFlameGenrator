package org.nikitakosh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nikitakosh.image.FractalImage;
import org.nikitakosh.models.Rect;
import org.nikitakosh.renderers.MultiThreadRenderer;
import org.nikitakosh.transformations.LinearTransformation;

import java.util.List;

public class MultiThreadRendererTest {

    @Test
    @DisplayName("render image")
    public void render() {
        MultiThreadRenderer multiThreadRenderer = new MultiThreadRenderer();
        Assertions.assertDoesNotThrow(() -> multiThreadRenderer.render(
                FractalImage.create(1000, 1000),
                new Rect(0, 0, 1, 1),
                List.of(
                        new LinearTransformation()
                ),
                10,
                1000000,
                10,
                10
        ));
    }
}
