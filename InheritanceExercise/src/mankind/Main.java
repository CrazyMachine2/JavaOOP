package mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            String[] studentData = scan.nextLine().split(" ");
            Student student = new Student(studentData[0], studentData[1], studentData[2]);

            String[] workerData = scan.nextLine().split(" ");
            Worker worker = new Worker(workerData[0], workerData[1]
                    , Double.parseDouble(workerData[2]), Double.parseDouble(workerData[3]));


           StringBuilder sb = new StringBuilder();
           sb.append(student.toString());
           sb.append(worker.toString());

            System.out.print(sb);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
