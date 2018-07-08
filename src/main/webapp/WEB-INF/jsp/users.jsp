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
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script>
    <script type="text/javascript">
      var depIds = {};
      <c:forEach var="department" items="${departments}">
      depIds[<c:out value="${department.key}"/>] = "<c:out value="${department.value}"/>";
      </c:forEach>
    </script>
    <!-- END scripts -->

  </head>
  <body>
    <div class="w3-center">
      <h1>LIST OF REGISTERED USERS</h1>
      <h2>To EDIT an existing user, CLICK on the appropriate ROW.</h2>
      <h2>This is a JSP page which mainly uses JQuery for event handling and AJAX REST calls for updating the page.</h2>
    </div>
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
          <div class="w3-left-align"><p id="current-user"></p></div>
          <input id="form-id" type="hidden"/>

          <p>
          <input id="form-name" class="w3-input clearLeftPadding" type="text"/>
          <label>Name</label>

          <p>
          <input id="form-email" class="w3-input clearLeftPadding" type="text"/>
          <label>Email</label>

          <p>
          <select id="form-depId" class="w3-select w3-border w3-margin-top" name="option">
          <option value="" disabled selected>Department</option>
          <c:forEach var="department" items="${departments}">
          <option value="${department.key}">${department.value}</option>
          </c:forEach>
          </select>

          <p>
          <button id="save-user" class="w3-button w3-round-medium w3-green">SAVE</button>
          <button id="cancel-save-user" class="w3-button w3-round-medium w3-green" style="margin-left:10px">CANCEL</button>
        </form>
      </div>

      <div class="column adbar">
        <h2>AD BAR</h2>
      </div>
      
    </div>
  </body>
</html>