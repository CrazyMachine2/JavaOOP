package jedigalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        StarManipulator starManipulator = new StarManipulator(galaxy);

        long sum = 0;
        while (true) {
            String input = reader.readLine();

            if (input.equals("Let the Force be with you")) {
                break;
            }

            int[] playerPositions = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] enemyPositions = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            starManipulator.destroyStars(enemyPositions);
            sum += starManipulator.collectStars(playerPositions);

        }
        System.out.println(sum);
    }
}
