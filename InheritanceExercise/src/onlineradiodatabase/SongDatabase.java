package onlineradiodatabase;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public String getTotalLengthOfSongs() {
        return convertIntoHoursMinutesSeconds().toString();
    }

    private StringBuilder convertIntoHoursMinutesSeconds() {
        StringBuilder sb = new StringBuilder();
        int totalSeconds = 0;

        for (Song song : this.songs) {
            String[] lengthData = song.getLength().split(":");

            int minutesInSeconds = 0;
            int seconds = 0;

            if (lengthData.length == 2) {
                minutesInSeconds = Integer.parseInt(lengthData[0]) * 60;
                seconds = Integer.parseInt(lengthData[1]);
            } else {
                seconds = Integer.parseInt(lengthData[0]);
            }

            totalSeconds += minutesInSeconds + seconds;
        }

        int overallHours = totalSeconds / 3600;
        int remainder = totalSeconds - overallHours * 3600;
        int overallMinutes = remainder / 60;
        remainder = remainder - overallMinutes * 60;
        int overallSeconds = remainder;

        sb.append(overallHours).append("h").append(" ")
                .append(overallMinutes).append("m").append(" ")
                .append(overallSeconds).append("s");
        return sb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Songs added: ").append(this.songs.size())
                .append(System.lineSeparator())
                .append("Playlist length: ").append(this.getTotalLengthOfSongs());

        return sb.toString();
    }
}
