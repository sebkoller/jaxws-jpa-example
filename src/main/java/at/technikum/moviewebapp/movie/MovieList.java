package at.technikum.moviewebapp.movie;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class' sole purpose is to add an element wrapper called 'movies' to the jaxb xml
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movies")
public class MovieList {

    @XmlElement(name = "movie")
    private List<Movie> list;

    public List<Movie> getList() {
        return list;
    }

    public void set(List<Movie> setList) {
        this.list = list;
    }
}
