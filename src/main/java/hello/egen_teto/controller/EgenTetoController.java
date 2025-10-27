package hello.egen_teto.controller;

import hello.egen_teto.domain.Tester;
import hello.egen_teto.service.EgenTetoService;
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
    public String chooseGender() {
        return "testerInfo";
    }

    @PostMapping("/new/test")
    public String test(Model model, Tester tester) {
        model.addAttribute("questions", egenTetoService.getQuestionList());
        egenTetoService.setTester(tester);
        return "startTest";
    }

    @PostMapping("/new/consequence")
    public String consequence(@RequestParam Map<String, String> idAnswerText, Model model) {
        egenTetoService.clearScore();
        egenTetoService.calculateScore(idAnswerText);
        model.addAttribute("egen", egenTetoService.getEgen());
        model.addAttribute("teto", egenTetoService.getTeto());
        model.addAttribute("consequenceText", egenTetoService.getConsequenceText());
        return "consequenceView";
    }
}
