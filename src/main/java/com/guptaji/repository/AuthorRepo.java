package com.guptaji.repository;

import com.guptaji.entity.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepo implements PanacheRepositoryBase<Author, Long> {
}
