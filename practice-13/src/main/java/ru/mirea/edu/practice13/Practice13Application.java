package ru.mirea.edu.practice13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Practice13Application {
	private final Student student;

    public Practice13Application(Student student) {
        this.student = student;
    }

    public static void main(String[] args) {
		SpringApplication.run(Practice13Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void printStudent() {
		System.out.println(student);
	}

}
