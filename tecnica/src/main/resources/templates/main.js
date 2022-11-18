//Conexion con el backend 
apiBaseUrl = "http://localhost:8084";


isEditing = false;
currentEditingID = null;
//Variables asignadas a client.html para poder implementar Crud
var modal = new bootstrap.Modal(document.getElementById("newClient"));
var form = $("#formCreation");

//Calcular edad 365(Dias)24(horas)60(min)60(seg)1000(milSeg)
function calculateAge(birthday) {
  var ageDifMs = Date.now() - birthday.getTime();
  return ageDifMs / (365 * 24 * 60 * 60 * 1000)
}

//Mediante la siguiente funcion tomara los valores 
form.submit(function (e) {
  e.preventDefault();
  const data = {
    nombre: $("#nombre").val(),
    apellido: $("#apellido").val(),
    fecha_nacimiento: $("#fecha_nacimiento").val(),
    correo: $("#correo").val(),
    telefono: $("#telefono").val(),
    id_ocupacion: {
      id_ocu: $("#id_ocupacion").val(),
    },
    id_ciudad: {
      id_ciudad: $("#id_ciudad").val(),
    },
  };

  if(isEditing){
    data.identificacion = currentEditingID;
  }else{
    data.identificacion = $("#identificacion").val();
  }

  // validate data

  // if data.identificacion is empty or is not a number then show error in input identificacion
  if (!data.identificacion || isNaN(data.identificacion)) {
    $("#val-identificacion").show();
    return;
  }else{
    $("#val-identificacion").hide();
  }
  
  // if  the distance between current date and date.fecha_nacimiento is less than 18 years, then show error in input fecha_nacimiento
  if (calculateAge(new Date(data.fecha_nacimiento)) < 18 || calculateAge(new Date(data.fecha_nacimiento)) > 65 ) {
    $("#val-fecha_nacimiento").show();
    return;
  } else {
    $("#val-fecha_nacimiento").hide();
  }
  

  saveClient(data, () => {
    modal.hide();
    getClientsAndUpdate();
  });
});

function getClient(callback) {
	$.ajax({
    url: apiBaseUrl + "/cliente/all",
    type: "GET",
    success: callback
  });
}

function saveClient(client, callback) {
  $.ajax({
    url: apiBaseUrl + "/cliente/save",
    type: "POST",
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    data: JSON.stringify(client),
    success: callback,
  });
}

function getClientById(id,callback) {
  $.ajax({
    url: apiBaseUrl + "/cliente/find/" + id,
    type: "GET",
    success: callback,
  });
}

function deleteClientById(id,callback){
  $.ajax({
    url: apiBaseUrl + "/cliente/delete/" + id,
    type: "DELETE",
    success: callback,
  });
}

function getOcu(callback) {
  return $.ajax({
    url: apiBaseUrl + "/cliente/ocupacion",
    type: "GET",
    success: callback,
  });
}

function getCiu(callback) {
  return $.ajax({
    url: apiBaseUrl + "/cliente/ciudad",
    type: "GET",
    success: callback,
  });
}

function populateTableClient(data) {
  table = $("#clientsTable");
  htmlString = "";
  for(e in data){
    template = `
    <tr>
      <td>${data[e].identificacion}</td>
      <td>${data[e].nombre}</td>
      <td>${data[e].apellido}</td>
      <td>${data[e].fecha_nacimiento}</td>
      <td>${data[e].correo}</td>
      <td>${data[e].telefono}</td>
      <td>${data[e].id_ocupacion.nombre_ocupacion}</td>
      <td>${data[e].id_ciudad.ciudad}</td>
      <td>
        
        <button type="button" class="btn btn-warning" 
          onclick="editClient(${data[e].identificacion})"
          >
          Edit
        </button>
        <button
            type="button" class="btn btn-danger"
            onclick="deleteClient(${data[e].identificacion})"
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

function populateOcupa(data){
  idOcupacionDropdown = $("#id_ocupacion");
  htmlString = "";
  for (e in data) {
    template = `
      <option value="${data[e].id_ocu}">${data[e].nombre_ocupacion}</option>
      `;
    htmlString += template;
  }
  idOcupacionDropdown.html(htmlString);
}

function populateCity(data){
  idCityDropdown = $("#id_ciudad");
  htmlString = "";
  for (e in data) {
    template = `
      <option value="${data[e].id_ciudad}">${data[e].ciudad}</option>
      `;
    htmlString += template;
  }
  idCityDropdown.html(htmlString);
}

function setModalData(data){
  $("#nombre").val(data.nombre);
  $("#apellido").val(data.apellido);
  $("#fecha_nacimiento").val(data.fecha_nacimiento);
  $("#correo").val(data.correo);
  $("#telefono").val(data.telefono);
  $("#id_ocupacion").val(data.id_ocupacion.id_ocu).change();
  $("#id_ciudad").val(data.id_ciudad.id_ciudad).change();
}

function emptyModalData(){
  $("#nombre").val("");
  $("#apellido").val("");
  $("#fecha_nacimiento").val("");
  $("#correo").val("");
  $("#telefono").val("");
  $("#id_ocupacion").val("").change();
  $("#id_ciudad").val("").change();
  $("#val-identificacion").hide();
  $("#val-fecha_nacimiento").hide();
}

function newClient(){
  isEditing = false;
  $("#identificacion").parent().parent().show();
  $("#identificacion").prop("required", true);
  $("#btnForm").html("Crear");
  $("#tituloModal").html("Nuevo Cliente");
  emptyModalData();
  getOcu(
    (data) => populateOcupa(data)
  )
  getCiu(
	  (data) => populateCity(data)
  )
  modal.show();
}

function editClient(identificacion){
  isEditing = true;
  currentEditingID = identificacion;
  $("#identificacion").parent().parent().hide();
  $("#identificacion").prop("required", false);
  $("#btnForm").html("Editar");
  $("#tituloModal").html("Editar Cliente");
  emptyModalData();
  toggleLoading(true);
  getOcu((data) => {
    populateOcupa(data);
    toggleLoading(false)
  })
  .then(() => {
    getCiu((data) => {
      populateCity(data);
      toggleLoading(false)
    })
    .then(() => {
      getClientById(
        identificacion,
        (data) => {
          setModalData(data)
          toggleLoading(false)
        }
      )
    })
  })
  
  modal.show();
}

function deleteClient(id){
  toggleLoading(true);
  deleteClientById(
    id,
    () => {
      getClientsAndUpdate();
      toggleLoading(false);
    }
  )
}

function getClientsAndUpdate(){
  toggleLoading(true)
  getClient((data) => {
    populateTableClient(data);
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
  getClientsAndUpdate()
});

