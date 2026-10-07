import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected final double distanceKm;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return 2500 + 4.0 * distanceKm;
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] modes = new String[n];
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distanceKm = sc.nextDouble();
            modes[i] = mode;

            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distanceKm);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distanceKm);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distanceKm);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown mode: " + mode);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f%n", modes[i], bookings[i].calculateTotal());
        }
    }
}
