// ParcelShippingDesk.java
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double insurance(double declaredValue);
}

abstract class Parcel {
    protected final double weight;
    protected final double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double shippingCharge();

    double insurance() {
        return 0.0;
    }

    final double total() {
        return shippingCharge() + insurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 80 + 15 * weight;
    }

    public double insurance(double value) {
        return value * 0.02;
    }

    double insurance() {
        return insurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double shippingCharge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance(double value) {
        return value * 0.02;
    }

    double insurance() {
        return insurance(declaredValue);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] types = new String[n];
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (types[i]) {
                case "STANDARD": parcels[i] = new StandardParcel(weight, value); break;
                case "EXPRESS": parcels[i] = new ExpressParcel(weight, value); break;
                case "FRAGILE": parcels[i] = new FragileParcel(weight, value); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + types[i]);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            Parcel parcel = parcels[i];
            double charge = parcel.shippingCharge();
            double insurance = parcel.insurance();
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types[i], charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
