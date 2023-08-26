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
	xhr.open("POST", "EstudianteProcesar", true);
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
	//let apellido = document.getElementById("apellido").value;
	const titulo = document.querySelector("#tituloCrud");
	titulo.innerHTML = "<h1>ESTUDIANTES INACTIVOS</h1>";
	let nombre = document.getElementById("nombre").value;
	// Preparar la URL
	let url = "EstudianteBuscarInactivos?nombre=" + nombre;
	// La llama AJAX
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", url, true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			arreglo = JSON.parse(respuesta);
			// Ordenar arreglo por apellidos alfabéticamente
			arreglo.sort(function(a, b) {
				// Combinar apellidos paternos y maternos
				let apellidoA = a.paternalSurname + " " + a.maternalSurname;
				let apellidoB = b.paternalSurname + " " + b.maternalSurname;

				// Comparar apellidos ignorando mayúsculas y minúsculas
				apellidoA = apellidoA.toLowerCase();
				apellidoB = apellidoB.toLowerCase();
				if (apellidoA < apellidoB) {
					return -1;
				}
				if (apellidoA > apellidoB) {
					return 1;
				}
				return 0;
			});
			let detalleTabla = "";
			arreglo.forEach(function(item) {
				detalleTabla += "<tr>";
				detalleTabla += "<td>" + item.tipoDocumento + "</td>";
				detalleTabla += "<td>" + item.numberDocumento + "</td>";
				detalleTabla += "<td>" + item.names + "</td>";
				detalleTabla += "<td>" + item.paternalSurname + " " + item.maternalSurname + "</td>";
				// Cambiar formato de fecha
				let fechaNacimiento = new Date(item.fechaNacimiento);
				let dia = fechaNacimiento.getDate();
				let mes = (fechaNacimiento.getMonth() + 1).toString().padStart(2, '0');
				let anio = fechaNacimiento.getFullYear();
				let fechaFormateada = dia + "/" + mes + "/" + anio;
				detalleTabla += "<td>" + fechaFormateada + "</td>";
				detalleTabla += "<td>" + item.celular + "</td>";
				detalleTabla += "<td>" + item.gmail + "</td>";
				detalleTabla += "<td class='bloqueTurno'>" + item.turn + "</td>";
				//detalleTabla += "<td>" + item.state + "</td>";
				detalleTabla += "<td>";
				detalleTabla += "<a class='btn__editar' href='javascript:fnActualizarEstado(" + item.id + ");'>Activar</a> ";
				detalleTabla += "</td>";
				detalleTabla += "</tr>";

				document.getElementById("detalleTabla").innerHTML = detalleTabla;

				const bloques = document.querySelectorAll(".bloqueTurno");
				bloques.forEach(function(bloque) {
					if (bloque.textContent === "T") {
						bloque.textContent = "Tarde";
					} else if (bloque.textContent === "M") {
						bloque.textContent = decodeURIComponent("Ma%C3%B1ana");
					}
				});

			});
			//document.getElementById("detalleTabla").innerHTML = detalleTabla;
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
				document.getElementById("frmTipoDocumento").value = item.tipoDocumento;
				document.getElementById("frmNumeroDocumento").value = item.numberDocumento;
				document.getElementById("frmNombre").value = item.names;
				document.getElementById("frmApellidoPaterno").value = item.paternalSurname;
				document.getElementById("frmApellidoMaterno").value = item.maternalSurname;
				document.getElementById("frmFechaNacimiento").value = item.fechaNacimiento;
				document.getElementById("frmCelular").value = item.celular;
				document.getElementById("frmGmail").value = item.gmail;
				document.getElementById("frmTurno").value = item.turn;
				document.getElementById("frmEstado").value = item.state;
				//break;
			}
		});
}