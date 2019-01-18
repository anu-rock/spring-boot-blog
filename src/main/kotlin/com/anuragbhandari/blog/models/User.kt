package com.anuragbhandari.blog.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
    @Id val login: String,
    val firstName: String,
    val lastName: String,
    val description: String? = null
)