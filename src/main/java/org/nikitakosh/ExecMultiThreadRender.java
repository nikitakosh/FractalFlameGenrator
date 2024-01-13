package org.nikitakosh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nikitakosh.image.FractalImage;
import org.nikitakosh.image.ImageFormat;
import org.nikitakosh.image.ImageUtils;
import org.nikitakosh.imageProcessors.GammaCorrectionProcessor;
import org.nikitakosh.models.Rect;
import org.nikitakosh.renderers.MultiThreadRenderer;
import org.nikitakosh.transformations.Transformation;

import java.nio.file.Path;
import java.util.List;

public class ExecMultiThreadRender {
    public static final int DEGREE_TO_SECONDS = 9;
    private final static Logger LOGGER = LogManager.getLogger();
    int widthImage;
    int heightImage;
    double xWorld;
    double yWorld;
    double widthWorld;
    double heightWorld;
    int samples;
    int iterPerSample;
    int countAffine;
    int symmetry;
    double gamma;
    List<Transformation> transformations;

    @SuppressWarnings("ParameterNumber")
    public ExecMultiThreadRender(
            int widthImage,
            int heightImage,
            double xWorld,
            double yWorld,
            double widthWorld,
            double heightWorld,
            int samples,
            int iterPerSample,
            int countAffine,
            int symmetry,
            double gamma,
            List<Transformation> transformations
    ) {
        this.widthImage = widthImage;
        this.heightImage = heightImage;
        this.xWorld = xWorld;
        this.yWorld = yWorld;
        this.widthWorld = widthWorld;
        this.heightWorld = heightWorld;
        this.samples = samples;
        this.iterPerSample = iterPerSample;
        this.countAffine = countAffine;
        this.symmetry = symmetry;
        this.gamma = gamma;
        this.transformations = transformations;
    }

    public void start() {
        MultiThreadRenderer multiThreadRenderer = new MultiThreadRenderer();
        long start = System.nanoTime();
        FractalImage fractalImage = multiThreadRenderer.render(FractalImage.create(widthImage, heightImage),
                new Rect(xWorld, yWorld, widthWorld, heightWorld),
                transformations,
                samples,
                iterPerSample,
                countAffine,
                symmetry
        );
        GammaCorrectionProcessor gammaCorrectionProcessor = new GammaCorrectionProcessor(gamma);
        gammaCorrectionProcessor.process(fractalImage);
        long finish = System.nanoTime();
        ImageUtils.save(fractalImage,
                Path.of("src/main/resources/fractalFlameImages/fractalFlame.png"),
                ImageFormat.PNG
        );
        LOGGER.info(
                "Fractal flame is drawn\nTime taken is " + (finish - start) / Math.pow(samples, DEGREE_TO_SECONDS) + " s");
    }
}
