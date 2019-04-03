package info.alexhawley.spring5webapp.repositories;

import info.alexhawley.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
