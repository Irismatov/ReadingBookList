package uz.jakongir.readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jakongir.readinglist.domain.Reader;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, String> {

    Optional<Reader> findByUsername(String username);
}
