package uz.jakongir.readinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.jakongir.readinglist.domain.Book;
import uz.jakongir.readinglist.repository.ReadingListRepository;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class ReadingListController {
    private final
    ReadingListRepository readingListRepository;

    @GetMapping("/{reader}")
    public String readersBooks (@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @PostMapping("/{reader}")
    public String addToReadingList (@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
