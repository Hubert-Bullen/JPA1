package be.vdab;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyuberuto on 03/06/15.
 */

@Entity
public class Director {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Enumerated (EnumType.STRING)
    private Gender gender;

   /* @OneToMany *//*(mappedBy = "director")*/ //Moest niet Bidirectional zijn. TODO: make bidirectional.
    /*private List<Film> films = new ArrayList<>();*/

    @OneToMany (mappedBy = "director")
    List<Film> films = new ArrayList<>();

    public Director(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Director() {
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

    public List<Film> getFilms() {
        return films;
    }
}
