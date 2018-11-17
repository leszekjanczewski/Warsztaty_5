package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MemoryBookService {
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

    public Book getBookById(long id) {
        return list.stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    public Book createBook(Book book) {
        list.add(book);
        book.setId(list.size());
        return book;
    }

    public Book modifyBook(Book book, long id) {
        Book modifyBook = getBookById(id);
        modifyBook.setIsbn(book.getIsbn());
        modifyBook.setAuthor(book.getAuthor());
        modifyBook.setPublisher(book.getPublisher());
        modifyBook.setTitle(book.getTitle());
        modifyBook.setType(book.getType());
        return modifyBook;
    }

    public void deleteBook(long id) {
        Book delBook = getBookById(id);
        list.remove(delBook);
    }
}
