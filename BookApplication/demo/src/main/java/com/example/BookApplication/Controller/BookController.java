package com.example.BookApplication.Controller;


import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.Service.FirstProgrammatciApproach;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {



 private final  BookService bookService;

// we can use this for manually programaticaly transaction
 private final   FirstProgrammatciApproach firstProgrammatciApproach ;




 @Autowired
    public BookController(BookService bookService,FirstProgrammatciApproach firstProgrammatciApproach) {
        this.bookService = bookService;
        this.firstProgrammatciApproach=firstProgrammatciApproach;
    }




    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book ){
     firstProgrammatciApproach.updateUser();
     Book saveBook=bookService.addBook(book);
     return ResponseEntity.ok(saveBook);
    }

//    find book via name
    @GetMapping("/findBook/{name}")
    public  ResponseEntity<Book> getBookByName(@PathVariable("name") String name){
  Book getBook =  bookService.getBookByName(name);

  System.out.println("BookAfter Getting"+getBook.toString());
  return ResponseEntity.ok(getBook);
  
    }

//    update the Book
    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook (@RequestBody Book book ){
     Book updateBook = bookService.updateBook(book);
     return ResponseEntity.ok(updateBook);
    }

//    Delete api

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Book> deleteBookById(@PathVariable("id") Integer id){
System.out.println("Id will be " + id);
   bookService.deleteBook(id);
      return    ResponseEntity.ok().build();
    }

}
