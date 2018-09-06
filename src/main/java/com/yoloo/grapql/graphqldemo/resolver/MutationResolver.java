package com.yoloo.grapql.graphqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.yoloo.grapql.graphqldemo.data.AuthorRepository;
import com.yoloo.grapql.graphqldemo.data.BookRepository;
import com.yoloo.grapql.graphqldemo.model.Author;
import com.yoloo.grapql.graphqldemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  @Autowired
  public MutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  public Author newAuthor(String firstName, String lastName) {
    Author author = new Author();
    author.setFirstName(firstName);
    author.setLastName(lastName);

    authorRepository.save(author);

    return author;
  }

  public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
    Book book = new Book();
    Author author = new Author();
    author.setId(authorId);
    book.setAuthor(author);
    book.setTitle(title);
    book.setIsbn(isbn);
    book.setPageCount(pageCount != null ? pageCount : 0);

    bookRepository.save(book);

    return book;
  }

  public boolean deleteBook(Long id) {
    bookRepository.deleteById(id);
    return true;
  }

  public Book updateBookPageCount(Integer pageCount, Long id) {
    Book book = bookRepository.findById(id).get();
    book.setPageCount(pageCount);

    bookRepository.save(book);

    return book;
  }
}
