package uz.jakongir.readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jakongir.readinglist.domain.Book;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
