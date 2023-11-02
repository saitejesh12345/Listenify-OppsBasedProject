package listenify;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {

    private String title;
    private List<Song> songs;

    private boolean isNext;

    private ListIterator<Song> itr;

    public PlayList(String title) {
        this.title = title;
        songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public Optional<Song> findSong(String title ){
        for(Song song :songs){
            if(title.equals(song.getTitle()))
                return Optional.of(song);
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNo ){
         if(trackNo>=0 && trackNo <=songs.size())
        return Optional.of(songs.get(trackNo-1));
         return Optional.empty();
    }


    public String  addSongFromAlbum(Album album,int trackNo){
        //if(album.isSongPresent(songTitle)){
        //album.getSong();
       Optional<Song> optionalSongInAlbum = album.findSong(trackNo); //check song  present in Album

        if(optionalSongInAlbum.isEmpty()){ //if song not present in Album,if song is not available u cant add
            return "Song not Found in Album"; //to playlist
        }
           Optional<Song> optionalSongInPlaylist = findSong(optionalSongInAlbum.get().getTitle()); //check song present in playlist
       if(optionalSongInPlaylist.isPresent()){ //if song  is present already in playlist
           return "Song Already Present in Playlist";
       }

           songs.add(optionalSongInAlbum.get()); //we have to get song from album and we will add to playlist.
        itr = songs.listIterator();
        return "song added successfully";
    }

    public String  addSongFromAlbum(Album album,String songTitle){
        //if(album.isSongPresent(songTitle)){
        //album.getSong();
        Optional<Song> optionalSongInAlbum = album.findSong(songTitle); //check song  present in Album
        Optional<Song> optionalSongInPlaylist = findSong(songTitle); //check song present in playlist
        if(optionalSongInPlaylist.isPresent()){ //if song  is present already in playlist
            return "Song Already Present in Playlist";
        }
        if(optionalSongInAlbum.isEmpty()){ //if song not present in Album,if song is not available u cant add
            return "Song not Found in Album"; //to playlist
        }
        songs.add(optionalSongInAlbum.get()); //we have to get song from album and we will add to playlist.
        itr = songs.listIterator();
        return "song added successfully";

    }

    public String  playCurrentSong(){
    if(isNext){
    isNext = false;
    return "current song is "+ itr.previous();
    }
    isNext = true;
    return "current song is "+itr.next();
    }

    public String playNextSong(){
    //List Iterator it is going to iterate over list of Objects/songs
//    if(isNext){ // if song is playing from next-->next
//
//    }
    if(!isNext){ //if song is playing from previous to next
        itr.next();
        isNext=true;
    }
    if(itr.hasNext()){
        isNext=true;
        return "next song to play is:" + itr.next();
    }
    return "You have reached end of playList.There is no song after this";
    }

    public String playPreviousSong(){


        if(isNext){ //
            itr.previous();
            isNext=false;
        }
        if(itr.hasPrevious()){
            isNext=false;
            return "previous song to play is:" + itr.previous();
        }
        return "You have reached start of playList.there is no songs before this";
    }

}
