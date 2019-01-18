package com.anuragbhandari.blog

import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.models.User
import com.anuragbhandari.blog.respositories.ArticleRepository
import com.anuragbhandari.blog.respositories.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.assertj.core.api.Assertions.assertThat

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val userRepository: UserRepository,
                        @Autowired val articleRepository: ArticleRepository) {

    @Test
    fun `When findById then return Article`() {
        val anurag = User("anurag", "Anurag", "Bhandari")
        entityManager.persist(anurag)
        val article = Article(
                title = "Hello, World.",
                headline = "Hello world breaks the internet!",
                content = "Bla bla bla and more bla.",
                author = anurag
        )
        entityManager.persist(article)
        entityManager.flush()

        val found = articleRepository.findById(article.id!!)

        assertThat(found.get()).isEqualTo(article)
    }
}