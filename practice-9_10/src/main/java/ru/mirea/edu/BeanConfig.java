package ru.mirea.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.edu.programmers.JuniorProgrammer;
import ru.mirea.edu.programmers.MiddleProgrammer;
import ru.mirea.edu.programmers.Programmer;
import ru.mirea.edu.programmers.SeniorProgrammer;

@Configuration
public class BeanConfig {
    @Bean
    Programmer juniorProgrammer() {
        return new JuniorProgrammer();
    }

    @Bean
    Programmer middleProgrammer() {
        return new MiddleProgrammer();
    }

    @Bean
    Programmer seniorProgrammer() {
        return new SeniorProgrammer();
    }
}
