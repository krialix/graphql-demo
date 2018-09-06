package com.yoloo.grapql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.yoloo.grapql.graphqldemo.data.AuthorRepository;
import com.yoloo.grapql.graphqldemo.model.Author;
import com.yoloo.grapql.graphqldemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

  private final AuthorRepository authorRepository;

  @Autowired
  public BookResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Book book) {
    return authorRepository.findById(book.getAuthor().getId()).get();
  }
}
