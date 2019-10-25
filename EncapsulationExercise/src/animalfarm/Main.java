package animalfarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            Chicken chicken = new Chicken(reader.readLine(),Integer.parseInt(reader.readLine()));
            System.out.println(chicken.toString());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
