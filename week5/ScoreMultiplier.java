import java.util.Arrays;

public class ScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) return;

        // Apply 2x multiplier to Captain
        playerScores[captainIndex] *= 2.0;

        // Apply 1.5x multiplier to Vice-Captain
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40.0, 55.0, 30.0, 62.0};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
