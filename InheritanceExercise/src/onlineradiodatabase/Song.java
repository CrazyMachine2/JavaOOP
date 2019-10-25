package onlineradiodatabase;

public class Song {
    private String artistName;
    private String songName;
    private String length;

    public Song(String artistName, String songName, String length) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(length);
    }

    private void setArtistName(String artistName) {
        if (artistName.trim().isEmpty() || artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
    }

    private void setSongName(String songName) {
        if (songName.trim().isEmpty() || songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
    }

    private void setLength(String length) {
        this.validateLength(length);
        this.length = length;
    }

    public String getLength() {
        return this.length;
    }

    private void validateLength(String length) {
        String[] lengthData = length.split(":");

        if (lengthData.length == 2) {
            int minutes = Integer.parseInt(lengthData[0]);
            int seconds = Integer.parseInt(lengthData[1]);

            if (minutes < 0 || minutes > 14) {
                throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
            }

            if (seconds < 0 || seconds > 59) {
                throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
            }
        } else if (lengthData.length == 1) {
            int seconds = Integer.parseInt(lengthData[0]);

            if (seconds < 0 || seconds > 59) {
                throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
            }
        } else {
            throw new InvalidSongLengthException("Invalid song length.");
        }

    }
}
