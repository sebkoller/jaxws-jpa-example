package at.technikum.moviewebapp.movie;

import at.technikum.moviewebapp.actor.Actor;
import at.technikum.moviewebapp.genre.Genre;
import at.technikum.moviewebapp.studio.Studio;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "releaseyear", "studio_id"}))
@XmlRootElement(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;

    @XmlAttribute
    @Column(nullable = false)
    private String title;

    @XmlAttribute
    @Column(columnDefinition = "text")
    private String description;

    @XmlAttribute
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @XmlAttribute
    private int length;

    @XmlAttribute(name = "releaseyear")
    private int releaseYear;

    @ManyToOne//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn
    private Studio studio;

    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_cast")
    private List<Actor> actors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "movie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", genre=" + genre +
            ", length=" + length +
            ", releaseYear=" + releaseYear +
            ", studio=" + studio +
            ", actors=" + actors +
            '}';
    }
}
