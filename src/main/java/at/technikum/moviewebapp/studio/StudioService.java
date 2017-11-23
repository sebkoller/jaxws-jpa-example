package at.technikum.moviewebapp.studio;

import java.util.Optional;

public interface StudioService {

    Optional<Studio> findStudio(Studio studio);
    Optional<Studio> findStudio(String name, String countryCode, String postCode);
}
