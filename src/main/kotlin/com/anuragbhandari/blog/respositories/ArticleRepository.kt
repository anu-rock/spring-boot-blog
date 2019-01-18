package com.anuragbhandari.blog.respositories

import com.anuragbhandari.blog.models.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc() : Iterable<Article>
    fun findAllByOrderByTitle(): Iterable<Article>
}