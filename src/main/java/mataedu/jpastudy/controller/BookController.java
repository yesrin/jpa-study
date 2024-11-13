package mataedu.jpastudy.controller;


import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public String addBook(String title, String name) {
       Book book= bookService.addBook(title, name);
        return  book.title;
    }
}
