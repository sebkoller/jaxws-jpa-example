package model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "countryCode", "postcode"}))
@XmlAccessorType(XmlAccessType.FIELD)
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    private long id;

    @Column(nullable = false)
    private String name;

    private String countryCode;

    private String postcode;

    @OneToMany(
        mappedBy = "studio",
        fetch = FetchType.LAZY
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Studio{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", postcode='" + postcode + '\'' +
            ", movies=" + movies +
            '}';
    }
}
