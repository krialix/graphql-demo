package com.yoloo.grapql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.yoloo.grapql.graphqldemo.data.AuthorRepository;
import com.yoloo.grapql.graphqldemo.data.BookRepository;
import com.yoloo.grapql.graphqldemo.model.Author;
import com.yoloo.grapql.graphqldemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  @Autowired
  public QueryResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Iterable<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public long countBooks() {
    return bookRepository.count();
  }

  public long countAuthors() {
    return authorRepository.count();
  }
}
