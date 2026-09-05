import java.util.Random;

public class DepartmentBmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Height and weight datasets must be non-null and match in length.");
        }

        System.out.println("=".repeat(62));
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-".repeat(62));

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];

            if (h <= 0 || w <= 0) {
                System.out.printf("Person %-3d | Invalid measurements (must be > 0)%n", (i + 1));
                continue;
            }

            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n", (i + 1), h, w, bmi, status);
        }
        System.out.println("=".repeat(62));
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random random = new Random();

        // Heights between 1.50m - 1.95m, Weights between 50kg - 110kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            weights[i] = 50.0 + (random.nextDouble() * 60.0);
        }

        try {
            printWellnessReport(heights, weights);
        } catch (IllegalArgumentException e) {
            System.err.println("Error generating wellness report: " + e.getMessage());
        }
    }
}