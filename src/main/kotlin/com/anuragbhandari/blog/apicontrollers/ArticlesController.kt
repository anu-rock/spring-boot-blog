package com.anuragbhandari.blog.apicontrollers

import com.anuragbhandari.blog.exceptions.ResourceNotFoundException
import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.respositories.ArticleRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/articles")
class ArticlesController(val repository: ArticleRepository) { // @Autowired is implicit in Controllers

    /**
     * Returns all articles.
     * !! Use with caution as this may return **lots** of data !!
     */
    @GetMapping("/") // short-form of @RequestMapping(value="/", method=RequestMethod.GET)
    fun getAllArticles(@RequestParam orderBy: String?) = when(orderBy) {
        "title" -> repository.findAllByOrderByTitle()
        else -> repository.findAllByOrderByCreatedAtDesc()
    }

    /**
     * Returns an article based on the id specified in path.
     */
    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Long): Article? {
        var article: Article? = null
        try {
            article = repository.findById(id).get()
        } catch (e: NoSuchElementException) {
            throw ResourceNotFoundException("Article", "id", id)
        }
        return article
    }

    /**
     * Creates a new article in database based on JSON received in request body.
     */
    @PostMapping("/")
    fun createNewArticle(@Valid @RequestBody article: Article): Article {
        return repository.save(article)
    }

    /**
     * Updates an existing article (referenced by id path variable)
     * based on JSON received in request body.
     */
    @PutMapping("/{id}")
    fun updateArticle(@PathVariable id: Long, @Valid @RequestBody newDetails: Article): Article {
        var article: Article? = getArticleById(id)

        article?.title = newDetails.title
        article?.content = newDetails.content

        return repository.save(article!!)
    }

    /**
     * Deletes an existing article (referenced by id path variable).
     */
    @DeleteMapping("/{id}")
    fun deleteArticle(@PathVariable id: Long): ResponseEntity<Boolean> {
        val article: Article? = getArticleById(id)
        try {
            repository.delete(article!!)
        } catch (e: IllegalArgumentException) {
            return ResponseEntity.ok().body(false)
        }
        return ResponseEntity.ok().body(true)
    }

}