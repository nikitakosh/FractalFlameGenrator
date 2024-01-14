# Fractal Flame Generator Overview

This Java project is a multi-threaded implementation of a fractal flame generator based on the Chaos Game algorithm. The generator produces intricate and visually appealing fractal patterns by randomly selecting pixels and applying transformations.

## Project Features

1. **Color Support**: The generator produces color images, enhancing the visual richness of the fractal patterns.

2. **Logarithmic Gamma Correction**: Logarithmic gamma correction is implemented to enhance visual appeal and color representation in the generated images.

3. **Symmetry Parameter**: Users can adjust the symmetry of the fractal patterns, allowing for creative exploration and customization.

4. **Multi-threaded Generation**: The project features multi-threaded fractal generation for improved performance. Users can leverage the power of parallel processing to speed up the creation of complex fractal images.

## Getting Started

### Prerequisites
Make sure you have Java Runtime Environment (JRE) installed on your system.

### How to Run
1. Download the latest release of the project from the https://github.com/nikitakosh/FractalFlameGenrator/releases/tag/FractalFlameGenerator .
2. Open a terminal and navigate to the directory where you downloaded the JAR file.
3. Run the program with desired parameters. For example:
    ```bash
    java -jar FractalFlameGenerator.jar -w 1920 -h 1080 -x -2 -y -1 -ww 4 -wh 4 -s 5 -ips 500000 -ca 4 -sym 3 -mt false -g 2.2 -t heart,linear,spherical -p "C:\Users\nikita\Desktop\FractalFlameImage.png"
    ```
4. Find the generated image along the path you specified in the parameters
### Configuration Options

- **-w, --width_image**: Width of the generated image (default: 3840).
- **-h, --height_image**: Height of the generated image (default: 2160).
- **-x, --x_world**: X-coordinate of the world (default: -3).
- **-y, --y_world**: Y-coordinate of the world (default: -2).
- **-ww, --width_world**: Width of the world (default: 6).
- **-wh, --height_world**: Height of the world (default: 6).
- **-s, --samples**: Number of samples (default: 10).
- **-ips, --iter_per_sample**: Iterations per sample (default: 1000000).
- **-ca, --count_affine**: Count of affine transformations (default: 5).
- **-sym, --symmetry**: Symmetry factor (default: 1).
- **-mt, --multi-thread**: Enable multi-threading (true/false, default: true).
- **-g, --gamma**: Gamma correction coefficient (default: 2.2).
- **-t, --transformations**: Transformations to apply (comma-separated, e.g., "heart,linear,spherical").
- **-p, --path**: Absolute path for saving the generated picture (for example "C:\Users\nikita\Desktop\FractalFlameImage.png").

### Example

```bash
java -jar FractalFlameGenerator.jar -w 1920 -h 1080 -x -2 -y -1 -ww 4 -wh 4 -s 5 -ips 500000 -ca 4 -sym 3 -mt false -g 2.2 -t heart,linear,spherical -p "C:\Users\nikita\Desktop\FractalFlameImage.png"
```

### Example of work
1. **Heart transformation**
![fractalFlame](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/a268a50b-6ae6-412e-8764-38a32844401c)
2. **Heart transformation with symmetry**
![image](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/bedadb67-a53e-4483-b4d2-36debb14f663)
3. **Hyperbolic transformation with symmetry**
![hyperbolic](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/b7391622-18b4-4606-b77c-f0eee1788a80)
4. **Linear transformation**
![linear](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/152fda25-0d7f-40ab-826e-276ee1c56e89)
5. **Polar transformation**
![polar](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/e5181129-dbb4-4bb0-a9f2-063817f1b6e0)
6. **Sinusoidal transformation with symmetry**
![sinusoidal](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/204af048-4e03-4821-bb63-9cfd14c845fc)
7. **Spherical transformation**
![spherical](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/a3bd25c6-1ef3-4540-8380-aa5b5503ce4e)
8. **Swirl transformation**
![swirl](https://github.com/nikitakosh/FractalFlameGenrator/assets/113053952/05fe497b-206e-49ea-9f3b-42edeb3dd2d5)
