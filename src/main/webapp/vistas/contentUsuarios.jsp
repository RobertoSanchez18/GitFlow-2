<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Usuarios</h1>
	</div>
	
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<div class="input-group col-3">
			<input type="text" placeholder="Search" name="nombreuser" id="form1" class="form-control" /> 
			<button type="button" class="btn btn-primary" id="btnBuscar">
				<i class="fas fa-search"></i>
			</button>
		</div>
		
		<button 
			class="btn btn-sm btn-primary shadow-sm"
			id="btnNuevo"><i class="fas fa-download fa-sm text-white-50"></i>
			New User</button>
	</div>


	<div>

		<!-- DataTales Example -->
		<div class="card shadow mb-4" id="divResultado">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Usuarios
					Registrados</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Nombre de Usuario</th>
								<th>Correo</th>
								<th>Celular</th>
								<th>Contraseña</th>
								<th>Operaciones</th>
							</tr>
						</thead>
						<tbody id="detalleTabla">

						</tbody>
					</table>
				</div>
			</div>
		</div>

		<%@ include file="../components/formAddUser.jsp"%>



	</div>



</div>