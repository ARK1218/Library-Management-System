package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
    @GetMapping("/search")
    public List<Book> getBooksByTitle(@RequestParam String title) {
        return bookService.getBooksByTitle(title);
    }
    @PutMapping("/{bookId}/borrow/{memberId}")
    public Book borrowBook(@PathVariable Long bookId, @PathVariable Long memberId) {
        return bookService.borrowBook(bookId, memberId);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }
    @PutMapping("/{bookId}/return")
    public Book returnBook(@PathVariable Long bookId){
        return bookService.returnBook(bookId);
    }
}