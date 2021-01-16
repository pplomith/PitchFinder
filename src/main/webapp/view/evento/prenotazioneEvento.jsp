<%@ page import="com.pitchfinder.evento.entity.Evento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pitchfinder.autenticazione.entity.Utente" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>PitchFinder</title>
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico"/>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/evento/style_evento.css" rel="stylesheet" type="text/css"/>
    <link href="css/navbar/style_navbar.css" rel="stylesheet" type="text/css"/>
    <link href="css/footer/style_footer.css" rel="stylesheet">
    <style>
        input[type=button], input[type=submit], input[type=reset] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 16px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body id="page-top">
<!-- Navigation-->
<%@ include file="../navbar/navbar.jsp" %>
<!-- Services-->

<section class="page-section" id="services">
    <div class="row text-center">


    </div>
</section>
<div class="container">
    <div class="row">
        <% Evento evento = (Evento) request.getAttribute("evento");
            Utente utente = (Utente) request.getAttribute("utente");
        %>
        <div class="col-lg-4">
            <div class="card card-margin">
                <div class="card-header no-border">
                    <h5 class="card-title">Evento - Tennis</h5>
                </div>
                <div class="card-body pt-0">
                    <div class="widget-49">
                        <div class="widget-49-title-wrapper">
                            <div class="widget-49-date-primary">
                                <%if (evento.getImage().equalsIgnoreCase("default")) { %>
                                <span class="widget-49-date-day"><%= evento.getStringDay(evento.getDate().getDay())%></span>
                                <span class="widget-49-date-month"><%= evento.getStringMonth(evento.getDate().getMonth())%></span>
                                <%} else { %>
                                <img style="border-radius: 50%;" width="64px" height="64px"
                                     src="<%= evento.getImage().replace("src/main/webapp/","")%>"/>
                                <%}%>
                            </div>
                            <div class="widget-49-meeting-info">
                                <span class="widget-49-pro-title"><%= evento.getName()%></span>
                                <span class="widget-49-meeting-time"> <%= evento.getDate()%> Dalle <%= evento.getStartHour()%> alle <%= evento.getEndHour()%></span>
                            </div>

                        </div>
                        <ol class="widget-49-meeting-points">
                            <li class="widget-49-meeting-item">
                                <span><Strong>Posti Disponibili</Strong> - ${postiDisponibili}</span></li>
                            <li class="widget-49-meeting-item">
                                <span><strong>Il nostro ospite</strong> - <%= evento.getGuest()%></span></li>
                            <li class="widget-49-meeting-item">
                                <span><strong>Descrizione:</strong> - <%= evento.getDescription()%></span></li>
                        </ol>
                        <div class="widget-49-meeting-action">

                            <form method="post" name="prenotazione" id="prenotazione"
                                  onsubmit="return cambiaStatoIscrizione()" action="PrenotazioneEventoController">
                                <input type="hidden" class="eventDate" name="eventDate" value="<%=evento.getDate()%>">
                                <input type="hidden" class="eventName" name="eventName" value="<%=evento.getName()%>">
                                <table style=" margin-left: auto; margin-right: auto;">
                                    <tr>
                                        <td>
                                            <p id="emailLabel">Email</p>
                                        </td>
                                        <td>
                                            <i id="alert" style="display: none; position: relative" data-placement="top" data-toggle="tooltip" title="Example: Mario99@gmail.com" class="fas fa-fw fa-exclamation-circle mr-3 align-self-center"></i>
                                        </td>
                                    </tr>
                                </table>


                                <%if (utente == null) {%>
                                <input type="email" id="email" onkeyup="validaEmail()" name="email"><br>
                                <%} else {%>
                                <input type="email" id="email" onkeyup="validaEmail()" name="email"
                                       value="${utente.email}"><br>
                                <%}%>
                                <input type="submit" class="btn btn-sm btn-flash-border-primary" id="conferma"
                                       name="Conferma" value="Prenotati!">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer-->
<footer class="footer py-4">
    <%@include file="../footer/footer.jsp" %>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Third party plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<!-- Contact form JS-->
<script src="assets/mail/jqBootstrapValidation.js"></script>
<script src="assets/mail/contact_me.js"></script>
<!-- Core theme JS-->
<script src="js/homepage/js_homepage.js"></script>
<script src="js/homepage/check_login.js"></script>

<!--Script for alert-->
<%
    String ok = (String) request.getAttribute("prenotazione");
    if (ok != null) {
        request.setAttribute("prenotazione", null);
%>
<script>
    alert("Prenotazione effettuata con successo!");
</script>
<%}%>
<!--Script for alert-->
<script>
    var borderOk = '#080';
    var borderNo = '#f00';
    var emailOk = false;

    function validaEmail() {
        var input = document.getElementById("email");
        if (input.value.length > 0
            && input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/) && input.value.length < 50) {
            document.getElementById("emailLabel").style.color = borderOk;
            document.getElementById("alert").style.display = "none";
            emailOk = true;
        } else {
            document.getElementById("emailLabel").style.color = borderNo;
            document.getElementById("alert").style.display = "block";
            document.getElementById("alert").style.color = borderNo;

            emailOk = false;
        }
        cambiaStatoIscrizione();
    }

    function cambiaStatoIscrizione() {
        if (emailOk) {
            document.getElementById('conferma').disabled = false;
            return true;
        }
        document.getElementById('conferma').disabled = true;
        return false;
    }
</script>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>

</body>
</html>
