let btnBuscarInactivos = document.getElementById("btnBuscarInactivos");
//let btnProcesar = document.getElementById("btnProcesar");

//btnProcesar.addEventListener("click", fnBtnProcesar);
btnBuscarInactivos.addEventListener("click", fnBtnBuscarInactivos);

const ACCION_ACTUALIZAR_ESTADO = "UPDATE_ESTADO";

// Funcion fnEditar
function fnActualizarEstado(id) {
	document.getElementById("accion").value = ACCION_ACTUALIZAR_ESTADO;
	fnCargarForm(id);
	fnProcesoActualizarEstado();

}

function fnProcesoActualizarEstado() {
	// Preparar los datos
	let datos = "accion=" + document.getElementById("accion").value;
	datos += "&id=" + document.getElementById("frmId").value;
	datos += "&tipoDocumento=" + document.getElementById("frmTipoDocumento").value;
	datos += "&numeroDocumento=" + document.getElementById("frmNumeroDocumento").value;
	datos += "&nombre=" + document.getElementById("frmNombre").value;
	datos += "&apellidoPaterno=" + document.getElementById("frmApellidoPaterno").value;
	datos += "&apellidoMaterno=" + document.getElementById("frmApellidoMaterno").value;
	datos += "&fechaNacimiento=" + document.getElementById("frmFechaNacimiento").value;
	datos += "&celular=" + document.getElementById("frmCelular").value;
	datos += "&gmail=" + document.getElementById("frmGmail").value;
	datos += "&turno=" + document.getElementById("frmTurno").value;
	datos += "&estado=" + document.getElementById("frmEstado").value;

	// El envio con AJAX
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "ProfesorProcesar", true);
	xhr.setRequestHeader('Content-type',
		'application/x-www-form-urlencoded');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 2000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})

			Toast.fire({
				icon: 'success',
				title: 'Registro activado correctamente'
			})
		}
		fnBtnBuscarInactivos();
	};
	xhr.send(datos);
	
}

// Función fnBtnBuscarInactivos
function fnBtnBuscarInactivos() {
	// Datos
	let apellido = document.getElementById("apellido").value;
	let nombre = document.getElementById("nombre").value;
	// Preparar la URL
	let url = "ProfesorBuscarInactivos?apellido=" + apellido + "&nombre=" + nombre;
	// La llama AJAX
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", url, true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			arreglo = JSON.parse(respuesta);
			let detalleTabla = "";
			arreglo.forEach(function(item) {
				detalleTabla += "<tr>";
				detalleTabla += "<td>" + item.document_type + "</td>";
				detalleTabla += "<td>" + item.document_number + "</td>";
				detalleTabla += "<td>" + item.names + "</td>";
				detalleTabla += "<td>" + item.paternalSurname + " " + item.maternalSurname + "</td>";
				detalleTabla += "<td>" + item.dateOfBirth + "</td>";
				detalleTabla += "<td>" + item.cellphone + "</td>";
				detalleTabla += "<td>" + item.gmail + "</td>";
				detalleTabla += "<td>" + item.turn + "</td>";
				//detalleTabla += "<td>" + item.state + "</td>";
				detalleTabla += "<td>";
				detalleTabla += "<a class='btn__editar' href='javascript:fnActualizarEstado(" + item.id + ");'>Activar</a> ";
				detalleTabla += "</td>";
				detalleTabla += "</tr>";
			});
			document.getElementById("detalleTabla").innerHTML = detalleTabla;
			// Mostrar formulario
			document.getElementById("divResultado").style.display = "block";
			document.getElementById("divRegistro").style.display = "none";
		}
	};
	xhttp.send();
}



function fnCargarForm(id) {
	arreglo
		.forEach(function(item) {
			if (item.id == id) {
				document.getElementById("frmId").value = item.id;
				document.getElementById("frmTipoDocumento").value = item.document_type;
				document.getElementById("frmNumeroDocumento").value = item.document_number;
				document.getElementById("frmNombre").value = item.names;
				document.getElementById("frmApellidoPaterno").value = item.paternalSurname;
				document.getElementById("frmApellidoMaterno").value = item.maternalSurname;
				document.getElementById("frmFechaNacimiento").value = item.dateOfBirth;
				document.getElementById("frmCelular").value = item.cellphone;
				document.getElementById("frmGmail").value = item.gmail;
				document.getElementById("frmTurno").value = item.turn;
				document.getElementById("frmEstado").value = item.state;
				//break;
			}
		});
}