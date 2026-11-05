import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeLookup {

    public static class EmployeeRecord {
        String employeeId;
        String department;

        public EmployeeRecord(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<EmployeeRecord> records) {
        Map<String, String> lookup = new HashMap<>();
        for (EmployeeRecord record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        List<EmployeeRecord> records = List.of(
            new EmployeeRecord("E245", "Finance"),
            new EmployeeRecord("E110", "Engineering"),
            new EmployeeRecord("E390", "Marketing"),
            new EmployeeRecord("E101", "Engineering")
        );

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390")); // Marketing
        System.out.println(getDepartment(lookup, "E999")); // Unknown
    }
}
