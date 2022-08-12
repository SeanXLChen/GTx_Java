import java.util.ArrayList;

public class StringArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("A story be told");
        playlist.add("Boys day");
        playlist.add("California Dream");
        playlist.add("Day by Day");
        playlist.add("East Lake");
        System.out.println("Original: " + playlist.toString());

        playlist.remove("A story be told");
        System.out.println("Modified: " + playlist.toString());
        System.out.println(playlist.contains("A story be told"));
        System.out.println(playlist.contains("Boys day"));
        playlist.add("A story be told");
        System.out.println("Final: " + playlist.toString());
    }
}
