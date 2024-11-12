package mataedu.jpastudy.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.Book;
import mataedu.jpastudy.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/author/book-list")
    public List<Book> bookList(String name) {
        return authorService.getBookList(name);
    }

}
