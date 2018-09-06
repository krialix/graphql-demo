package com.yoloo.grapql.graphqldemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
  @Id @GeneratedValue private Long id;

  private String title;

  private String isbn;

  private int pageCount;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false, updatable = false)
  private Author author;
}
