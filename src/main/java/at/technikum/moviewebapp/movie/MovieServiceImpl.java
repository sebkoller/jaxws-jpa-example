package at.technikum.moviewebapp.movie;

import at.technikum.moviewebapp.actor.Actor;
import at.technikum.moviewebapp.actor.ActorService;
import at.technikum.moviewebapp.studio.Studio;
import at.technikum.moviewebapp.studio.StudioService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

@Stateless
public class MovieServiceImpl implements MovieService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private StudioService studioService;

    @Inject
    private ActorService actorService;

    public List<Movie> getAllMovies() {
        return em
            .createQuery(
                "select distinct m from Movie m " +
                    "inner join fetch m.actors a", Movie.class)
            .getResultList();
    }

    public List<Movie> findByTitleContainingIgnoreCase(String keyword) {
        return em
            .createQuery(
                "select distinct m from Movie m " +
                    "left join fetch m.actors a " +
                    "where lower(m.title) like lower(concat('%',:title,'%'))", Movie.class
            )
            .setParameter("title", keyword)
            .getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void insertMovies(List<Movie> movies) {

        for (Movie movie : movies) {
            final Studio studio = studioService
                .findStudio(movie.getStudio())
                .orElseThrow(
                    () -> new IllegalStateException("Studio does not exist: " + movie.getStudio().getName())
                );

            movie.setStudio(studio);

            final ArrayList<Actor> actors = new ArrayList<>();

            for (Actor actor : movie.getActors()) {
                final Actor actorEntity = actorService
                    .findActor(actor)
                    .orElseThrow(
                        () -> new IllegalStateException("Actor does not exist: " + actor.getFullName())
                    );
                actors.add(actorEntity);
            }

            movie.setActors(actors);

            em.persist(movie);
        }
    }
}


