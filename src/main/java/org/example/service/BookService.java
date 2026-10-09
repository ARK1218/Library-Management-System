package org.example.service;

import org.example.entity.Book;
import org.example.entity.Member;
import org.example.repository.BookRepository;
import org.example.repository.MemberRepository; // Don't forget this import!
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository; // Inject MemberRepository here

    // Update constructor to accept both repositories
    public BookService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBookDetails.getTitle());
            book.setAuthor(updatedBookDetails.getAuthor());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // --- NEW: Borrow Book Method ---
    public Book borrowBook(Long bookId, Long memberId) {
        // 1. Find the book, or throw an error if it doesn't exist
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));

        // 2. Find the member, or throw an error if they don't exist
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + memberId));

        // 3. Assign the member to the book
        book.setMember(member);

        // 4. Save and return the updated book
        return bookRepository.save(book);
    }
    public Book returnBook(Long BookId){
        Book book = bookRepository.findById(BookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + BookId));
        book.setMember(null);
        return bookRepository.save(book);
    }
}