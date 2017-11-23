package at.technikum.moviewebapp.movie;

import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MovieWebService {

    @WebMethod
    @XmlElementWrapper(name = "movies", required = true)
    @XmlElement(name = "movie", required = true)
    List<Movie> getAllMovies();

    @WebMethod
    @XmlElementWrapper(name = "movies", required = true)
    @XmlElement(name = "movie", required = true)
    List<Movie> findByTitle(@WebParam(name = "keyword") String keyword);

    @WebMethod
    void insertMovie(@WebParam(name = "movies") @XmlElement(required = true) MovieList movies);
}
