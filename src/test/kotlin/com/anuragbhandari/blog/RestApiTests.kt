package com.anuragbhandari.blog

import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.models.User
import com.anuragbhandari.blog.respositories.ArticleRepository
import com.anuragbhandari.blog.respositories.UserRepository
import com.nhaarman.mockito_kotlin.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@WebMvcTest
class RestApiTests(@Autowired val mockMvc: MockMvc) {

    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var articleRepository: ArticleRepository

    @Test
    fun `List article`() {
        val anurag = User("anurag", "Anurag", "Bhandari")
        val article1 = Article(
            id = 1,
            title = "Anurag hacks the internet",
            headline = "Internet will never be the same",
            content = """"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."""",
            author = anurag
        )
        val article2 = Article(
                id = 2,
                title = "Anurag saves the planet",
                headline = "The crime-fighting legend kicks 1 tonne of waste plastic with one foot.",
                content = """"Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."""",
                author = anurag
        )
        whenever(articleRepository.findAllByOrderByCreatedAtDesc()).thenReturn(listOf(article1, article2))
        mockMvc.perform(get("/api/articles")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("\$.[0].id").value(article1.id!!))
    }

}