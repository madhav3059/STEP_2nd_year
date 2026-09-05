import java.util.Arrays;

public class PlacementEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Composite formula derived from example: (CGPA * 10) + (codingScore * 0.5)
        public double getCompositeScore() {
            return (this.cgpa * 10.0) + (this.codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            // Descending order by composite score
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    // Direct CGPA-only filter (e.g., CGPA >= 7.0)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Borderline CGPA filter requiring a strong coding score (e.g., CGPA >= 6.5 and codingScore >= 60)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;

        // Count eligible candidates
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                eligibleCount++;
            }
        }

        // Filter into array
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                shortlisted[index++] = c;
            }
        }

        // Rank using standard library Arrays.sort() relying on Comparable
        Arrays.sort(shortlisted);

        // Build formatted leaderboard string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1).append(". ")
              .append(shortlisted[i].getName())
              .append(" (").append(String.format("%.1f", shortlisted[i].getCompositeScore())).append(")");

            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
