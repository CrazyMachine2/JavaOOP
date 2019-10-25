package hotel;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType type = DiscountType.valueOf(input[3]);

        ReservationDetails reservation = new ReservationDetails(
                pricePerDay,
                numberOfDays,
                season,
                type
        );

        System.out.printf("%.2f%n", PriceCalculator.calculate(reservation));
    }
}
