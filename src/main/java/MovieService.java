import java.io.StringReader;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.Movie;

@Stateless
public class MovieService {

    @PersistenceContext
    private EntityManager em;

    public List<Movie> getAllMovies() {
        return em
            .createNamedQuery("Movie.selectAll", Movie.class)
            .getResultList();
    }

    public List<Movie> findByTitleContainingIgnoreCase(String keyword) {
        return em
            .createNamedQuery("Movie.findByTitleContainingIgnoreCase", Movie.class)
            .setParameter("title", keyword)
            .getResultList();
    }

    public boolean insertMovie(String xml) {
        JAXBContext jaxbContext = null;
        Movie movie = null;
        try {
            jaxbContext = JAXBContext.newInstance(Movie.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xml);
            System.out.println("affe123");
            System.out.println(xml);
            System.out.println(reader);
            movie = (Movie)unmarshaller.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }

        try {
//            em.persist(movie.getStudio());
//            movie.getActors().stream().forEach(actor -> em.persist(actor));
            em.persist(movie);
        } catch (RuntimeException e) {
            e.printStackTrace();
            //TODO rollback?
            return false;
        }

        return true;
    }
}
