package uz.jakongir.readinglist.controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.jakongir.readinglist.config.AmazonProperties;
import uz.jakongir.readinglist.domain.Book;
import uz.jakongir.readinglist.domain.Reader;
import uz.jakongir.readinglist.repository.ReadingListRepository;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class ReadingListController {

    private final AmazonProperties amazonProperties;

    private final ReadingListRepository readingListRepository;

    @GetMapping
    public String readersBooks (Model model) {
        List<Book> readingList = readingListRepository.findAll();
        model.addAttribute("books", readingList);
        model.addAttribute("amazonID", amazonProperties.getAssociateId());
        return "readingList";
    }

    @PostMapping
    public String addToReadingList (Book book) {
        readingListRepository.save(book);
        return "redirect:/";
    }
}
