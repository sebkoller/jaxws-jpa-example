package at.technikum.moviewebapp.util;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString);
    }

    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }
}

