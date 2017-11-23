package at.technikum.moviewebapp.actor;

import at.technikum.moviewebapp.gender.Gender;
import java.time.LocalDate;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ActorServiceImpl implements ActorService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Actor> findActor(Actor actor) {
        return findActor(actor.getFirstName(), actor.getLastName(), actor.getGender(), actor.getBirthdate());
    }

    @Override
    public Optional<Actor> findActor(String firstName, String lastName, Gender gender, LocalDate birthdate) {

        return em.createQuery("select a from Actor a " +
            "where a.firstName = :firstName " +
            "and a.lastName = :lastName " +
            "and a.gender = :gender " +
            "and a.birthdate = :birthdate", Actor.class)
            .setParameter("firstName", firstName)
            .setParameter("lastName", lastName)
            .setParameter("gender", gender)
            .setParameter("birthdate", birthdate)
            .getResultList()
            .stream()
            .findFirst();
    }
}
