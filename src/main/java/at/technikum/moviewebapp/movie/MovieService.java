package at.technikum.moviewebapp.movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    List<Movie> findByTitleContainingIgnoreCase(String keyword);
    void insertMovies(List<Movie> movies);
}
