package hello.egen_teto;

import hello.egen_teto.service.EgenTetoService;
import hello.egen_teto.setting.SetQuestions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EgenTetoConfigure {

    @Bean
    public EgenTetoService egenTetoService() {
        return new EgenTetoService(setQuestions());
    }

    @Bean
    public SetQuestions setQuestions() {
        return new SetQuestions();
    }
}
