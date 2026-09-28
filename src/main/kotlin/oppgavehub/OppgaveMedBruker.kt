package oppgavehub

data class OppgaveMedBruker(
    val tittel: String,
    val beskrivelse: String,
    val ferdig: Boolean,
    val navn: String,
    val epost: String
)