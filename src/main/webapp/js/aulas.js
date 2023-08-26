const openModal = document.querySelector("#btn-nuevo-aula");
const modal = document.querySelector(".modall");
const closeModal = document.querySelector("#btn-close-modal");
const addAula = document.querySelector("#btn-add-aula");


openModal.addEventListener('click', (e) => {
	e.preventDefault()
	modal.classList.add("modal--show");
})

closeModal.addEventListener('click', (e) => {
	e.preventDefault()
	modal.classList.remove("modal--show");
})


const selectImage = document.getElementById('selectImage');
const imagePreview = document.getElementById('imagePreview');

selectImage.addEventListener('click', function() {
	const input = document.createElement('input');
	input.type = 'file';
	input.accept = '.png';
	input.onchange = function(event) {
		const selectedFile = event.target.files[0];

		if (selectedFile && selectedFile.type === 'image/png') {
			const reader = new FileReader();

			reader.onload = function() {
				imagePreview.src = reader.result;
				imagePreview.style.display = 'block';
			};

			reader.readAsDataURL(selectedFile);
		}
	};

	input.click();
});


const inputGrado = document.querySelector("#inputGrado");
const inputSeccion = document.querySelector("#inputSeccion");
const container_aulas = document.querySelector(".container__aulas");

/*
addAula.addEventListener('click', (e) => {
	e.preventDefault();
	if (inputGrado.value == "" && inputSeccion.value == "") {
		alert("Campos vacios");
		return;
	} else {
		modal.classList.remove("modal--show");
	}
	inputGrado.value = "";
	inputSeccion.value = "";
});
*/
function nuevaAula() {
	const card_aula = document.createElement("div");
	card_aula.classList.add("card__aula");

	const image_aula = document.createElement("img");
	image_aula.src = "icons/iconAula.png";
	image_aula.alt = "iconoAula";

	const caja_grado_seccion = document.createElement("div");
	caja_grado_seccion.classList.add("text_grado_seccion");

	const txtGrado = document.createElement("p");
	txtGrado.textContent = `Grado: ${inputGrado.value}\u00B0`;
	const txtSeccion = document.createElement("p");
	txtSeccion.textContent = `Seccion: ${inputSeccion.value}`;

	caja_grado_seccion.append(txtGrado, txtSeccion);

	const caja_options = document.createElement("div");
	caja_options.classList.add("options-card");

	const btnVer = document.createElement("button");
	btnVer.classList.add("btn", "btn-sm", "btn-primary", "mr-2");


	const iconVer = document.createElement("i");
	iconVer.classList.add("fa-solid", "fa-eye");

	const btnAsignar = document.createElement("button");
	btnAsignar.classList.add("btn", "btn-sm", "btn-primary");
	btnAsignar.textContent = "Asignar";

	btnVer.appendChild(iconVer);

	caja_options.append(btnVer, btnAsignar);

	card_aula.append(image_aula, caja_grado_seccion, caja_options);

	container_aulas.appendChild(card_aula);
}

/*
const btnBuscar = document.querySelector("#btnBuscar");
btnBuscar.addEventListener('click', fnBtnBuscar);

function fnBtnBuscar() {
	let url = "AulaBuscar";
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", url, true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			let respuesta = xhttp.responseText;
			arreglo = JSON.parse(respuesta);
			let detalleCards = "";
			arreglo.forEach(function(item) {
				detalleCards += `<div class="card__aula">
									<img src="icons/iconAula.png">
									<div class="text_grado_seccion">
										<p class="txtGrado">Grado: ${item.grado}</p>
										<p class="txtSeccion">Sección: ${item.seccion}</p>
									</div>
									<div class="options-card">
										<button class="btn btn-sm btn-primary mr-2"><i class="fa-solid fa-eye"></i></button>
										<button class="btn btn-sm btn-primary">Asignar</button>
									</div>
								</div`

				document.getElementById("container__aulas").innerHTML = detalleCards;

			});
		}
	};
}
*/


























