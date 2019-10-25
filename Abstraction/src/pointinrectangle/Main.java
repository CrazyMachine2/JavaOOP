package pointinrectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         int[] rectangleCoordinates = readingArray(scan);

        Point topLeft = new Point(rectangleCoordinates[0],rectangleCoordinates[1]);
        Point bottomRight = new Point(rectangleCoordinates[2],rectangleCoordinates[3]);

        Rectangle rect = new Rectangle(topLeft,bottomRight);

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoordinate = readingArray(scan);

            Point current = new Point(pointCoordinate[0],pointCoordinate[1]);

            System.out.println(rect.contains(current));
        }
    }

    private static int[] readingArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
