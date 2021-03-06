
package com.pitchfinder.evento.controller;

import com.pitchfinder.autenticazione.entity.Admin;
import com.pitchfinder.evento.entity.Evento;
import com.pitchfinder.evento.services.EventoService;
import com.pitchfinder.evento.services.EventoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/EventoAdminController")
public class EventoAdminController extends HttpServlet {

    /** Minimum limit for name. */
    private static final int MINLIMIT = 1;
    /** Maximum limit for name. */
    private static final int MAXLIMIT = 50;
    /** Maximum limit for the Guest. */
    private static final int MAXGUESTLIMIT = 20;
    /** Maximum limit for the description. */
    private static final int MAXDESCRIPTIONLIMIT = 500;
    /** Maximum limit for the description. */
    private static final int MAXSITSLIMIT = 300;

    /**
     * doPost() method.
     * @param request is the servlet request.
     * @param response is the servlet response.
     */
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response) throws ServletException, IOException {
        Admin admin = (Admin) request.getSession().getAttribute("admin"); //get admin from the session
        RequestDispatcher dispatcher;

        if (admin != null) {
            /* Important to encode characting. */
            request.setCharacterEncoding("UTF-8");
            /* The EventoService object. */
            EventoService es = new EventoServiceImpl();
            /* The name of the Event (String). */
            String nome = request.getParameter("nome");
            /* The image's file of the event (File). */
            String immagine = request.getParameter("immagine");
            /* The start of the Event's hour (String). */
            String orarioInizioStr = request.getParameter("orarioInizio");
            /* The end of the Event's hour (String). */
            String orarioFineStr = request.getParameter("orarioFine");
            /* The Event's date (String). */
            String dateStr = request.getParameter("data");
            /* The Event's date (Date)*/
            Date dataEvento;
            /* The Event's guest (String). */
            String ospite = request.getParameter("ospite");
            /* The Event's description (String). */
            String descrizione = request.getParameter("descrizione");
            /* The Event's available sits (String). */
            String postiDisponibiliStr = request.getParameter("postiDisponibili");

            if (!(nome.length() > MINLIMIT && nome.length() < MAXLIMIT)) {
                throw new IllegalArgumentException("La lunghezza del nome non è valida");
            }
            if (!nome.matches("^[a-zA-Z0-9\u00C0-\u00ff'\\s]+$")) {
                throw new IllegalArgumentException("Il formato nel nome non è valido");
            }


            if (orarioInizioStr.matches("")) {
                throw new IllegalArgumentException("Inserire l’orario di inizio");
            }
            if (!orarioInizioStr.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                throw new IllegalArgumentException("Il formato dell'orario di inizio non è valido");
            }

            /* The start time of the Event (Time). */
            Time orarioInizio = Time.valueOf(orarioInizioStr.concat(":00"));


            if (orarioFineStr.matches("")) {
                throw new IllegalArgumentException("Inserire l’orario di fine");
            }
            if (!orarioFineStr.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                throw new IllegalArgumentException("Il formato dell'orario di fine non è valido");
            }

            /* The end time of the Event (Time). */
            Time orarioFine = Time.valueOf(orarioFineStr.concat(":00"));

            if (dateStr.equals("")) {
                throw new IllegalArgumentException("Inserire la data");
            }
            Date myDate = new Date(System.currentTimeMillis());
            try {
                dataEvento = Date.valueOf(dateStr); /* The Event's date (Date). */
                if (dataEvento.before(myDate)) {
                    throw new IllegalArgumentException("La data non rispetta il formato");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("La data non rispetta il formato");
            }
            if (!(ospite.length() > MINLIMIT && ospite.length() < MAXGUESTLIMIT)) {
                throw new IllegalArgumentException("La lunghezza del nome dell’ospite non è valida");
            }
            if (!ospite.matches("^[ a-zA-Z\\u00C0-\\u00ff']+")) {
                throw new IllegalArgumentException("Il formato dell'ospite non è valido");
            }
            if (!(descrizione.length() > MINLIMIT && descrizione.length() < MAXDESCRIPTIONLIMIT)) {
                throw new IllegalArgumentException("La lunghezza della descrizione non è valida");
            }
            if (!descrizione.matches("^[ a-zA-z\\u00C0-\\u00ff\\']+")) {
                throw new IllegalArgumentException("Il formato della descrizione non è valido");
            }
            if (postiDisponibiliStr.equals("")) {
                throw new IllegalArgumentException("Il numero di posti disponibili non è valido");
            }
            if (!postiDisponibiliStr.matches("[0-9]+$")) {
                throw new IllegalArgumentException("Il formato dei posti disponibili non è valido");
            }
            int postiDisponibili = Integer.parseInt(postiDisponibiliStr); /* The Event's available sits (Integer). */
            if (!(postiDisponibili > MINLIMIT && postiDisponibili < MAXSITSLIMIT)) {
                throw new IllegalArgumentException("Il numero di posti disponibili non è valido");
            }
            String image = "default";
            if (immagine != null) {
                if (immagine.matches("[0-9]$")) {
                    switch (Integer.parseInt(immagine)) {
                        case 1 :
                            image = "images/events/image1.jpg";
                            break;
                        case 2 :
                            image = "images/events/image2.jpg";
                            break;
                        case 3 :
                            image = "images/events/image3.jpg";
                            break;
                        default :
                            image = "default";
                    }
                }
            }
            Evento creazione = es.createEvento(nome, image, orarioInizio, orarioFine, dataEvento,
                    ospite, descrizione, postiDisponibili, admin.getUsername());
            if (creazione == null) {
                response.setContentType("Impossibile creare un evento");
            }

            response.setContentType("La creazione dell’evento è andata a buon fine");
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/autentication?"
                    + "flag=5&result=1&message=La creazione dell’evento è andata a buon fine");
            requestDispatcher.forward(request, response);

        }
    }



    /**
     * doGet() method.
     * @param request is the servlet request.
     * @param response is the servlet response.
     */
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
