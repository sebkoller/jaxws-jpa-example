package at.technikum.moviewebapp.actor;

import java.util.Optional;

public interface ActorService {

    Optional<Actor> findActor(Actor actor);

}
