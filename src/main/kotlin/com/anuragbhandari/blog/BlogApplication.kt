package com.anuragbhandari.blog

import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.models.User
import com.anuragbhandari.blog.properties.BlogProperties
import com.anuragbhandari.blog.respositories.ArticleRepository
import com.anuragbhandari.blog.respositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
@EnableJpaAuditing
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}

