<%@ include file="vistas/sidebar.jsp"%>

<div class="container__saludo" id="popup">
        <img class="gif__saludo" src="images/manoSaludo.gif" alt="saludo">
        <p>Bienvenido al Sistema ${nombreuser}</p>
        <div class="close__saludo" id="close">
            <img src="images/closecircle.svg" alt="close">
        </div>
</div>

<%@ include file="vistas/contentDashboard.jsp"%>



<%@ include file="vistas/sidebarBottom.jsp"%>

<script src="js/dashboard.js"></script>

<%@ include file="vistas/end.jsp"%>