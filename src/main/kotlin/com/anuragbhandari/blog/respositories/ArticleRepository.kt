package com.anuragbhandari.blog.respositories

import com.anuragbhandari.blog.models.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    // Methods such as save(), findOne(), findAll(), delete(), etc.
    // will automatically be plugged in (via an implementation of CrudRepository)
    // by Spring during bootstrapping.

    // Query methods: they dynamically create queries based on method names.
    // Check Spring Data JPA documentation for more such magic awesomeness:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
    fun findAllByOrderByCreatedAtDesc() : Iterable<Article>
    fun findAllByOrderByTitle(): Iterable<Article>
}