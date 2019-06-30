package entity;

import android.media.Image;

/**
 * Music Bean
 * param1 ID
 * param2 歌名
 * param3 歌手
 * param4 封面照片
 * param5 歌词
 */
public class Music {
    private long id;//song's id
    private String name;//song name
    private String singer;//singer
    private String path;//歌曲所在地址
    private String album;//专辑名
    private long size;//歌曲所占空间大小
    private int duration;//歌曲长度
    private long albumId;//图片id
    private Image image;
    private String Lyrics;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getSinger() {
        return singer;
    }
    public void setLyrics(String lyrics) {
        Lyrics = lyrics;
    }
    public String getLyrics() {
        return Lyrics;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public Image getImage() {
        return image;
    }


    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
