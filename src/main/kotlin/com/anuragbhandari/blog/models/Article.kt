package com.anuragbhandari.blog.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "articles")
@JsonIgnoreProperties(value = [ "updatedAt" ], allowGetters = true)
@EntityListeners(AuditingEntityListener::class) // will help auto-populated @CreatedDate and
                                                // @LastModifiedDate annotated properties
data class Article(
        @Id @GeneratedValue val id: Long? = null,
        var title: String,
        val headline: String,
        var content: String,
        @ManyToOne @JoinColumn val author: User,
        @CreatedDate val createdAt: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate val updatedAt: LocalDateTime = LocalDateTime.now()
)