<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<!-- Estilos css -->

<link rel="stylesheet" href="assets/css/estilos.css" type="text/css">
<link rel="stylesheet" href="assets/css/sidebar.css" type="text/css">


<!-- Bootstrap  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<!----===== Boxicons CSS ===== -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

<!-- Script Fontawesome -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/2379926a1f.js"
	crossorigin="anonymous"></script>


<!-- links para exportar a excel -->

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://unpkg.com/xlsx@0.16.9/dist/xlsx.full.min.js"></script>
<script src="https://unpkg.com/file-saverjs@latest/FileSaver.min.js"></script>
<script
	src="https://unpkg.com/tableexport@latest/dist/js/tableexport.min.js"></script>



<!-- Scripts para exportar PDF -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.6/jspdf.plugin.autotable.min.js"></script>


<!-- Script para exportar a CSV -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/PapaParse/5.3.0/papaparse.min.js"></script>



<title>ClassKeeper</title>
</head>
<body id="body-pd">

	<header class="header" id="header">
		<div class="header_toggle">
			<i class='bx bx-menu' id="header-toggle"></i>
		</div>

		<div class="dropdown">
			<a style="cursor: pointer;" class="nav-link dropdown-toggle" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Cerrar Sesion</a>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<li><a class="dropdown-item" href="#">User</a></li>
				<li><a class="dropdown-item" href="#">example@gmail.com</a></li>
				<li class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="index.jsp">Salir</a></li>
			</ul>
		</div>
	</header>
	<div class="l-navbar" id="nav-bar">
		<nav class="nav">
			<div>
				<a href="#" class="nav_logo"> <i
					class='bx bx-layer nav_logo-icon'></i> <span class="nav_logo-name">ClassKeeper</span>
				</a>
				<div class="nav_list">
					<a href="#" class="nav_link active"> <i
						class='bx bx-grid-alt nav_icon'></i><span class="nav_name">Dashboard</span>
					</a> <a href="#" class="nav_link"> <i class='bx bx-book nav_icon'></i>
						<span class="nav_name">Asistencia</span>
					</a> <a href="#" class="nav_link"> <i class='bx bx-cog nav_icon'></i>
						<span class="nav_name">Configuracion</span></a> <a href="#"
						class="nav_link"> <i class='bx bx-trending-up nav_icon'></i> <span
						class="nav_name">Reportes</span>
					</a> <a id="enlace-crud-estudiante" href="#" class="nav_link"> <i
						class="fa-solid fa-user-plus"></i> <span class="nav_name">Estudiantes</span></a>
					<a id="enlace-crud-profesor" href="profesor.jsp" class="nav_link">
						<i class="fa-solid fa-user-tie"></i> <span class="nav_name">Profesores</span>
					</a>
				</div>
			</div>
			<a href="#" class="nav_link"> <i class='bx bx-log-out nav_icon'></i>
				<span class="nav_name">SignOut</span>
			</a>
		</nav>
	</div>

	<div id="container-padre" style="margin-top: 50px"
		class="container container-crud-estudiante" style="display: block">

		<div style="display: flex; margin-top: 10px; margin-bottom: 10px">
			<h1 id="tituloCrud">ESTUDIANTES</h1>
			<img src="images/student.png" width="70px">
		</div>
		
		<div class="container mt-4">
			<h1>Bienvenido al sistema <strong> Usuario:</strong></h1>
		</div>


		<!-- Card de datos de entrada -->
		<div class="card">
			<div class="card-header">Criterios de busqueda</div>
			<div class="card-body">
				<form method="post" action="#">
					<div class="mb-3 row">
						<div class="col-sm-3">
							<input type="text" class="form-control" id="nombre" name="nombre"
								placeholder="Ingrese nombre">
						</div>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="apellido"
								name="apellido" placeholder="Ingrese apellido paterno">
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary mb-3" id="btnBuscar"
								name="btnBuscar">
								Buscar <i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</div>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="numberDocumentInput"
								name="numeroDocumentoInput"
								placeholder="Ingrese DNI(8) o CNE(9)">
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary mb-3"
								id="btnBuscarDni" name="btnBuscarDni">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</div>

					</div>
					<div class="row d-flex mt-4">
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary mb-3" id="btnNuevo"
								name="btnNuevo">
								<i class="fa-solid fa-user-plus"></i>
							</button>
						</div>

						<div class="col-sm-2 ms-1">
							<button type="button" class="btn btn-outline-dark mb-3"
								id="btnBuscarInactivos" name="btnBuscarInactivos">
								<strong>Inactivos</strong>
							</button>
						</div>

						<div class="col-sm-2" style="position: relative; left: 10px">
							<button type="button" class="btn btn-success mb-3"
								id="btnExportar" name="btnExportar">
								<i class="fas fa-file-excel"></i>
							</button>
							<button type="button" class="btn btn-danger mb-3"
								id="btnExportarPdf" name="btnExportarPdf">
								<i class="fa-solid fa-file-pdf"></i>
							</button>
							<button type="button" class="btn btn-info mb-3"
								id="btnExportarCsv" name="btnExportarCsv">
								<i class="fa-solid fa-file-csv"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- Card de resultados -->
		<div class="card mt-4" id="divResultado">
			<div class="card-header">Resultado</div>
			<div class="card-body">
				<table id="tabla" class="table table-hover">
					<thead>
						<tr>
							<th>Tipo de Documento</th>
							<th>Numero de Documento</th>
							<th>Nombre</th>
							<th>Apellidos</th>
							<th>Fecha de Nacimiento</th>
							<th>Celular</th>
							<th>Gmail</th>
							<th>Turno</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody id="detalleTabla">
					</tbody>
				</table>
			</div>
		</div>


		<!-- Formulario de edición de registro -->
		<div class="card" id="divRegistro" style="display: none;">
			<div class="card-header" id="tituloRegistro">{accion}
				ESTUDIANTE</div>
			<div class="card-body">
				<form id="mi-formulario">
					<input type="hidden" id="accion" name="accion">
					<div style="display: none;" class="row mb-4">
						<label for="frmId" class="col-sm-2 col-form-label">ID</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" id="frmId"
								disabled="disabled" value="0">
						</div>
					</div>

					<div class="row mb-4" id="grupo__tipoDocumento">
						<label for="frmTipoDocumento"
							class="col-sm-2 col-form-label formulario__label">Tipo de
							Documento</label>
						<div class="col-sm-8 position-relative">
							<select id="frmTipoDocumento" class="form-select"
								aria-label="Default select example">
								<option selected disabled>Selecciona una opción</option>
								<option value="DNI">DNI</option>
								<option value="CNE">CNE</option>
							</select>
						</div>
						<p class="formulario__input-error">El tipo de documento debe
							ser CNE o DNI, deben estar es mayusculas</p>
					</div>

					<div class="row mb-2" id="grupo__numeroDocumento">
						<label for="frmNumeroDocumento"
							class="col-sm-2 col-form-label formulario__label">Numero
							de Documento</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="NumeroDocumento"
								id="frmNumeroDocumento"><i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">El numero de documento
							tiene que ser de 8 o 9 digitos numericos</p>
					</div>

					<div class="row mb-4" id="grupo__nombre">
						<label for="frmNombre"
							class="col-sm-2 col-form-label formulario__label">Nombre</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="Nombre"
								id="frmNombre"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">Ingrese un nombre valido,
							asegurese que no tenga signos</p>
					</div>

					<div class="row mb-4" id="grupo__apellidoPaterno">
						<label for="frmApellidoPaterno"
							class="col-sm-2 col-form-label formulario__label">Apellido
							Paterno</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="apellidoPaterno"
								id="frmApellidoPaterno"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">Asegurese de que no haya
							signos</p>
					</div>

					<div class="row mb-4" id="grupo__apellidoMaterno">
						<label for="frmApellidoMaterno"
							class="col-sm-2 col-form-label formulario__label">Apellido
							Materno</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="apellidoMaterno"
								id="frmApellidoMaterno"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">Asegurese de que no haya
							signos</p>
					</div>

					<div class="row mb-4" id="grupo__fechaNacimiento">
						<label for="frmFechaNacimiento"
							class="col-sm-2 col-form-label formulario__label">Fecha
							de Nacimiento</label>
						<div class="col-sm-8 position-relative">
							<input type="date" class="form-control" name="fechaDeNacimiento"
								id="frmFechaNacimiento"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">Ingrese una fecha valida,
							el formato es dd/mm/yyyy</p>
					</div>

					<div class="row mb-4" id="grupo__celular">
						<label for="frmCelular"
							class="col-sm-2 col-form-label formulario__label">Celular</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="celular"
								id="frmCelular"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">El numero de celular debe
							tener 9 digitos</p>
					</div>

					<div class="row mb-4" id="grupo__gmail">
						<label for="frmGmail"
							class="col-sm-2 col-form-label formulario__label">Email</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" name="gmail"
								id="frmGmail"> <i
								class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
						</div>
						<p class="formulario__input-error">Introduzca un correo valido</p>
					</div>

					<div class="row mb-4" id="grupo__turno">
						<label for="frmTurno"
							class="col-sm-2 col-form-label formulario__label">Turno <a
							title="Selecciona T de tarde o M de mañana" href="#"><i
								class="fa-solid fa-circle-info" style="font-size: 20px"></i></a></label>
						<div class="col-sm-8 position-relative">
							<select id="frmTurno" class="form-select"
								aria-label="Default select example">
								<option selected disabled>Selecciona una opción</option>
								<option value="T">Tarde</option>
								<option value="M">Mañana</option>
							</select>
						</div>
						<p class="formulario__input-error">Solo debe ingresar la "T"
							de tarde o "M" de mañana</p>
					</div>

					<div style="display: none;" class="row mb-4" id="grupo__estado">
						<label for="frmEstado"
							class="col-sm-2 col-form-label formulario__label">Estado
							<a title="Selecciona A de activo o I de inactivo" href="#"><i
								class="fa-solid fa-circle-info" style="font-size: 20px"></i></a>
						</label>
						<div class="col-sm-8 position-relative">
							<input type="text" class="form-control" id="frmEstado"
								disabled="disabled" value="A">
						</div>
						<p class="formulario__input-error">Solo debe ingresar la "A"
							de activo o "I" de inactivo</p>
					</div>


					<button type="button" class="btn btn-primary" id="btnProcesar">Procesar</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="js/scriptBtnBuscarInactivos.js"></script>
	<script src="js/script.js"></script>
	<script src="js/sidebar.js"></script>
</body>
</html>