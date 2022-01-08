package dev.renatomo.spring5webapp.bootstrap;

import dev.renatomo.spring5webapp.domain.Author;
import dev.renatomo.spring5webapp.domain.Book;
import dev.renatomo.spring5webapp.domain.Publisher;
import dev.renatomo.spring5webapp.repositories.AuthorRepository;
import dev.renatomo.spring5webapp.repositories.BookRepository;
import dev.renatomo.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher(
                "Publisher",
                "182 Publisher Av.",
                "Birmingham",
                "England",
                "821341"
        );
        publisherRepository.save(publisher);

        Author evans = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "9780321125217");

        evans.getBooks().add(ddd);

        ddd.getAuthors().add(evans);
        ddd.setPublisher(publisher);

        publisher.getBooks().add(ddd);

        authorRepository.save(evans);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book(
                "J2EE Development without EJ8",
                "9780764558313"
        );

        rod.getBooks().add(noEJB);

        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(publisher);
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books : " + publisher.getBooks().size());

    }
}
