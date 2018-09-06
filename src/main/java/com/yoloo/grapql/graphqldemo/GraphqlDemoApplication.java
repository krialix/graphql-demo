package com.yoloo.grapql.graphqldemo;

import com.yoloo.grapql.graphqldemo.data.AuthorRepository;
import com.yoloo.grapql.graphqldemo.data.BookRepository;
import com.yoloo.grapql.graphqldemo.model.Author;
import com.yoloo.grapql.graphqldemo.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
    return (args) -> {
      Author author = new Author(null, "Herbert", "Schildt");
      authorRepository.save(author);

      bookRepository.save(
          new Book(null, "Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
    };
  }
}
