apiBaseUrl = "http://localhost:8083";


isEditing = false;
currentEditingID = null;
var modal = new bootstrap.Modal(document.getElementById("newUser"));
var form = $("#formCreation");

form.submit(function (e) {
  e.preventDefault();
  const data = {
    nombre: $("#nombre").val(),
    apellido: $("#apellido").val(),
    fecha_nacimiento: $("#fecha_nacimiento").val(),
    correo: $("#correo").val(),
    contrasena: $("#contrasena").val(),
    telefono: $("#telefono").val(),
    direccion: $("#direccion").val(),
    id_rol: {
      id_rol: $("#id_rol").val()
    }
  }

  if(isEditing){
    data.id_usuario = currentEditingID;
  }

  saveUser(data, () => {
    modal.hide();
    getUsersAndUpdate();
  });
});

function getUsers(callback) {
	$.ajax({
    url: apiBaseUrl + "/usuario/all",
    type: "GET",
    success: callback,
  });
}

function saveUser(user, callback) {
  $.ajax({
    url: apiBaseUrl + "/usuario/save",
    type: "POST",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    data: JSON.stringify(user),
    success: callback,
  });
}

function getUserById(id,callback) {
  $.ajax({
    url: apiBaseUrl + "/usuario/find/" + id,
    type: "GET",
    success: callback,
  });
}

function deleteUserById(id,callback){
  $.ajax({
    url: apiBaseUrl + "/usuario/delete/" + id,
    type: "DELETE",
    success: callback,
  });
}

function getRols(callback) {
  $.ajax({
    url: apiBaseUrl + "/usuario/rol",
    type: "GET",
    success: callback,
  });
}

function populateTableUsers(data) {
  table = $("#usersTable");
  htmlString = "";
  for(e in data){
    template = `
    <tr>
      <td>${data[e].id_usuario}</td>
      <td>${data[e].nombre}</td>
      <td>${data[e].apellido}</td>
      <td>${data[e].fecha_nacimiento}</td>
      <td>${data[e].correo}</td>
      <td>${data[e].contrasena}</td>
      <td>${data[e].telefono}</td>
      <td>${data[e].direccion}</td>
      <td>${data[e].id_rol.nombre_rol}</td>
      <td>
        
        <button type="button" class="btn btn-warning" 
          onclick="editUser(${data[e].id_usuario})"
          >
          Edit
        </button>
        <button
            type="button" class="btn btn-danger"
            onclick="deleteUser(${data[e].id_usuario})"
            >
          Delete
        </button>
      </td>
    </tr>
    `;
    htmlString += template;
  }
  table.html(htmlString);
}

function populateRols(data){
  console.log(data)
  idRolDropdown = $("#id_rol");
  htmlString = "";
  for (e in data) {
    template = `
      <option value="${data[e].id_rol}">${data[e].nombre_rol}</option>
      `;
    htmlString += template;
  }
  idRolDropdown.html(htmlString);
}

function setModalData(data){
  $("#nombre").val(data.nombre);
  $("#apellido").val(data.apellido);
  $("#fecha_nacimiento").val(data.fecha_nacimiento);
  $("#correo").val(data.correo);
  $("#contrasena").val(data.contrasena);
  $("#telefono").val(data.telefono);
  $("#direccion").val(data.direccion);
  $("#id_rol").val(data.id_rol.id_rol).change();
}

function emptyModalData(){
  $("#nombre").val("");
  $("#apellido").val("");
  $("#fecha_nacimiento").val("");
  $("#correo").val("");
  $("#contrasena").val("");
  $("#telefono").val("");
  $("#direccion").val("");
  $("#id_rol").val("").change();
}

function newUser(){
  isEditing = false;
  emptyModalData();
  $("#tituloModal").html("Nuevo Usuario");
  getRols(
    (data) => populateRols(data)
  )
  modal.show();
}

function editUser(id){
  isEditing = true;
  currentEditingID = id;
  $("#tituloModal").html("Editar Usuario");
  toggleLoading(true);
  getRols((data) => {
    populateRols(data);
    toggleLoading(false)
  })
  getUserById(
    id,
    (data) => {
      setModalData(data)
      toggleLoading(false)
    }
  )
  modal.show();
}

function deleteUser(id){
  toggleLoading(true);
  deleteUserById(
    id,
    () => {
      getUsersAndUpdate();
      toggleLoading(false);
    }
  )
}

function togglePassword(){
  var x = document.getElementById("contrasena");
  if (x.type === "password") {
    x.type = "text";
  }
  else {
    x.type = "password";
  }
}

function getUsersAndUpdate(){
  toggleLoading(true)
  getUsers((data) => {
    populateTableUsers(data);
    toggleLoading(false)
  });
}

function toggleLoading(isLoading){
  if(isLoading){
    $("#loader").css("display", "block");
  }else{
    $("#loader").css("display", "none");
  }
}

$(document).ready(function () {
  getUsersAndUpdate()
});

