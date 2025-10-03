package hello.egen_teto.controller;

import hello.egen_teto.domain.Answer;
import hello.egen_teto.service.EgenTetoService;
import hello.egen_teto.domain.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class EgenTetoController {

    EgenTetoService egenTetoService;

    @Autowired
    public EgenTetoController(EgenTetoService egenTetoService) {
        this.egenTetoService = egenTetoService;
    }

    @GetMapping("/new")
    public String selectGender() {
        return "selectGender";
    }

    @PostMapping("/new/test")
    public String test(Tester tester, Model model ) {
        egenTetoService.setTest(tester);
        model.addAttribute("questions", egenTetoService.getQuestions());
        return "startTest";
    }

    @PostMapping("/new/consequence")
    public String consequence(@RequestParam Map<String, String> idAnswers, Model model) {
        egenTetoService.calculateScore(idAnswers);
        model.addAttribute("egen", egenTetoService.getEgen());
        model.addAttribute("teto", egenTetoService.getTeto());
        return "consequenceView";
    }
}
