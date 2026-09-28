package oppgavehub

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class PageController(
    private val oppgaveRepository: OppgaveRepository
) {

    @GetMapping("/")
    fun hjem(): String {
        return "index"
    }

    @GetMapping("/oppgaver")
    fun oppgaver(model: Model): String {

        val oppgaver = oppgaveRepository.hentAlleMedBruker()

        model.addAttribute("oppgaver", oppgaver)

        return "oppgaver"
    }

    @PostMapping("/oppgaver")
    fun leggTilOppgave(
        @RequestParam tittel: String,
        @RequestParam beskrivelse: String
    ): String {

        oppgaveRepository.opprett(
            tittel = tittel,
            beskrivelse = beskrivelse
        )

        return "redirect:/oppgaver"
    }

    @GetMapping("/om")
    fun om(): String {
        return "om"
    }
}