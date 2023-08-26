<%@page import="pe.edu.vallegrande.app.service.AulasDAO"%>
<%@page import="pe.edu.vallegrande.app.model.Aulas"%>
<%@ include file="sidebarForVistas.jsp"%>

<div class="container-fluid">
	<div class="d-sm-flex align-items-center justify-content-center mb-4">
		<h1 class="h3 mb-0 text-gray-800">Editar Aula</h1>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<form action="AulaEdit" method="POST">
					<div class="row">
						<div class="col-6">

							<label>Grado:</label> <select class="form-select form-control"
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
						<div class="col-6">

							<label>Seccion: </label> <select class="form-select form-control"
								aria-label=".form-select-sm example" id="inputSeccion"
								name="txtSeccion" required="required">
								<option value="" disabled selected>Elige la Sección</option>
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>

						</div>
					</div>
					<div class="container-fluid d-flex justify-content-center mt-4">
						<div class="row">
							<div class="col-12">
								<button class="btn btn-primary" type="submit"
									value="enviar">Actualizar</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</div>

<%@ include file="sidebarBottomForVistas.jsp"%>

<%@ include file="end.jsp"%>