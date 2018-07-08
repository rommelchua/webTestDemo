var newUserLabel = 'New User';

function getUserInput() {
  return {
    id: $("#form-id").val(),
    name: $("#form-name").val(),
    email: $("#form-email").val(),
    depId: $("#form-depId").val()
  };
}

function clearInput() {
  $("#form-id").val(null);
  $("#form-name").val(null);
  $("#form-email").val(null);
  $("#form-depId").val(null);
  $('#current-user').text(newUserLabel);
}

//angular bindings
var app = angular.module('userApp', []);
app.controller('userCtrl', function($scope) {

});

//jquery event handling
$(document).ready(function(){
  $('#save-user').click(function(event) {
    event.preventDefault();
    var payload = getUserInput();
    if (payload.id) {
      var reqMethod = "PUT";
      var reqUrl = "/webtest/rs/users/" + payload.id;
    } else {
      var reqMethod = "POST";
      var reqUrl = "/webtest/rs/user";
    }

    $.ajax({
      type: reqMethod,
      url: reqUrl,
      data: JSON.stringify(payload),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      success: function(data){
        var rowHtml = '<tr><td>' + data.id + '</td><td>' + data.name + '</td><td>' + data.email + '</td><td>' + depIds[data.depId] + '</td></tr>';
        if (payload.id) {
          $('#users tr').filter(function () { return $(this).find('td:nth-child(1)').html() == payload.id }).replaceWith(rowHtml);
        } else {
          $('#users').append(rowHtml);
        }
      },
      error: function(jqXHR,textStatus,errorThrown) {
        console.log(jqXHR.responseText);
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
        alert("Error adding user");
      },
      complete: clearInput()
    });
  }); //end save-user-click

  $('#cancel-save-user').click(function(event){
    event.preventDefault();
    clearInput();
  });

  $('#users').on('click','tr:gt(0)',function(event){
    event.preventDefault();
    $('#current-user').text('Editing user with id=' + $(this).find('td:first-child').text());
    $("#form-id").val($(this).find('td:nth-child(1)').text());
    $("#form-name").val($(this).find('td:nth-child(2)').text());
    $("#form-email").val($(this).find('td:nth-child(3)').text());
    var depText = $(this).find('td:nth-child(4)').text();
    $("#form-depId").val($('#form-depId option').filter(function () { return $(this).html() == depText; }).val());
  });

  //initialize
  clearInput();
});