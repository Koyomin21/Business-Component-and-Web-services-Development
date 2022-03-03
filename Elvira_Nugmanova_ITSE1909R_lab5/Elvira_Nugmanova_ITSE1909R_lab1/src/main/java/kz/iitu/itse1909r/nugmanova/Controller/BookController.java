//package kz.iitu.itse1909r.nugmanova.Controller;
//
//import kz.iitu.itse1909r.nugmanova.Database.Author;
//import kz.iitu.itse1909r.nugmanova.Database.Book;
//import kz.iitu.itse1909r.nugmanova.Repository.AuthorRepository;
//import kz.iitu.itse1909r.nugmanova.Repository.BookRepository;
//import kz.iitu.itse1909r.nugmanova.Service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.websocket.server.PathParam;
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/books")
//public class BookController {
//    BookService bookService = null;
//
//    @Autowired
//    public BookController(BookService bookServices){
//        bookService = bookServices;
//    }
//
//
//    @GetMapping("/getall")
//    public List<Book> getAllBooks(){
//        return bookService.getAllBooks();
//    }
//
//    @GetMapping("getbyauthor")
//    public List<Book> getBooksByAuthor() {
//        Integer authorId = 1;
//        return bookService.getBooksByAuthorId(authorId);
//    }
//
//    @GetMapping("getbyyear")
//    public List<Book> getBooksByYear() {
//        Integer year = 1965;
//        return bookService.getBooksByYear(year);
//    }
//
//    @GetMapping("getbyid/{id:[0-9]+}")
//    public Book getBookById(@PathVariable("id") Integer id) {
//        return bookService.getBookById(id);
//    }
//}
