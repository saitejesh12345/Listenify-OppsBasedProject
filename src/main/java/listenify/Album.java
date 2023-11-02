package listenify;
import listenify.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private String albumName;
    private List<Song> songList;
    private String artistName;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public Album(String albumName, List<Song> songList, String artistName) {
        this.albumName = albumName;
        this.songList = songList;
         this.artistName = artistName;
    }

    //particular Song songToSearch=xyz/Jeenamera
    // is searching  the Song of temp variable song iterationg over songlist

    //method overloading findSong(with two different parameters)
//    public boolean findSong(Song songToSearch){
//        for (Song song :songList){
//            if(
//            songToSearch.getTitle().equals(song.getTitle()) &&
//            songToSearch.getArtist().equals(song.getArtist())
//            )return true;
//        }
//        return  false;
//    }

    //Optional we use like if it is true means i want that song also to return
    //Optional it ask what class it holds it can have objects then return  optional.of(song);
    //if it couldn't find the title then return optional.empty();

    //five methods in Optional
    //optional.of(object)
    //optional.empty()
    //To check object is present or not
    //optional.ispresent()
    //optional.isempty()
    //Optional.get()
    //if it return true and we need to get song means ie object then use Optional.get()
    public Optional<Song> findSong(String title,String artistName){
        for(Song song :songList){
            if(title.equals(song.getTitle()) && artistName.equals(song.getArtist()))
                return Optional.of(song);
        }
        return Optional.empty();
    }
    public Optional<Song> findSong(String title ){
        for(Song song :songList){
            if(title.equals(song.getTitle()))
                return Optional.of(song);
        }
        return Optional.empty();
    }


    public Optional<Song> findSong(int trackNo ){
        if(trackNo>=0 && trackNo <=songList.size())
            return Optional.of(songList.get(trackNo-1));
        return Optional.empty();
    }

    public String  addSong(Song song){
        //check if song already present dont add song
        Optional<Song> optionalSong = findSong(song.getTitle());
        if(optionalSong.isPresent()){ //if(!Optional.isEmpty())
        return "Song already exists in Album";
        }
        songList.add(song);
        return "Song added to Album";
    }








//
//    public String getAlbumName() {
//        return albumName;
//    }
//
//    public void setAlbumName(String albumName) {
//        this.albumName = albumName;
//    }
//
//    public List<Song> getSongList() {
//        return songList;
//    }
//
//    public void setSongList(List<Song> songList) {
//        this.songList = songList;
//    }
//
//    public String getArtistName() {
//        return artistName;
//    }
//
//    public void setArtistName(String artistName) {
//        this.artistName = artistName;
//    }
//
//    public boolean findSong(String enteredTitle) {
//        // You need to check if the song is present in this album or not
//        for (Song song : songList) {
//            if (song.getTitle().equals(enteredTitle))
//                return true;
//        }
//        return false;
//    }
//
//    public String addNewSongToAlbum(String title, double duration) {
//        // Adding to the songList
//        // Steps 1. Check if it's already present
//        if (findSong(title)) {
//            return "Song is already present in the songList";
//        }
//        // If I find out the song, I say song is already present in songList
//        Song newSong = new Song(title, duration); //add new song to Song Class
//        songList.add(newSong); // add that song object to songList
//        return "New Song with title " + title + " has been added to the SongList";
//    }
//
//    public String addSongToPlayList(int songNo, List<Song> playList) {
//        int index = songNo - 1;
//        if (index >= 0 && index < songList.size()) {
//            Song song = songList.get(index);
//            playList.add(song);
//            return "Song has been added to the playList";
//        } else {
//            return "Song No is out of range";
//        }
//    }
//
//    public String addSongToPlayList(String title, List<Song> playList) {
//        for (Song song : songList) {
//            if (song.getTitle().equals(title)) {
//                playList.add(song);
//                return "Song added to playList successfully";
//            }
//        }
//        return "Song could not be found in Album";
//    }
}
