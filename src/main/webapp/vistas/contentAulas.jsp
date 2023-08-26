<%@page import="java.util.Iterator"%>
<%@page import="pe.edu.vallegrande.app.model.Aulas"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.vallegrande.app.service.AulasDAO"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Aulas</h1>
		<a id="btn-nuevo-aula" href="AulaController?accion=add"
			class="d-none d-sm-inline-block btn btn-sm btn-outline-primary shadow-sm"><i
			class="fa-solid fa-plus"></i> Nuevo</a>
		<!-- <a id="btnBuscar" href="AulaController?accion=listar"
			class="d-none d-sm-inline-block btn btn-sm btn-outline-primary shadow-sm" name="btnBusscar" style="display: none;"></i> Traer aulas</a>-->
	</div>

	<!-- Modal para agregar una nueva aula -->
	<section class="modall">
		<div class="modal__container">
			<h2>Nueva Aula</h2>
			<img alt="aula" src="icons/iconAula.png" id="imagePreview"
				class="modal__img">
			<button type="button" id="selectImage"
				class="btn btn-sm  btn-success">Seleccionar Icono</button>
			<form action="AulaAdd" method="post">
				<div class="input__grado">

					<div style="display: none;" class="row mb-4">
						<label for="frmId" class="col-sm-2 col-form-label">ID</label>
						<div class="col-sm-8 position-relative">
							<input name="txtid" type="text" class="form-control" id="frmId"
								disabled="disabled" value="0">
						</div>
					</div>

					<label>Grado: </label>
					<!-- <input id="inputGrado" class="form-control" type="text"> -->
					<select class="form-select form-control"
						aria-label=".form-select-sm example" id="inputGrado"
						name="txtGrado" required="required">
						<option value="" disabled selected>Elige el Grado</option>
						<option value="1">1°</option>
						<option value="2">2°</option>
						<option value="3">3°</option>
						<option value="4">4°</option>
						<option value="5">5°</option>
						<option value="6">6°</option>
					</select>
				</div>
				<div class="input__seccion">
					<label>Seccion: </label>
					<!--<input id="inputSeccion" class="form-control" type="text"> -->
					<select class="form-select form-control"
						aria-label=".form-select-sm example" id="inputSeccion"
						name="txtSeccion" required="required">
						<option value="" disabled selected>Elige la Sección</option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
					</select>
				</div>

				<div class="botones">
					<button id="btn-close-modal" type="button"
						class="btn btn-sm  btn-danger">
						<i class="fa-solid fa-xmark"></i> Cancelar
					</button>
					<button id="btnAgregar" name="accion" type="submit" class="btn btn-sm btn-primary"
						value="Save">
						<i class="fa-solid fa-plus"></i> Agregar
					</button>

				</div>
			</form>

			<script>
			
				const btnAgregar = document.querySelector("#btnAgregar");
				
				btnAgregar.addEventListener('click', () => {
					
					// El envio con AJAX
					let xhr = new XMLHttpRequest();
					xhr.open("POST", "AulaAdd", true);
					xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
					xhr.onreadystatechange = function() {
						if (xhr.readyState === 4) {
							if (xhr.readyState === 200) {
								console.log(xhr.responseText);
								alert("Exito")
							} else {
								Swal.fire({
									icon : 'success',
									title : 'Exito',
								});
							}
						}
					};
					
				})
			</script>

		</div>
	</section>


	<div class="container__aulas">
		<%
		AulasDAO dao = new AulasDAO();
		List<Aulas> list = dao.listar();
		Iterator<Aulas> iter = list.iterator();
		Aulas aul = null;
		while (iter.hasNext()) {
			aul = iter.next();
		%>
		<div class="card__aula">
			<img src="icons/iconAula.png">
			<div
				class="row mt-3 mr-2 ml-2 d-flex justify-content-center align-items-center">
				<form action="AulaEdit" method="POST">
					<input type="hidden" name="editId" value="<%=aul.getId()%>">
					<input class="btn mr-2 btn-sm btn-warning" type="submit"
						name="accion" value="Editar">
				</form>
				<form action="AulaDelete" method="POST">
					<input type="hidden" name="deleteId" value="<%=aul.getId()%>">
					<input class="btn btn-sm btn-danger" type="submit" name="accion"
						value="Delete">
				</form>
			</div>
			<div class="text_grado_seccion">
				<p class="txtGrado">
					Grado:
					<%=aul.getGrado()%>°
				</p>
				<p class="txtSeccion">
					Seccion:
					<%=aul.getSeccion()%></p>
			</div>

			<div class="options-card">
				<button class="btn btn-sm btn-primary mr-2">
					<i class="fa-solid fa-eye"></i>
				</button>
				<button class="btn btn-sm btn-primary">Asignar</button>
			</div>
		</div>
		<%
		}
		%>
	</div>



</div>

