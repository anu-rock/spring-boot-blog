package com.anuragbhandari.blog.apicontrollers

import com.anuragbhandari.blog.exceptions.ResourceNotFoundException
import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.respositories.ArticleRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/articles")
class ArticlesController(val repository: ArticleRepository) { // @Autowired is implicit in Controllers

    @GetMapping("/")
    fun findAll(@RequestParam orderBy: String?) = when(orderBy) {
        "title" -> repository.findAllByOrderByTitle()
        else -> repository.findAllByOrderByCreatedAtDesc()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Article? {
        var article: Article? = null
        try {
            article = repository.findById(id).get()
        } catch (e: NoSuchElementException) {
            throw ResourceNotFoundException("Article", "id", id)
        }
        return article
    }


}