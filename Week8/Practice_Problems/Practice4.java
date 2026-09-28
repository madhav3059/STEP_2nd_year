import java.io.*;
import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String text, correct, student;
    protected double points;
    Question(String text, String correct, String student, double points) {
        this.text = text;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }
    abstract double score();
    abstract String label();
}

class McqQuestion extends Question {
    McqQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
    String label() { return "MCQ"; }
}

class TfQuestion extends Question {
    TfQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
    String label() { return "TF"; }
}

class EssayQuestion extends Question {
    EssayQuestion(String t, String c, String s, double p) { super(t, c, s, p); }
    double score() {
        String ans = student.toLowerCase();
        int matches = 0;
        for (String k : correct.split(",")) {
            k = k.trim().toLowerCase();
            if (!k.isEmpty() && ans.contains(k)) matches++;
        }
        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
    String label() { return "ESSAY"; }
}

public class Practice4 {
    static Question create(String type, String t, String c, String s, double p) {
        switch (type) {
            case "MCQ": return new McqQuestion(t, c, s, p);
            case "TF":  return new TfQuestion(t, c, s, p);
            default:    return new EssayQuestion(t, c, s, p);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Pattern quoted = Pattern.compile("\"([^\"]*)\"");
        List<Question> list = new ArrayList<>();
        while (list.size() < n) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.isEmpty()) continue;
            String type = line.substring(0, line.indexOf(' ')).toUpperCase();
            Matcher m = quoted.matcher(line);
            String[] parts = new String[3];
            int end = 0;
            for (int i = 0; i < 3 && m.find(); i++) {
                parts[i] = m.group(1);
                end = m.end();
            }
            double points = Double.parseDouble(line.substring(end).trim());
            list.add(create(type, parts[0], parts[1], parts[2], points));
        }
        double total = 0;
        for (Question q : list) {
            double s = q.score();
            total += s;
            System.out.printf("%s: %.2f%n", q.label(), s);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
