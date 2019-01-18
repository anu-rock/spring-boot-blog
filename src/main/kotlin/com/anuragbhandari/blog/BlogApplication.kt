package com.anuragbhandari.blog

import com.anuragbhandari.blog.models.Article
import com.anuragbhandari.blog.models.User
import com.anuragbhandari.blog.respositories.ArticleRepository
import com.anuragbhandari.blog.respositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {
//	@Bean
//	fun databaseInitializer(userRepository: UserRepository,
//							repository: ArticleRepository) = CommandLineRunner {
//		val anurag = User("anurag", "Anurag", "Bhandari", "King of this API")
//		userRepository.save(anurag)
//
//		val article1 = Article(
//				title = "Hello, World",
//				headline = "Hello world takes over the world.",
//				content = "Bla, bla, bla, bla... and more bla.",
//				author = anurag
//		)
//
//		val article2 = Article(
//				title = "Trying out Spring Boot",
//				headline = "A new trend in enterprise API development has emerged.",
//				content = "Wow, this is such a nice feeling. Divya is watching Ratatouille at the moment on TV.",
//				author = anurag
//		)
//
//		repository.save(article1)
//		repository.save(article2)
//	}
}

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}

