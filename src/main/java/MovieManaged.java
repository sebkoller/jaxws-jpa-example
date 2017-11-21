import model.Movie;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class MovieManaged {

    @Inject
    private MovieService movieService;
    private List<Movie> movies;

    public List<Movie> getAllMovies() {
        if (movies != null) {
            movies = movieService.getAllMovies();
        }
        return movies;
    }

}
