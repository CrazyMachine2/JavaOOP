package vehicles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carData = scan.nextLine().split(" ");
        String[] truckData = scan.nextLine().split(" ");
        String[] busData = scan.nextLine().split(" ");

        VehicleImpl car = createCar(carData);
        VehicleImpl truck = createTruck(truckData);
        VehicleImpl bus = createBus(busData);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");

            if(input[0].contains("Drive")){
                driveVehicle(car, truck,bus, input);
            } else if (input[0].equals("Refuel")){
                refuelVehicle(car, truck,bus, input);
            }
        }
        print(car.toString());
        print(truck.toString());
        print(bus.toString());
    }



    private static void refuelVehicle(VehicleImpl car, VehicleImpl truck, VehicleImpl bus, String[] input) {
       try {
           if(input[1].equals("Car")){
               car.refuel(Double.parseDouble(input[2]));
           } else if (input[1].equals("Truck")){
               truck.refuel(Double.parseDouble(input[2]));
           } else {
               bus.refuel(Double.parseDouble(input[2]));
           }
       } catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
       }
    }

    private static void driveVehicle(VehicleImpl car, VehicleImpl truck, VehicleImpl bus, String[] input) {
        String driveResult = "";
        if(input[1].equals("Car")){
          driveResult = car.driveWithPeople(Double.parseDouble(input[2]));
        } else if (input[1].equals("Truck")){
            driveResult = truck.driveWithPeople(Double.parseDouble(input[2]));
        } else {
            if (input[0].equals("Drive")){
                driveResult = bus.driveWithPeople(Double.parseDouble(input[2]));
            } else {
                driveResult = bus.driveWithoutPeople(Double.parseDouble(input[2]));
            }
        }
        print(driveResult);
    }

    private static VehicleImpl createCar(String[] vehicleData) {
        return new Car (Double.parseDouble(vehicleData[1]),Double.parseDouble(vehicleData[2]),
                Double.parseDouble(vehicleData[3]));
    }

    private static VehicleImpl createTruck(String[] vehicleData) {
        return new Truck (Double.parseDouble(vehicleData[1]),Double.parseDouble(vehicleData[2]),
                Double.parseDouble(vehicleData[3]));
    }

    private static VehicleImpl createBus(String[] vehicleData) {
        return new Bus (Double.parseDouble(vehicleData[1]),Double.parseDouble(vehicleData[2]),
                Double.parseDouble(vehicleData[3]));
    }
    private static void print(String result){
        System.out.println(result);
    }
}




















