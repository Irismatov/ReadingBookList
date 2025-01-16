package uz.jakongir.readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jakongir.readinglist.domain.Book;
import uz.jakongir.readinglist.domain.Reader;

import java.util.List;
import java.util.Optional;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
