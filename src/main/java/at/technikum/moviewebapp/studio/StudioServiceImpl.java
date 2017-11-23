package at.technikum.moviewebapp.studio;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StudioServiceImpl implements StudioService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Studio> findStudio(Studio studio) {

        return em.createQuery("select s from Studio s " +
            "where s.name = :name " +
            "and s.countryCode = :countryCode " +
            "and s.postCode = :postCode", Studio.class)
            .setParameter("name", studio.getName())
            .setParameter("countryCode", studio.getCountryCode())
            .setParameter("postCode", studio.getPostCode())
            .getResultList()
            .stream()
            .findFirst();
    }
}
