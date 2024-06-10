package class_basic.song;

public class Song {
    String title;
    String artist;
    String album;
    int year;
    String[] composer = new String[3];

    public void setAll(String title1, String artist1, String album1,
                       int year1, String[] composer1){
        title = title1;
        artist = artist1;
        album = album1;
        year = year1;
        composer = composer1;
    }

    public void info(){
        System.out.println(title);
        System.out.println(artist);
        System.out.println(album);
        System.out.println(year);
        System.out.print("작곡가 : ");
        for (int i = 0; i < composer.length; i++){
            System.out.print(composer[i] + " ");
        }
    }

}
