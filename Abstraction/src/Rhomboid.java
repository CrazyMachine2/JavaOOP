import java.util.Scanner;

public class Rhomboid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxWidth = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= maxWidth - 1; i++) {
            printRow(maxWidth, i);
        }
        System.out.println(repeatString("* ", maxWidth - 1) + "*");

        for (int i = maxWidth - 1; i > 0; i--) {
            printRow(maxWidth, i);
        }
    }

    private static void printRow(int maxWidth, int row) {
        System.out.print(repeatString(" ", maxWidth - row));
        System.out.print(repeatString("* ", row));
        System.out.println();
    }

    private static String repeatString(String sequence, int times){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            sb.append(sequence);
        }
        return sb.toString();
    }
}
