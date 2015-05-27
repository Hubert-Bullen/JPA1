package be.vdab;

import javax.persistence.*;

/**
 * Created by Hyuberuto on 27/05/15.
 */
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private int length;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Film(String title, int length, Genre genre) {
        this.title = title;
        this.length = length;
        this.genre = genre;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
