public class AttendanceSheet {
    private final String[] names;
    private int count;

    public AttendanceSheet(int maxSize) {
        names = new String[maxSize];
        count = 0;
    }

    public boolean markPresent(String name) {
        if (isPresent(name) || count == names.length) {
            return false;
        }
        names[count++] = name;
        return true;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("count = " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
