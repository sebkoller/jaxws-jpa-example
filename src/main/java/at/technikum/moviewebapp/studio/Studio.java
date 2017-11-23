package at.technikum.moviewebapp.studio;

import at.technikum.moviewebapp.movie.Movie;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "country_code", "post_code"}))
@XmlAccessorType(XmlAccessType.FIELD)
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    @Column(nullable = false)
    @XmlAttribute
    private String name;

    @Column(name = "country_code")
    @Pattern(regexp = "[A-Z]{2}")
    @XmlAttribute(name = "countrycode")
    private String countryCode;

    @Column(name = "post_code")
    @XmlAttribute(name = "postcode")
    private String postCode;

    @OneToMany(
        mappedBy = "studio"
    )
    @XmlTransient
    private Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postcode) {
        this.postCode = postcode;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "studio{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", postcode='" + postCode + '\'' +
            ", movies=" + movies +
            '}';
    }

}
