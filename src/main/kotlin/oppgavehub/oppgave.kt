package oppgavehub

data class Oppgave(
    val id: Int,
    val tittel: String,
    val beskrivelse: String,
    val ferdig: Boolean
)