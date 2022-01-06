package dev.renatomo.spring5webapp.repositories;

import dev.renatomo.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
