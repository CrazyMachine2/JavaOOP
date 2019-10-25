package trafficlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<TrafficLight> trafficLights = new ArrayList<>();

        String[]data = scan.nextLine().split(" ");

        createTrafficLight(trafficLights, data);
        int numberOfChanges = Integer.parseInt(scan.nextLine());
        print(trafficLights, numberOfChanges);
    }

    private static void print(List<TrafficLight> trafficLights, int numberOfChanges) {
        for (int i = 0; i < numberOfChanges; i++) {
            for (TrafficLight trafficLight : trafficLights){
                trafficLight.changeState();
                System.out.print(trafficLight.getState() + " ");
            }
            System.out.println();
        }
    }

    private static void createTrafficLight(List<TrafficLight> trafficLights, String[] data) {
        for (String color : data){
            State state = State.valueOf(color);
            TrafficLight trafficLight = new TrafficLight(state);
            trafficLights.add(trafficLight);
        }
    }
}
