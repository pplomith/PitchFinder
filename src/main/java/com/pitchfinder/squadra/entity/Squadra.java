package com.pitchfinder.squadra.entity;

import java.util.Date;
import java.util.Objects;

public class Squadra {
    /**
     * Is the name of the team.
     */
    private String nome;

    /**
     * Is the name of the tournament.
     */
    private String torneoNome;

    /**
     * The start date of the tournament.
     */
    private Date torneoDataInizio;

    /**
     * Is the id of the tournament's pitch.
     */
    private int torneoCampoIdentificativo;

    /**
     * Is the number of players.
     */
    private int numeroMembri;

    /**
     * Is the captain of the team.
     */
    private String capitano;

    /**
     * Is the user email.
     */
    private String utenteEmail;

    /**
     * Constructor void.
     */
    public Squadra() {
    }

    /**
     *
     * @param nomesquadra - is the name of team.
     * @param torneonome - is the tournament's name.
     * @param torneodatainizio - is the start date of the tournament.
     * @param torneocampoidentificativo - is the id of pitch's tournament.
     * @param numeromembri - is the number of players.
     * @param nomecapitano - is the name of captain.
     * @param utenteemail - is the user email.
     */
    public Squadra(final String nomesquadra, final String torneonome, final Date torneodatainizio, final int torneocampoidentificativo, final int numeromembri, final String nomecapitano, final String utenteemail) {
        this.nome = nomesquadra;
        this.torneoNome = torneonome;
        this.torneoDataInizio = torneodatainizio;
        this.torneoCampoIdentificativo = torneocampoidentificativo;
        this.numeroMembri = numeroMembri;
        this.capitano = nomecapitano;
        this.utenteEmail = utenteemail;
    }

    /**
     * Returns team's name.
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of team.
     * @param nomeTeam - is the name of the team
     */
    public void setNome(final String nomeTeam) {
        this.nome = nomeTeam;
    }

    /**
     * Returns the tournament's name.
     * @return String
     */
    public String getTorneoNome() {
        return torneoNome;
    }

    /**
     * Sets the tournament's name.
     * @param torneo- is the tournament's name
     */
    public void setTorneoNome(final String torneo) {
        this.torneoNome = torneo;
    }

    /**
     * Returns the start date of the tournament.
     * @return Date
     */
    public Date getTorneoDataInizio() {
        return torneoDataInizio;
    }

    /**
     * Sets  the start date of the tournament.
     * @param torneoData -  is the start date of the tournament.
     */
    public void setTorneoDataInizio(final Date torneoData) {
        this.torneoDataInizio = torneoData;
    }

    /**
     * Returns the id of tournament's pitch.
     * @return int
     */
    public int getTorneoCampoIdentificativo() {
        return torneoCampoIdentificativo;
    }

    /**
     * Sets the id of tournament's pitch.
     * @param torneoCampoidentificativo - is the id of tournament's pitch.
     */
    public void setTorneoCampoIdentificativo(final int torneoCampoidentificativo) {
        this.torneoCampoIdentificativo = torneoCampoidentificativo;
    }

    /**
     * Returns the number of players.
     * @return int
     */
    public int getNumeroMembri() {
        return numeroMembri;
    }

    /**
     * Sets the number of players.
     * @param numeroGiocatori - is the number of players.
     */
    public void setNumeroMembri(final int numeroGiocatori) {
        this.numeroMembri = numeroMembri;
    }

    /**
     * Returns the team's captain.
     * @return String
     */
    public String getCapitano() {
        return capitano;
    }

    /**
     * Sets the team's captain.
     * @param capitano - is the team's captain.
     */
    public void setCapitano(final String capitano) {
        this.capitano = capitano;
    }

    /**
     * Returns utente email.
     * @return String
     */
    public String getUtenteEmail() {
        return utenteEmail;
    }

    /**
     * Sets user email
     * @param utenteEmail - is the  user email
     */
    public void setUtenteEmail(final String utenteEmail) {
        this.utenteEmail = utenteEmail;
    }

    /**
     * Takes Object o and if o is equal to this return true else return false.
     * @param o - is istance of the class Squadra.
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Squadra squadra = (Squadra) o;
        return torneoCampoIdentificativo == squadra.torneoCampoIdentificativo && numeroMembri == squadra.numeroMembri && Objects.equals(nome, squadra.nome) && Objects.equals(torneoNome, squadra.torneoNome) && Objects.equals(torneoDataInizio, squadra.torneoDataInizio) && Objects.equals(capitano, squadra.capitano) && Objects.equals(utenteEmail, squadra.utenteEmail);
    }

    /**
     * Returns a hash value for an object.
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, torneoNome, torneoDataInizio, torneoCampoIdentificativo, numeroMembri, capitano, utenteEmail);
    }

    /**
     *Returns a string that can be considered as the
     * "textual representation" of the object
     * on which it is invoked.
     * @return String
     */
    @Override
    public String toString() {
        return "Squadra{"
                + "nome='" + nome + '\''
                + ", torneoNome='" + torneoNome + '\''
                + ", torneoDataInizio=" + torneoDataInizio
                + ", torneoCampoIdentificativo=" + torneoCampoIdentificativo
                + ", numeroMembri=" + numeroMembri
                + ", capitano='" + capitano + '\''
                + ", utenteEmail='" + utenteEmail + '\''
                + '}';
    }
}
