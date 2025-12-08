package hello.egen_teto.controller;

import hello.egen_teto.domain.Question;
import hello.egen_teto.domain.Tester;
import hello.egen_teto.dto.ResultDto;
import hello.egen_teto.service.EgenTetoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SuppressWarnings("unchecked")
public class EgenTetoController {

    EgenTetoService egenTetoService;

    @Autowired
    public EgenTetoController(EgenTetoService egenTetoService) {
        this.egenTetoService = egenTetoService;
    }

    @GetMapping("/new")
    public String testerInfo() {
        return "new";
    }

    @PostMapping("/new")
    public String test(Tester tester, HttpSession session) {
        session.setAttribute("tester", tester);
        session.setAttribute("myAnswers", new HashMap<Long, Long>());

        List<Question> questionList = egenTetoService.getQuestionList();
        session.setAttribute("totalSize", questionList.size());
        return "redirect:/new/test/1";
    }

    @GetMapping("/new/test/{pageNumber}")
    public String startTest(@PathVariable int pageNumber, Model model) {
        List<Question> questionList = egenTetoService.getQuestionList();
        Question currentQuestion = questionList.get(pageNumber - 1);
        model.addAttribute("question", currentQuestion);
        model.addAttribute("pageNumber", pageNumber);
        return "test";
    }

    @PostMapping("/new/test/{pageNumber}")
    public String saveAnswer(@PathVariable int pageNumber,
                             @RequestParam Long questionId,
                             @RequestParam Long answerId, HttpSession session) {
        Map<Long, Long> myAnswers = (Map<Long, Long>) session.getAttribute("myAnswers");
        myAnswers.put(questionId,answerId);

        int nextPage = pageNumber + 1;
        int totalSize = (int) session.getAttribute("totalSize");

        if (nextPage <= totalSize ) {
            return "redirect:/new/test/" + nextPage;
        } else {
            return "redirect:/new/result";
        }

    }

    @GetMapping("/new/result")
    public String consequence(Model model, HttpSession session) {
        Map<Long, Long> myAnswers = (Map<Long, Long>) session.getAttribute("myAnswers");
        Tester tester = (Tester) session.getAttribute("tester");
        ResultDto result = egenTetoService.saveAndCalculateScore(myAnswers, tester);

        model.addAttribute("tester",  tester);
        model.addAttribute("result", result);

        session.invalidate();

        return "result";
    }
}
