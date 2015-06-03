package be.vdab;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

   /* @ManyToOne // 1 film heeft zogezegd meerdere 1 acteur, maar acteurs spelen in meerdere films.
    Actor actor; // default zodat we er aan kunnen in Actor*/

    @ManyToMany
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    private Director director;

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

    public List<Actor> getActors() {
        return actors;
    }

    public void addActors(List<Actor> actors) {
        this.actors.addAll(actors);
        for (Actor a : actors){
            a.films.add(this);
        }

    }

    public Director getDirector() {
        return director;
    }

    public void addDirector(Director d) {
        this.director = d;
        d.films.add(this);

    }
}
