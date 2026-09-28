package oppgavehub

import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository

@Repository
class OppgaveRepository(
    private val jdbcClient: JdbcClient
) {

    fun hentAlle(): List<Oppgave> {
        return jdbcClient.sql(
            """
            SELECT id, tittel, beskrivelse, ferdig
            FROM oppgaver
            ORDER BY id
            """
        )
            .query(Oppgave::class.java)
            .list()
            .filterNotNull()
    }

    fun hentAlleMedBruker(): List<OppgaveMedBruker> {
        return jdbcClient.sql(
            """
            SELECT
                oppgaver.tittel,
                oppgaver.beskrivelse,
                oppgaver.ferdig,
                brukere.navn,
                brukere.epost
            FROM oppgaver
            JOIN brukere
                ON oppgaver.bruker_id = brukere.id
            ORDER BY oppgaver.id
            """
        )
            .query(OppgaveMedBruker::class.java)
            .list()
            .filterNotNull()
    }

    fun opprett(tittel: String, beskrivelse: String) {
        jdbcClient.sql(
            """
            INSERT INTO oppgaver (tittel, beskrivelse, ferdig)
            VALUES (:tittel, :beskrivelse, :ferdig)
            """
        )
            .param("tittel", tittel)
            .param("beskrivelse", beskrivelse)
            .param("ferdig", false)
            .update()
    }
}