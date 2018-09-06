package com.yoloo.grapql.graphqldemo.data;

import com.yoloo.grapql.graphqldemo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {}
