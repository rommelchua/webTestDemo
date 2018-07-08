# WEBTEST DEMO
    * Github URL : https://github.com/rommelchua/webTestDemo

## Overview
This is a simple Spring MVC/REST POC. This project uses H2 in memory database along with JDBC
so that no database setup is needed on different machines. JSP is used for templating. Jquery
is used for scripting/DOM manipulation. To run, this can be imported as a Maven project in
Eclipse and run via Run on Server (Tomcat) option.

TODOS:
ADD JPA/HIBERNATE DEMO WITH CITIES RESOURCE

## HOW TO RUN:
- To get view with users - http://localhost:8080/webtest/users OR http://localhost:8080/webtest/
- API call to GET user - http://localhost:8080/webtest/rs/users/1
- API call to POST user - http://localhost:8080/webtest/rs/user {"name":"Travis Sivart","email":"ts@yahoo.com","depId":2}
- API call to PUT (update existing) user - http://localhost:8080/webtest/rs/users/11111 {"id":11111,"name":"Travis Sivart","email":"ts@yahoo.com","depId":2}

Note:
- for PUT and POST, use application/json content type
- ensure user ID in path parameter for PUT matches ID in json body

## More sample urls:
