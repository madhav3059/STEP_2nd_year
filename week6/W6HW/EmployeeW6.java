class EmployeeW6 {
    // Instance fields
    String empName;
    double salary;

    // Static variables shared across all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor increments employee count
    public EmployeeW6(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method without instance field references
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // Create three EmployeeW6 instances
        EmployeeW6 e1 = new EmployeeW6("Kavya", 45000);
        EmployeeW6 e2 = new EmployeeW6("Rahul", 55000);
        EmployeeW6 e3 = new EmployeeW6("Sneha", 60000);

        // Call printCompanyInfo() via the class name
        EmployeeW6.printCompanyInfo();
    }
}
