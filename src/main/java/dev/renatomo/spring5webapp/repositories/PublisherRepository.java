package dev.renatomo.spring5webapp.repositories;

import dev.renatomo.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
