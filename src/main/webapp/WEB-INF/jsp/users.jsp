<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>LIST OF CITIES (JSP)</title>
    <!-- styles -->
    <style>
    body {
      background-color: white;
    }

    h1 {
      color: grey;
    }
    </style>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/w3.css" />" rel="stylesheet">
    <!-- END styles -->

    <!-- scripts -->
    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script>
    <script type="text/javascript">
    </script>
    <!-- END scripts -->

  </head>
  <body>
    <h1>
      LIST OF REGISTERED USERS
    </h1>
    <div class="row">
      <div class="column nav">
        <h2>NAV BAR</h2>
      </div>

      <div class="column content">
        <table id="users">
          <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>DEPARTMENT ID</th>
          </tr>
        <c:forEach var="user" items="${users}">
          <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${departments[user.depId]}</td>
          </tr>
        </c:forEach>
        </table>
        <form id="edit" class="w3 container">
          <p>
          <input class="w3-input" type="text"/>
          <label>Name</label>

          <p>
          <input class="w3-input" type="text"/>
          <label>Email</label>

          <p>
          <select class="w3-select w3-border w3-margin-top" name="option">
          <option value="" disabled selected>Department</option>
          <c:forEach var="department" items="${departments}">
          <option value="${department.key}">${department.value}</option>
          </c:forEach>
          </select>

          <p>
          <button class="w3-button w3-round-medium w3-green">SAVE</button>
          <button class="w3-button w3-round-medium w3-green" style="margin-left:10px">DELETE</button>
        </form>
      </div>

      <div class="column adbar">
        <h2>AD BAR</h2>
      </div>
      
    </div>
  </body>
</html>