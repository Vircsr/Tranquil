package entity;

import android.media.Image;

/**
 * Music Bean
 * param1 ID
 * param2 歌名
 * param3 歌手
 * param4 封面照片
 * param5 歌词
 * param6 歌曲路径
 */
public class Music {
    private int id;
    private String name;
    private String singer;
    private Image image;
    private String Lyrics;
    private String path;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
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
    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
}
