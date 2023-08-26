const formulario = document.getElementById("divRegistro");
const inputs = document.querySelectorAll("#divRegistro input");


const expresiones = {
	//tipoDocumento: /^(CNE|DNI)$/,
	NumeroDocumento: /^[0-9]{1,9}$/,
	Nombre: /^[A-Za-z\s]+$/,
	apellidoPaterno: /^[A-Za-z\s]+$/,
	apellidoMaterno: /^[A-Za-z\s]+$/,
	//fechaNacimiento: /^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/([0-9]{4})$/,
	celular: /^\d{9}$/,
	gmail: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
	turno: /^[TM]$/,
	estado: /^[AI]$/
}


const validarFormulario = (e) => {
	switch (e.target.name) {
		case "NumeroDocumento":
			if (expresiones.NumeroDocumento.test(e.target.value)) {
				document.getElementById("grupo__numeroDocumento").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__numeroDocumento").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__numeroDocumento i").classList.add('fa-circle-check');
				document.querySelector("#grupo__numeroDocumento i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__numeroDocumento .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__numeroDocumento").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__numeroDocumento").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__numeroDocumento i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__numeroDocumento i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__numeroDocumento .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
		case "Nombre":
			if (expresiones.Nombre.test(e.target.value)) {
				document.getElementById("grupo__nombre").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__nombre").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__nombre i").classList.add('fa-circle-check');
				document.querySelector("#grupo__nombre i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__nombre .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__nombre").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__nombre").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__nombre i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__nombre i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__nombre .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
		case "apellidoPaterno":
			if (expresiones.apellidoPaterno.test(e.target.value)) {
				document.getElementById("grupo__apellidoPaterno").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__apellidoPaterno").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__apellidoPaterno i").classList.add('fa-circle-check');
				document.querySelector("#grupo__apellidoPaterno i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__apellidoPaterno .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__apellidoPaterno").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__apellidoPaterno").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__apellidoPaterno i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__apellidoPaterno i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__apellidoPaterno .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
		case "apellidoMaterno":
			if (expresiones.apellidoMaterno.test(e.target.value)) {
				document.getElementById("grupo__apellidoMaterno").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__apellidoMaterno").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__apellidoMaterno i").classList.add('fa-circle-check');
				document.querySelector("#grupo__apellidoMaterno i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__apellidoMaterno .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__apellidoMaterno").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__apellidoMaterno").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__apellidoMaterno i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__apellidoMaterno i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__apellidoMaterno .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
		case "celular":
			if (expresiones.celular.test(e.target.value)) {
				document.getElementById("grupo__celular").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__celular").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__celular i").classList.add('fa-circle-check');
				document.querySelector("#grupo__celular i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__celular .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__celular").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__celular").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__celular i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__celular i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__celular .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
		case "gmail":
			if (expresiones.gmail.test(e.target.value)) {
				document.getElementById("grupo__gmail").classList.remove('formulario__grupo-incorrecto');
				document.getElementById("grupo__gmail").classList.add('formulario__grupo-correcto');
				document.querySelector("#grupo__gmail i").classList.add('fa-circle-check');
				document.querySelector("#grupo__gmail i").classList.remove('fa-circle-xmark');
				document.querySelector("#grupo__gmail .formulario__input-error").classList.remove('formulario__input-error-activo');
			} else {
				document.getElementById("grupo__gmail").classList.add('formulario__grupo-incorrecto');
				document.getElementById("grupo__gmail").classList.remove('formulario__grupo-correcto');
				document.querySelector("#grupo__gmail i").classList.add('fa-circle-xmark');
				document.querySelector("#grupo__gmail i").classList.remove('fa-circle-check');
				document.querySelector("#grupo__gmail .formulario__input-error").classList.add('formulario__input-error-activo');
			}
			break;
	}
}


inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
})



// Acceder a los controles
let btnBuscar = document.getElementById("btnBuscar");
let btnNuevo = document.getElementById("btnNuevo");
let btnProcesar = document.getElementById("btnProcesar");
let btnBuscarDni = document.getElementById("btnBuscarDni");

// Constantes del CRUD
const ACCION_NUEVO = "NUEVO";
const ACCION_EDITAR = "EDITAR";
const ACCION_ELIMINAR = "ELIMINAR";

// Arreglo de registros
let arreglo = [];

// Programar los botones
btnBuscar.addEventListener("click", fnBtnBuscar);
btnNuevo.addEventListener("click", fnBtnNuevo);
btnProcesar.addEventListener("click", fnBtnProcesar);
btnBuscarDni.addEventListener("click", fnBuscarDni);

// Funcion fnEditar
function fnEditar(id) {
	document.getElementById("tituloRegistro").innerHTML = ACCION_EDITAR + " REGISTRO";
	document.getElementById("accion").value = ACCION_EDITAR;
	fnCargarForm(id);
	// Mostrar formulario
	document.getElementById("divResultado").style.display = "none";
	document.getElementById("divRegistro").style.display = "block";
}

// Funcion fnEliminar
function fnEliminar(id) {
	document.getElementById("accion").value = ACCION_ELIMINAR;
	fnCargarForm(id);
	fnProcesoEliminar();
}

function fnProcesoEliminar() {
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
				title: 'Registro eliminado correctamente'
			})
		}
		fnBtnBuscar();
	};
	xhr.send(datos);
}


// Funcion fnBtnProcesar
function fnBtnProcesar() {

	// Obtener los valores de los campos del formulario
	let id = document.getElementById("frmId").value;
	let tipoDocumento = document.getElementById("frmTipoDocumento").value;
	let numeroDocumento = document.getElementById("frmNumeroDocumento").value;
	let nombre = document.getElementById("frmNombre").value;
	let apellidoPaterno = document.getElementById("frmApellidoPaterno").value;
	let apellidoMaterno = document.getElementById("frmApellidoMaterno").value;
	let fechaNacimiento = document.getElementById("frmFechaNacimiento").value;
	let celular = document.getElementById("frmCelular").value;
	let gmail = document.getElementById("frmGmail").value;
	let turno = document.getElementById("frmTurno").value;
	let estado = document.getElementById("frmEstado").value;

	if (
		id === "" ||
		tipoDocumento === "" ||
		numeroDocumento === "" ||
		nombre === "" ||
		apellidoPaterno === "" ||
		apellidoMaterno === "" ||
		fechaNacimiento === "" ||
		celular === "" ||
		gmail === "" ||
		turno === "" ||
		estado === ""
	) {
		// Mostrar mensaje de error
		Swal.fire({
			icon: 'error',
			title: 'Error',
			text: 'Verifique que los campos esten rellenos',
		})
		return;
	}


	const regexTipoDocumento = /^(CNE|DNI)$/;
	let regexNumeroDocumento = /^[0-9]{1,9}$/;
	const regexNombre = /^[A-Za-z\s]+$/;
	const regexApellidoPaterno = /^[A-Za-z\s]+$/;
	const regexApellidoMaterno = /^[A-Za-z\s]+$/;
	//const regexFechaNacimiento = /^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/([0-9]{4})$/;
	const regexCelular = /^\d{9}$/;
	const regexGmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	const regexTurno = /^[TM]$/;
	const regexEstado = /^[AI]$/;

	if (
		!regexTipoDocumento.test(tipoDocumento) ||
		!regexNumeroDocumento.test(numeroDocumento) ||
		!regexNombre.test(nombre) ||
		!regexApellidoPaterno.test(apellidoPaterno) ||
		!regexApellidoMaterno.test(apellidoMaterno) ||
		//!regexFechaNacimiento.test(fechaNacimiento) ||
		!regexCelular.test(celular) ||
		!regexGmail.test(gmail) ||
		!regexTurno.test(turno) ||
		!regexEstado.test(estado)
	) {
		// Mostrar mensaje de error
		Swal.fire({
			icon: 'error',
			title: 'Error',
			text: 'Verifique que los campos esten correctamente llenados',
		});
	} else {
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
			if (xhr.readyState === 4) {
				if (xhr.readyState === 200) {
					console.log(xhr.responseText);
					Swal.fire({
						icon: 'success',
						title: 'Exito',
					});
				} else {
					Swal.fire({
						icon: 'success',
						title: 'Exito',
					});
				}
			}
			fnBtnBuscar()
		};
		xhr.send(datos);
		limpiarFormulario();
	}
}

function limpiarFormulario() {

	//Limpiar los inputs
	document.getElementById("frmTipoDocumento").value = "";
	document.getElementById("frmNumeroDocumento").value = "";
	document.getElementById("frmNombre").value = "";
	document.getElementById("frmApellidoPaterno").value = "";
	document.getElementById("frmApellidoMaterno").value = "";
	document.getElementById("frmFechaNacimiento").value = "";
	document.getElementById("frmCelular").value = "";
	document.getElementById("frmGmail").value = "";
	document.getElementById("frmTurno").value = "";
	document.getElementById("frmEstado").value = "";


	// Remover los iconos de check
	document.querySelector("#grupo__numeroDocumento i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__nombre i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__apellidoPaterno i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__apellidoMaterno i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__fechaNacimiento i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__celular i").classList.remove('fa-circle-check');
	document.querySelector("#grupo__gmail i").classList.remove('fa-circle-check');
}

// Funcion fnBtnNuevo
function fnBtnNuevo() {
	document.getElementById("tituloRegistro").innerHTML = ACCION_NUEVO
		+ " REGISTRO";
	document.getElementById("accion").value = ACCION_NUEVO;
	// Mostrar formulario
	document.getElementById("divResultado").style.display = "none";
	document.getElementById("divRegistro").style.display = "block";
}

function fnBuscarDni() {
	let numeroDocumento = document.getElementById("numberDocumentInput").value;
	let url2 = "EstudianteBuscarDni?dni=" + numeroDocumento;
	// La llama AJAX
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", url2, true);
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
				detalleTabla += "<a class='btn__editar' href='javascript:fnEditar(" + item.id + ");'><i class='fas fa-edit fa-lg'></i></a> ";
				detalleTabla += "<a class='btn__eliminar' href='javascript:fnEliminar(" + item.id + ");'><i class='fas fa-trash fa-lg'></i></a> ";
				detalleTabla += "</td>";
				detalleTabla += "</tr>";

				// Codigo para mostrar si es "T" muestra Tarde y si es "M" Mañana 
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

// Función fnBtnBuscar
function fnBtnBuscar() {
	// Datos
	//let numeroDocumento = document.getElementById("numberDocumentInput").value;
	const titulo = document.querySelector("#tituloCrud");
	titulo.innerHTML = "<h1>ESTUDIANTES</h1>";
	let apellido = document.getElementById("apellido").value;
	let nombre = document.getElementById("nombre").value;
	// Preparar la URL
	let url = "EstudianteBuscar2?apellido=" + apellido + "&nombre=" + nombre;
	//let url = "EstudianteBuscar2?nombre=" + nombre;
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
				detalleTabla += "<a class='btn__editar' href='javascript:fnEditar(" + item.id + ");'><i class='fas fa-edit fa-lg'></i></a> ";
				detalleTabla += "<a class='btn__eliminar' href='javascript:fnEliminar(" + item.id + ");'><i class='fas fa-trash fa-lg'></i></a> ";
				detalleTabla += "</td>";
				detalleTabla += "</tr>";

				// Codigo para mostrar si es "T" muestra Tarde y si es "M" Mañana 
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



//Exportar a excel
const $btnExportar = document.querySelector("#btnExportar"),
	$tabla = document.querySelector("#tabla");

$btnExportar.addEventListener("click", function() {
	let tableExport = new TableExport($tabla, {
		exportButtons: false, // No queremos botones
		filename: "Reportes", //Nombre del archivo de Excel
		sheetname: "Reportes de Alumnos", //Título de la hoja
	});
	let datos = tableExport.getExportData();
	let preferenciasDocumento = datos.tabla.xlsx;
	tableExport.export2file(preferenciasDocumento.data, preferenciasDocumento.mimeType, preferenciasDocumento.filename, preferenciasDocumento.fileExtension, preferenciasDocumento.merges, preferenciasDocumento.RTL, preferenciasDocumento.sheetname);
});


const btnEstudiante = document.querySelector("#enlace-crud-estudiante");
const btnCSV = document.querySelector("#btnExportarCsv");
const containerCrudEstudiante = document.querySelector(".container-crud-estudiante");
const btnProfesor = document.querySelector("#enlace-crud-profesor");
const containerCrudProfesor = document.querySelector(".container-crud-profesor");

btnEstudiante.addEventListener('click', () => {
	containerCrudEstudiante.classList.add("crud-estudiante-activo");
	containerCrudProfesor.classList.remove("crud-profesor-activo");
})

btnProfesor.addEventListener('click', () => {
	containerCrudProfesor.classList.add("crud-profesor-activo");
	containerCrudEstudiante.classList.remove("crud-estudiante-activo");
})

const tabla = document.querySelector("#tabla");
const btnExportarPdf = document.querySelector("#btnExportarPdf");

btnExportarPdf.addEventListener('click', () => {
	var doc = new jsPDF();
	doc.autoTable({
		html: "#tabla"
	})
	doc.save("Reportes.pdf");
});

function exportTableToCSV(tableId, filename) {
	const table = document.getElementById(tableId);
	const rows = Array.from(table.rows);

	const csvContent = rows.map(row => {
		const rowData = Array.from(row.cells)
			.map(cell => cell.innerText)
			.join(",");
		return rowData;
	}).join("\n");

	const csvData = "data:text/csv;charset=utf-8," + encodeURIComponent(csvContent);

	const link = document.createElement("a");
	link.setAttribute("href", csvData);
	link.setAttribute("download", filename);
	link.style.display = "none";
	document.body.appendChild(link);
	link.click();
	document.body.removeChild(link);
}

btnCSV.addEventListener('click', function() {
	exportTableToCSV("tabla", "output.csv");
})



