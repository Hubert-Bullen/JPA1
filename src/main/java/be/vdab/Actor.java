package be.vdab;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyuberuto on 27/05/15.
 */
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

/*    @OneToMany(mappedBy = "actor")  // verwijst naar naam van het veld op Film class, Film is "owner" vandaar dat de add en remove bij deze staan.
    private List<Film> films;*/

    @ManyToMany (mappedBy = "actors")
     List<Film> films = new ArrayList<>();

    public Actor(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Actor() {
    }

    public String fullName(){
        return lastName + " " + firstName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

/*    public void addFilm(Film f){
        this.films.add(f);
        f.actor = this;
    }

    public void removeFilm(Film f){
        this.films.remove(f);
        f.actor = null;
    }*/

    public List<Film> getFilms() {
        return films;
    }
}
