import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public boolean addSong(String title) {
        if (songCount == songs.length) {
            return false;
        }
        songs[songCount++] = title;
        return true;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Copy: " + Arrays.toString(copy));
        System.out.println("Playlist: " + Arrays.toString(p.getSongs()));
        System.out.println("Count: " + p.getSongCount());
    }
}
