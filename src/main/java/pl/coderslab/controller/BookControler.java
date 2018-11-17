package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookControler {

    private MemoryBookService memoryBookService;

    @Autowired
    public BookControler(MemoryBookService bookService) {
        this.memoryBookService = bookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: \"World\"}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion","programming");
    }

    @GetMapping
    public List<Book> getList() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return memoryBookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book modifyBook(@RequestBody Book book, @PathVariable long id) {
        return memoryBookService.modifyBook(book, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
    }

}
