import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    private final String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    String getOwner() {
        return owner;
    }

    abstract double area();
    abstract String shape();
}

class CirclePlot extends Plot {
    private final double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    String shape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    String shape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            switch (type) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown plot shape: " + type);
            }
        }

        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.shape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
    }
}
