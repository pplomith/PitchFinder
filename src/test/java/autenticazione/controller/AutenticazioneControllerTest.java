package autenticazione.controller;

import com.pitchfinder.autenticazione.controller.AutenticazioneController;
import com.pitchfinder.autenticazione.entity.Utente;
import com.pitchfinder.autenticazione.services.AutenticazioneServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class AutenticazioneControllerTest extends Mockito {

    private final AutenticazioneServiceImpl asi = new AutenticazioneServiceImpl();
    private final String email = "mario99@gmail.com";
    private final String username = "Mariox99";
    private final String nome = "Mario";
    private final String cognome = "Rossi";
    private final String password = "PitchFinder57";
    private final Date d = new Date(1999, 5, 23);
    IllegalArgumentException exception = null;
    private AutenticazioneController servlet;

    @Before
    public void setUp() {
        servlet = new AutenticazioneController();
    }

    @Test
    void TC_4_1_1() {

        String message = "Il login non va a buon fine " +
                "perché l’e-mail non rispetta la " +
                "lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_1_2() {

        String message = "Il login non va a buon fine " +
                "perché il formato dell’e-mail non è corretto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.loginUtente("mario99 @gmail.com", password);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_1_3() {

        String message = "Il login non va a buon " +
                "fine perché la password inserita non è corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.loginUtente("mario99@gmail.com", "Pitch Finder57");
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_1_4() {

        assertEquals(asi.loginUtente(email, password).getClass().getName(),
                Utente.class.getName());
    }

    @Test
    void TC_4_2_1() {

        String message = "La registrazione " +
                "non va a buon fine perché l’email inserita non " +
                "rispetta la lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente("",
                      //      username, nome,
                        //    cognome, password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_2() {

        String message = "La registrazione non va a buon " +
                "fine perché l’email inserita " +
                "non rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    // asi.registraUtente("mario 99@gmail.com", username, nome, cognome, password, null);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_3() {

        String message = "La registrazione non va " +
                "a buon fine perché la username non " +
                "rispetta la lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente(email, "", nome,
                      //      cognome, password, d);
                   // servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_4() {

        String message = "La registrazione non va a buon fine " +
                "perché la username inserita " +
                "non rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente(email, "ciao 99", nome,
                      //      cognome, password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_5() {

        String message = "La registrazione non va a buon fine " +
                "perché il nome inserito non " +
                "rispetta la lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                   // asi.registraUtente(email, username, "",
                     //       cognome, password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_6() {

        String message = "La registrazione non va a buon fine " +
                "perché il nome inserito non " +
                "rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente(email, username, "emane nulds",
                      //      cognome, password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_7() {

        String message = "La registrazione non va a buon fine " +
                "perché il cognome inserito non rispetta " +
                "la lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                   // asi.registraUtente(email, username, nome,
                     //       "", password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_8() {

        String message = "La registrazione non va a buon " +
                "fine perché il cognome inserito " +
                "non rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente(email, username, nome,
                      //      "bellociao dds", password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_9() {

        String message = "La registrazione non va a buon fine " +
                "perché la password inserita non rispetta la " +
                "lunghezza corretta";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                   // asi.registraUtente(email, username, nome,
                     //       cognome, "", d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_10() {

        String message = "La registrazione non va a buon fine "
                + "perché la password inserita non "
                + "rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                   // asi.registraUtente(email, username, nome,
                     //       cognome, "Pitch Finder57", d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_11() {

        String message = "La registrazione non va a buon fine perché " +
                "la data di nascita non è stata selezionata";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    //asi.registraUtente(email, username, nome,
                      //      cognome, password, null);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_12() {

        String message = "La registrazione non va a buon fine " +
                "perché la data di nascita " +
                "non rispetta il formato richiesto";

        exception = assertThrows(
                IllegalArgumentException.class, () -> {
                   // asi.registraUtente(email, username, nome,
                     //       cognome, password, d);
                    //servlet.doPost(request, response);
                });

        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_4_2_13() {

        assertTrue(asi.registraUtente(email, username, nome, cognome, password, d));
    }

}