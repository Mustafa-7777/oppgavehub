package oppgavehub

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class NyOppgave(
    val tittel: String,
    val beskrivelse: String
)

@RestController
@RequestMapping("/api/oppgaver")
class OppgaveApiController(
    private val oppgaveRepository: OppgaveRepository
) {

    @GetMapping
    fun hentOppgaver(): List<Oppgave> {
        return oppgaveRepository.hentAlle()
    }

    @PostMapping
    fun opprettOppgave(
        @RequestBody nyOppgave: NyOppgave
    ): String {

        oppgaveRepository.opprett(
            tittel = nyOppgave.tittel,
            beskrivelse = nyOppgave.beskrivelse
        )

        return "Oppgave opprettet"
    }
}