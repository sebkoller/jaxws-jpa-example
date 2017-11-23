package at.technikum.moviewebapp.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MovieWebAppResponse {

    private boolean success;
    private String status;
    private String statusMessage;

}
