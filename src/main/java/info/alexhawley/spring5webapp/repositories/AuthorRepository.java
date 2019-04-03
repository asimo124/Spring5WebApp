package info.alexhawley.spring5webapp.repositories;

import info.alexhawley.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
