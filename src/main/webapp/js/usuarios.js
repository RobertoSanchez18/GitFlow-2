const formulario = document.getElementById("divRegistro");
let btnBuscar = document.getElementById("btnBuscar");
let btnNuevo = document.getElementById("btnNuevo");
let btnProcesar = document.getElementById("btnProcesar");


const ACCION_NUEVO = "NUEVO";
const ACCION_EDITAR = "EDITAR";
const ACCION_ELIMINAR = "ELIMINAR";


btnNuevo.addEventListener('click', fnBtnNuevo)
btnBuscar.addEventListener('click', fnBtnBuscar);
btnProcesar.addEventListener('click', fnBtnProcesar)


function fnBtnNuevo() {
	document.getElementById("tituloRegistro").innerHTML = ACCION_NUEVO + " REGISTRO";
	document.getElementById("accion").value = ACCION_NUEVO;
	document.getElementById("divResultado").style.display = "none";
	document.getElementById("divRegistro").style.display = "block";
}

function fnEditar(id) {
	document.getElementById("tituloRegistro").innerHTML = ACCION_EDITAR + " REGISTRO";
	document.getElementById("accion").value = ACCION_EDITAR;
	fnCargarForm(id);
	document.getElementById("divResultado").style.display = "none";
	document.getElementById("divRegistro").style.display = "block";
}

function fnEliminar(id){
	document.getElementById("accion").value = ACCION_ELIMINAR;
	fnCargarForm(id);
	fnProcesoEliminar();
}

fnBtnBuscar()


// Función fnBtnBuscar
function fnBtnBuscar() {
	let nombre = document.getElementById("form1").value;
	
	let url = "PersonaBuscar?nombre=" + nombre;
	
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", url, true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			arreglo = JSON.parse(respuesta);
			let detalleTabla = "";
			arreglo.forEach(function(item) {
				detalleTabla += "<tr>";
				detalleTabla += "<td>" + item.nombreuser + "</td>";
				detalleTabla += "<td>" + item.correo + "</td>";
				detalleTabla += "<td>" + item.celular + "</td>";
				detalleTabla += "<td>" + item.pass + "</td>";
				detalleTabla += "<td>";
				detalleTabla += "<a class='btn btn-sm btn-warning' href='javascript:fnEditar(" + item.id + ");'><i class='fas fa-edit fa-lg' style='color: #353535;'></i></a> ";
				detalleTabla += "<a class='btn btn-sm btn-danger' href='javascript:fnEliminar(" + item.id + ");'><i class='fas fa-trash fa-lg'></i></a> ";
				detalleTabla += "</td>";
				detalleTabla += "</tr>";

				// Codigo para mostrar si es "T" muestra Tarde y si es "M" Mañana 
				document.getElementById("detalleTabla").innerHTML = detalleTabla;

			});
			//document.getElementById("detalleTabla").innerHTML = detalleTabla;
			// Mostrar formulario
			document.getElementById("divResultado").style.display = "block";
			document.getElementById("divRegistro").style.display = "none";
		}
	};
	xhttp.send();
}



function fnProcesoEliminar() {
	
	let datos = "accion=" + document.getElementById("accion").value;
	datos += "&id=" + document.getElementById("frmId").value;
	datos += "&nombreUsuario=" + document.getElementById("frmNombreUsuario").value;
	datos += "&correo=" + document.getElementById("frmCorreo").value;
	datos += "&celular=" + document.getElementById("frmCelular").value;
	datos += "&pass=" + document.getElementById("frmPass").value;

	// El envio con AJAX
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "PersonaProcesar", true);
	xhr.setRequestHeader('Content-type',
		'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			alert("Usuario eliminado")
		}
		fnBtnBuscar();
	};
	xhr.send(datos);
}


// Funcion fnBtnProcesar
function fnBtnProcesar() {
	
	let id = document.getElementById("frmId").value;
	let nombreUsuario = document.getElementById("frmNombreUsuario").value;
	let correo = document.getElementById("frmCorreo").value;
	let celular = document.getElementById("frmCelular").value;
	let pass = document.getElementById("frmPass").value;

	if (id === "" ||nombreUsuario === "" ||correo === "" ||celular === "" ||pass === "") {
		alert("Ingresa datos en los inputs")
		return;
	}


	let datos = "accion=" + document.getElementById("accion").value;
	datos += "&id=" + document.getElementById("frmId").value;
	datos += "&nombreUsuario=" + document.getElementById("frmNombreUsuario").value;
	datos += "&correo=" + document.getElementById("frmCorreo").value;
	datos += "&celular=" + document.getElementById("frmCelular").value;
	datos += "&pass=" + document.getElementById("frmPass").value;

	// El envio con AJAX
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "PersonaProcesar", true);
	xhr.setRequestHeader('Content-type',
		'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.readyState === 200) {
				console.log(xhr.responseText);
				alert("Exito")
			} else {
				alert("Exito")
			}
		}
		fnBtnBuscar()
	};
	xhr.send(datos);
}


function fnCargarForm(id) {
	arreglo.forEach(function(item) {
			if (item.id == id) {
				document.getElementById("frmId").value = item.id;
				document.getElementById("frmNombreUsuario").value = item.nombreuser;
				document.getElementById("frmCorreo").value = item.correo;
				document.getElementById("frmCelular").value = item.celular;
				document.getElementById("frmPass").value = item.pass;
				//break;
			}
		});
}





