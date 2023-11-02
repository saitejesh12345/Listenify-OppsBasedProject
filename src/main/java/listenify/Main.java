package listenify;

//import listenify.Album;
//import listenify.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Listenify world");

        // Creating albums and adding songs to them
        Album album1 = new Album("New Hindi Song", "Arijit Singh");
        album1.addSong(new Song("Tum hi ho", "Arijit Singh", 3));
        album1.addSong(new Song("unholy", "Arijit Singh", 2));
        album1.addSong(new Song("Perfect GF", "Arijit Singh", 5));
        album1.addSong(new Song("tere bhhi na", "Arijit Singh", 4));

        Album album2 = new Album("Old Hindi Songs", "Kishore Kumar");
        album2.addSong(new Song("neele neele amber prr", "Kishore Kumar", 5));
        album2.addSong(new Song("Mere Mehboob Qayamat", "Kishore Kumar", 4));
        album2.addSong(new Song("ek chatur naar", "Kishore Kumar", 2));
        album2.addSong(new Song("Mere Sapnon Ki Rani", "Kishore Kumar", 3));

        PlayList myPlayList = new PlayList("myplaylist");
        myPlayList.addSongFromAlbum(album1, 2); //unholy
        myPlayList.addSongFromAlbum(album1, "Perfect GF");
        myPlayList.addSongFromAlbum(album2, 2);//Mere
        myPlayList.addSongFromAlbum(album2, 3);//ek chatur
        myPlayList.addSongFromAlbum(album2, 1);//neele

        System.out.println(myPlayList.playCurrentSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playPreviousSong());
        System.out.println(myPlayList.playNextSong());

//        // Creating a playlist and adding songs from different albums
//        List<Song> playList = new ArrayList<>();
//        album1.addSong(1, playList);
//        album1.addSongToPlayList(4, playList);
//        album2.addSongToPlayList("Mere Mehboob Qayamat", playList);
//        album2.addSongToPlayList("neele neele amber prr", playList);
//
//        // Printing the menu and starting the songs
//        printMenu();
//        startSongs(playList);
//    }
//
//    public static void startSongs(List<Song> playlist) {
//        int index = 0;
//        System.out.println("Now playing " + playlist.get(index).toString());
//        Scanner sc = new Scanner(System.in);
//        boolean continuePlayList = true;
//
//        while (continuePlayList) {
//            System.out.println("Enter your choice!! ");
//            int choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    if (index == (playlist.size() - 1)) {
//                        index++;
//                    } else {
//                        index = 0;
//                    }
//                    System.out.println("Now playing " + playlist.get(index).toString());
//                    break;
//                case 2:
//                    if (index == 0)
//                        index = 0;
//                    else
//                        index--;
//                    System.out.println("Now playing " + playlist.get(index).toString());
//                    break;
//                case 3:
//                    System.out.println("Now playing " + playlist.get(index).toString());
//                    break;
//                case 4:
//                    printPlayList(playlist);
//                    break;
//                case 5:
//                    printMenu();
//                    break;
//                case 6:
//                    playlist.remove(index);
//                    if (index == playlist.size()) {
//                        index = 0;
//                    }
//                    break;
//                case 7:
//                    Collections.shuffle(playlist);
//                    break;
//                case 8:
//                    continuePlayList = false;
//                    break;
//            }
//        }
//    }
//
//    public static void printPlayList(List<Song> playList) {
//        for (Song song : playList) {
//            System.out.println(song.toString());
//        }
//    }
//
//    public static void printMenu() {
//        System.out.println("These are the options you can choose from ");
//        System.out.println("1. Goto and play next Song");
//        System.out.println("2. Goto the previous Song");
//        System.out.println("3. Repeat the same Song");
//        System.out.println("4. Show all songs of playList");
//        System.out.println("5. Print the Menu");
//        System.out.println("6. Delete the current song");
//        System.out.println("7. Shuffle the playList");
//        System.out.println("8. Exit the playList");
//    }
    }
}