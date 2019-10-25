package trafficlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] colorsOfTrafficLights = scan.nextLine().split(" ");
        List<TrafficLight> trafficLights = new ArrayList<>();

        createTrafficLights(colorsOfTrafficLights, trafficLights);

        int numberOfIterations = Integer.parseInt(scan.nextLine());
        print(trafficLights, numberOfIterations);

    }

    private static void print(List<TrafficLight> trafficLights, int n) {
        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.setColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }

    private static void createTrafficLights(String[] colorsOfTrafficLights, List<TrafficLight> trafficLights) {
        for (String colorOfTrafficLight : colorsOfTrafficLights) {
            Color color = Color.valueOf(colorOfTrafficLight);
            TrafficLight trafficLight = new TrafficLight(color);
            addTrafficLight(trafficLights, trafficLight);
        }
    }

    private static void addTrafficLight(List<TrafficLight> trafficLights, TrafficLight trafficLight) {
        trafficLights.add(trafficLight);
    }
}