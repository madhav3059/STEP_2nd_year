import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionDuplicateCheck {

    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> batch1 = List.of("TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004");
        List<String> batch2 = List.of("TXN2001", "TXN2002", "TXN2003");

        System.out.println(hasDuplicate(batch1)); // true
        System.out.println(hasDuplicate(batch2)); // false
    }
}
