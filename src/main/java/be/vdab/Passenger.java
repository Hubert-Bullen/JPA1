package be.vdab;

import sun.security.krb5.internal.PAData;
import sun.security.util.Length;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Hyuberuto on 26/05/15.
 */
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int freqFlyerMiles;

    @Lob /*Large object*/
    private Byte[] picture;

    @Column (length = 50)
    private String firstName;

    @Column (length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(/*nullable = false,*/ updatable = false) // Sneller voor tests te schrijven zonder nullable
    private Date dateOfBirth;

    @Transient
    private int age;

    @Enumerated(EnumType.STRING) // Staat er nu in als String in de tabel.
    @Column (name = "passenger_type"/*, nullable = false*/) // Eerste keer zal die naam altijd een "error" zijn want je geeft een tabel die nog niet bestaat al een naam.
    private Passengertype ptype;

    public Passenger(int freqFlyerMiles, Byte[] picture, String firstName, String lastName, Date dateOfBirth, int age, Passengertype ptype) {
        this.freqFlyerMiles = freqFlyerMiles;
        this.picture = picture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.ptype = ptype;
    }


    public Passenger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFreqFlyerMiles() {
        return freqFlyerMiles;
    }

    public void setFreqFlyerMiles(int freqFlyerMiles) {
        this.freqFlyerMiles = freqFlyerMiles;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Passengertype getPtype() {
        return ptype;
    }

    public void setPtype(Passengertype ptype) {
        this.ptype = ptype;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", freqFlyerMiles=" + freqFlyerMiles +
                ", picture=" + Arrays.toString(picture) +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", ptype=" + ptype +
                '}';
    }


}
