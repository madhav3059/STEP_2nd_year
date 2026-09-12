class IdCard {
    String name;
    int booksIssued;

    // Constructor
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // First object
        IdCard ravi = new IdCard("Ravi", 0);

        // Reference copy pointing to the exact same object
        IdCard duplicate = ravi;

        // Change value through second variable
        duplicate.booksIssued = 3;

        // Print value seen through first variable and reference equality
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Third independent object with identical data
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
