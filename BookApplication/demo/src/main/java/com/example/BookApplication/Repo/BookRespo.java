package com.example.BookApplication.Repo;

import com.example.BookApplication.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespo extends JpaRepository<Book,Integer> {


//    we just need to write and its automaticlly write its internal query for us
    public Book findBookByTitle(String title);

}
