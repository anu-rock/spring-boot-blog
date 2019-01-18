package com.anuragbhandari.blog.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Article(
    @Id @GeneratedValue val id: Long? = null,
    val title: String,
    val headline: String,
    val content: String,
    @ManyToOne @JoinColumn val author: User,
    val createdAt: LocalDateTime = LocalDateTime.now()
)