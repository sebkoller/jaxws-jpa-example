package at.technikum.moviewebapp.actor;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ActorServiceImpl implements ActorService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Actor> findActor(Actor actor) {

        return em.createQuery("select a from Actor a " +
            "where a.firstName = :firstName " +
            "and a.lastName = :lastName " +
            "and a.gender = :gender " +
            "and a.birthdate = :birthdate", Actor.class)
            .setParameter("firstName", actor.getFirstName())
            .setParameter("lastName", actor.getLastName())
            .setParameter("gender", actor.getGender())
            .setParameter("birthdate", actor.getBirthdate())
            .getResultList()
            .stream()
            .findFirst();
    }
}
