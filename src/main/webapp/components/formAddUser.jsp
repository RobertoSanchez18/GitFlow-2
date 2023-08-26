<!-- Formulario de edición de registro -->
<div class="card" id="divRegistro" style="display: none;">
	<div class="card-header" id="tituloRegistro">{accion} ESTUDIANTE</div>
	<div class="card-body" style="margin: 0 auto;">
		<form id="mi-formulario" style="margin-left: 70px">
			<input type="hidden" id="accion" name="accion">
			<div style="display: none;" class="row mb-4">
				<label for="frmId" class="col-sm-2 col-form-label">ID</label>
				<div class="col-sm-4 position-relative">
					<input type="text" class="form-control" id="frmId"
						disabled="disabled" value="0">
				</div>
			</div>

			<div class="row mb-4" id="grupo__nombreUsuario">
				<label for="frmNombreUsuario"
					class="col-sm-2 col-form-label formulario__label">Nombre de Usuario</label>
				<div class="col-sm-4 position-relative">
					<input type="text" class="form-control" name="nombreUsuario"
						id="frmNombreUsuario"><i
						class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
				</div>
				<p class="formulario__input-error">Ingrese un Nombre de Usuario valido</p>
			</div>

			<div class="row mb-2" id="grupo__correo">
				<label for="frmCorreo"
					class="col-sm-2 col-form-label formulario__label">Correo</label>
				<div class="col-sm-4 position-relative">
					<input type="text" class="form-control" name="correo"
						id="frmCorreo"><i
						class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
				</div>
				<p class="formulario__input-error">Ingrese un correo valido</p>
			</div>

			<div class="row mb-4" id="grupo__celular">
				<label for="frmCelular"
					class="col-sm-2 col-form-label formulario__label">Celular</label>
				<div class="col-sm-4 position-relative">
					<input type="text" class="form-control" name="celular"
						id="frmCelular"> <i
						class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
				</div>
				<p class="formulario__input-error">El numero de celular debe tener 9 digitos numericos</p>
			</div>

			<div class="row mb-4" id="grupo__pass">
				<label for="frmPass"
					class="col-sm-2 col-form-label formulario__label">Contraseña</label>
				<div class="col-sm-4 position-relative">
					<input type="password" class="form-control" name="pass"
						id="frmPass"> <i
						class="formulario__validacion-estado fa-sharp fa-solid fa-circle-xmark"></i>
				</div>
				<p class="formulario__input-error">Asegurese de que no haya
					signos</p>
			</div>

			

			<div style="display: none;" class="row mb-4" id="grupo__estado">
				<label for="frmEstado"
					class="col-sm-2 col-form-label formulario__label">Estado <a
					title="Selecciona A de activo o I de inactivo" href="#"><i
						class="fa-solid fa-circle-info" style="font-size: 20px"></i></a>
				</label>
				<div class="col-sm-8 position-relative">
					<input type="text" class="form-control" id="frmEstado"
						disabled="disabled" value="A">
				</div>
				<p class="formulario__input-error">Solo debe ingresar la "A" de
					activo o "I" de inactivo</p>
			</div>


			<button type="button" class="btn btn-primary" id="btnProcesar">Agregar</button>
		</form>
	</div>
</div>