package ru.otus.spring11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring11.domain.Email;
import ru.otus.spring11.domain.Person;
import ru.otus.spring11.repostory.EmailRepository;
import ru.otus.spring11.repostory.PersonRepository;

import javax.annotation.PostConstruct;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Autowired
    private PersonRepository repository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        repository.save(new Person("Pushkin"));
        System.out.println(repository.findByName("Pushkin"));

        System.out.println("--------");
        emailRepository.save(new Email("alex@pushkin.ru"));
        System.out.println(emailRepository.findAll());
        System.out.println("--------");
        System.out.println(emailRepository.findByEmail("alex@pushkin.ru"));
        System.out.println("--------");
    }
}
