package com.example.BookApplication.Service;


import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Repo.BookRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    BookRespo bookrepo;


    @Transactional("transactionmanager")
    public  Book  addBook (Book book ){
        Book saveBook =  bookrepo.save(book);
       return saveBook ;

    }

    public Book getBookByName(String  name){
       return  bookrepo.findBookByTitle(name);
    }

    public Book updateBook (Book book){
        Book updateBook = bookrepo.save(book);
        return updateBook ;
    }

    public void  deleteBook (Integer id ){
       bookrepo.deleteById(id);
    }
}
