package at.technikum.moviewebapp.actor;

import at.technikum.moviewebapp.gender.Gender;
import at.technikum.moviewebapp.movie.Movie;
import at.technikum.moviewebapp.util.LocalDateAdapter;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"first_name", "last_name", "birthdate"}))
@XmlAccessorType(XmlAccessType.FIELD)
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    @Column(name = "first_name", nullable = false)
    @XmlAttribute(name = "firstname")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @XmlAttribute(name = "lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @XmlAttribute(name = "sex")
    private Gender gender;

    @XmlAttribute
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate birthdate;

    @ManyToMany(
        mappedBy = "actors"
    )
    @XmlTransient
    private Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender sex) {
        this.gender = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        return "actor{" +
            "id=" + id +
            ", firstname='" + firstName + '\'' +
            ", lastname='" + lastName + '\'' +
            ", sex=" + gender +
            ", birthdate=" + birthdate +
            ", movies=" + movies +
            '}';
    }
}
