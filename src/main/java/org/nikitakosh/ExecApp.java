package org.nikitakosh;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.nikitakosh.transformations.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"UncommentedMain", "MultipleStringLiterals"})
public class ExecApp {

    private final static Logger LOGGER = LogManager.getLogger();
    private static double gamma;

    private ExecApp() {
    }

    public static void main(String[] args) {
        Options options = getOptions();
        CommandLineParser parser = new BasicParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            int widthImage = Integer.parseInt(cmd.getOptionValue("w", "3840"));
            int heightImage = Integer.parseInt(cmd.getOptionValue("h", "2160"));
            double xWorld = Double.parseDouble(cmd.getOptionValue("x", "-3"));
            double yWorld = Double.parseDouble(cmd.getOptionValue("y", "-2"));
            double widthWorld = Double.parseDouble(cmd.getOptionValue("ww", "6"));
            double heightWorld = Double.parseDouble(cmd.getOptionValue("wh", "6"));
            int samples = Integer.parseInt(cmd.getOptionValue("s", "10"));
            int iterPerSample = Integer.parseInt(cmd.getOptionValue("ips", "1000000"));
            int countAffine = Integer.parseInt(cmd.getOptionValue("ca", "5"));
            int symmetry = Integer.parseInt(cmd.getOptionValue("sym", "1"));
            boolean multiThread = Boolean.parseBoolean(cmd.getOptionValue("mt", "true"));
            double gamma = Double.parseDouble(cmd.getOptionValue("sym", "2.2"));
            String[] transformations = cmd.getOptionValue("t", "linear").split(",");
            List<Transformation> transformationsList = new ArrayList<>();
            for (String transformation : transformations) {
                switch (transformation) {
                    case "heart" -> transformationsList.add(new HeartTransformation());
                    case "hyperbolic" -> transformationsList.add(new HyperbolicTransformation());
                    case "linear" -> transformationsList.add(new LinearTransformation());
                    case "polar" -> transformationsList.add(new PolarTransformation());
                    case "sinusoidal" -> transformationsList.add(new SinusoidalTransformation());
                    case "spherical" -> transformationsList.add(new SphericalTransformation());
                    case "swirl" -> transformationsList.add(new SwirlTransformation());
                    default -> {
                        LOGGER.error("unknown transformation");
                        System.exit(1);
                    }
                }
            }
            if (multiThread) {
                ExecMultiThreadRender execMultiThreadRender = new ExecMultiThreadRender(widthImage,
                        heightImage,
                        xWorld,
                        yWorld,
                        widthWorld,
                        heightWorld,
                        samples,
                        iterPerSample,
                        countAffine,
                        symmetry,
                        gamma,
                        transformationsList
                );
                execMultiThreadRender.start();
            } else {
                ExecSingleThreadRender execSingleThreadRender = new ExecSingleThreadRender(widthImage,
                        heightImage,
                        xWorld,
                        yWorld,
                        widthWorld,
                        heightWorld,
                        samples,
                        iterPerSample,
                        countAffine,
                        symmetry,
                        gamma,
                        transformationsList
                );
                execSingleThreadRender.start();
            }
        } catch (ParseException e) {
            LOGGER.error("Error parsing command line arguments: " + e.getMessage());
        }
    }

    @NotNull
    private static Options getOptions() {
        Options options = new Options();
        options.addOption("w", "width_image", true, "Width of the image");
        options.addOption("h", "height_image", true, "Height of the image");
        options.addOption("x", "x_world", true, "X coordinate of the world");
        options.addOption("y", "y_world", true, "Y coordinate of the world");
        options.addOption("ww", "width_world", true, "Width of the world");
        options.addOption("wh", "height_world", true, "Height of the world");
        options.addOption("s", "samples", true, "Number of samples");
        options.addOption("ips", "iter_per_sample", true, "Iterations per sample");
        options.addOption("ca", "count_affine", true, "Count of affine");
        options.addOption("sym", "symmetry", true, "Symmetry");
        options.addOption("mt", "multi-thread", true, "Multi-thread (true/false)");
        options.addOption("g", "gamma", true, "Gamma correction coef");
        options.addOption("t", "transformations", true, "transformations (heart,linear...)");
        return options;
    }
}
