package ru.mirea.edu;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.edu.programmers.Programmer;

public class SpringRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        if (args.length != 1) {
            throw new IllegalArgumentException("Provide bean name");
        }

        try {
            Programmer programmer = context.getBean(args[0], Programmer.class);

            System.out.print("Calling programmer... ");
            programmer.doCoding();
        } catch (BeansException exception) {
            throw new IllegalArgumentException("Invalid bean name");
        }
    }
}
