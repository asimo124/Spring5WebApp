package info.alexhawley.spring5webapp.bootstrap;

import info.alexhawley.spring5webapp.model.Author;
import info.alexhawley.spring5webapp.model.Book;
import info.alexhawley.spring5webapp.model.Publisher;
import info.alexhawley.spring5webapp.repositories.AuthorRepository;
import info.alexhawley.spring5webapp.repositories.BookRepository;
import info.alexhawley.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    public void initData() {

        Publisher hcPub = new Publisher();
        hcPub.setName("Harper Collins");
        hcPub.setAddress("234 Main");
        publisherRepository.save(hcPub);
        Author alex = new Author("Alex", "Hawley");
        Book ddd = new Book("Domain Driven Design", "12381293");
        alex.getBooks().add(ddd);
        ddd.getAuthors().add(alex);
        ddd.setPublisher(hcPub);

        authorRepository.save(alex);
        bookRepository.save(ddd);

        Publisher worxPub = new Publisher();
        worxPub.setName("WorX");
        worxPub.setAddress("348 Elm");
        publisherRepository.save(worxPub);
        Author tim = new Author("Tim", "Michaels");
        Book noEJB = new Book("J2EE Development without EJB", "34819424");
        tim.getBooks().add(ddd);
        noEJB.getAuthors().add(alex);
        noEJB.setPublisher(worxPub);

        authorRepository.save(tim);
        bookRepository.save(noEJB);
    }
}
