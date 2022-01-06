package dev.renatomo.spring5webapp.repositories;

import dev.renatomo.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
