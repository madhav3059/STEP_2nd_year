public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recorded = 0;
    }

    public boolean recordAnswer(boolean correct) {
        if (recorded == results.length) {
            return false;
        }
        results[recorded++] = correct;
        return true;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("score = " + sc.getScore());
        System.out.println("extra answer accepted: " + sc.recordAnswer(true));
        System.out.println("score = " + sc.getScore());
    }
}
