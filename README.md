Example SOAP web application with JAX-WS and JPA
============================================

This application demonstrates an SOAP Web with JAX-WS and JPA.

It is configured to run on a WildeFly instance with a Postgres datasource.


# Installation

The application requires following versions:
* Java 8
* Postgres 9.4+
* Wildfly 10.1+

# Usage

Compile and deploy application:
```
./gradlew clean war deployLocal
```

Continous deployment for development:
```
./gradlew clean war redeployLocal --continuous
```

# Notes

A "Package By Feature" folder structure is used. Read more at <http://www.javapractices.com/topic/TopicAction.do?Id=205>
