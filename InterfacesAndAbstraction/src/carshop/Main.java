package carshop;

public class Main {
    public static void main(String[] args) {
        Car seat = new Seat("Leon","gray",110,"Spain",35000.0);
        Car audi = new Audi("A4","gray",120,"Germany",3,99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format("%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower().toString()));
        System.out.println(car.toString());
    }
}
