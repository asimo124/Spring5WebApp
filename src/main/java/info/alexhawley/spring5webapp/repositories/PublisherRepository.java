package info.alexhawley.spring5webapp.repositories;

import info.alexhawley.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    
}
