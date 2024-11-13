package mataedu.jpastudy.controller;


import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @PostMapping("/book")
    public String addBook(String title, String name) {
        bookService.addBook(title, name);
        return title + "을 추가했습니다";
    }
}
