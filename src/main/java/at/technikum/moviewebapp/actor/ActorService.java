package at.technikum.moviewebapp.actor;

import at.technikum.moviewebapp.gender.Gender;
import java.time.LocalDate;
import java.util.Optional;

public interface ActorService {

    Optional<Actor> findActor(Actor actor);
    Optional<Actor> findActor(String firstName, String lastName, Gender gender, LocalDate birthdate);

}
