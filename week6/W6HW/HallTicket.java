class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Create initial object
        HallTicket priya = new HallTicket("Priya", 0);

        // Alias reference pointing to the same object
        HallTicket copy = priya;

        // Mutate via the alias
        copy.seatNumber = 45;

        // Verify changes and reference equality
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        // Create an independent object with identical data
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}
