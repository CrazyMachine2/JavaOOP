package onlineradiodatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int songsCount = Integer.parseInt(scan.nextLine());

        SongDatabase database = new SongDatabase();

        for (int i = 0; i < songsCount; i++) {
            String[] data = scan.nextLine().split(";");


            try {
                Song song = new Song(data[0],data[1],data[2]);
                database.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(database.toString());
    }
}
