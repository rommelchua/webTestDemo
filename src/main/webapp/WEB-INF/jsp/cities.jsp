<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head><title>LIST OF CITIES (JSP)</title></head>
  <body>
    <table>
    <c:forEach var="city" items="${cities}">
      <tr>
        <td>NAME: ${city.name}</td>
        <td>COUNTRY CODE: ${city.countryCode}</td>
        <td>DISTRICT: ${city.district}</td>
        <td>POPULATION: ${city.population}</td>
      </tr>
    </c:forEach>
    </table>
  </body>
</html>