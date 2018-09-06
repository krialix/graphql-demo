package com.yoloo.grapql.graphqldemo.data;

import com.yoloo.grapql.graphqldemo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {}
