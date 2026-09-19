public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int index;

    public TrafficLight(String id) {
        this.id = id;
        this.index = 0;
    }

    public String next() {
        index = (index + 1) % COLORS.length;
        return COLORS[index];
    }

    public String getColor() {
        return COLORS[index];
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
