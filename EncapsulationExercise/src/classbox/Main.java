package classbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Box box = new Box(Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine()),
                    Double.parseDouble(reader.readLine()));
            System.out.println(box.toString());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
