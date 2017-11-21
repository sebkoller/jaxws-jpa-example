import model.Movie;
import java.util.List;
import javax.inject.Inject;
import javax.jws.WebService;

@WebService(endpointInterface = "MovieWebService",
    serviceName = "MovieWebService",
    portName = "MovieWebServicePort")
public class MovieWebServiceImpl implements MovieWebService {

    @Inject
    private MovieService movieService;

    @Override
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Override
    public List<Movie> findByTitle(String keyword) {
        return movieService.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public boolean insertMovie(String xml) {
        return movieService.insertMovie(xml);
    }
}
