package vehicles;

public interface Vehicle {
    String driveWithPeople(double distance);
    void refuel(double fuel);
    String driveWithoutPeople(double distance);
}
