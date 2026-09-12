class Student {
    // Instance fields
    String name;
    double attendance;

    // Static fields shared across all instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor increments studentCount
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method referencing only static fields
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        // Create two Student instances
        Student s1 = new Student("Alice", 85.0);
        Student s2 = new Student("Bob", 92.5);

        // Call printCollegeInfo() via the class name
        Student.printCollegeInfo();
    }
}
